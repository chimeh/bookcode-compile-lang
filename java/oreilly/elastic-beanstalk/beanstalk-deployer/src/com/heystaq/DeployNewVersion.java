package com.heystaq;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalk;
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalkClient;
import com.amazonaws.services.elasticbeanstalk.model.CreateApplicationVersionRequest;
import com.amazonaws.services.elasticbeanstalk.model.CreateApplicationVersionResult;
import com.amazonaws.services.elasticbeanstalk.model.S3Location;
import com.amazonaws.services.elasticbeanstalk.model.UpdateEnvironmentRequest;
import com.amazonaws.services.elasticbeanstalk.model.UpdateEnvironmentResult;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

/**
 * This class deploys a given war as a new version in an Elastic Beanstalk environment.
 * 
 * It will first upload the given war to S3,
 * then add it to Elastic Beanstalk as a new version with the current date,
 * and finally deploy it in the Elastic Beanstalk "test" environment.
 * 
 * @author flavia
 *
 */
public class DeployNewVersion {

	private static final Log log = LogFactory.getLog(DeployNewVersion.class);
	
	private AWSCredentials credentials;

	private String versionLabel;
	private String bucketName;
	private String warName;
	
	private Upload upload;
	private AWSElasticBeanstalk beanstalk;

	public DeployNewVersion(String versionLabel, String bucketName, String warName) throws Exception {
		
		// Get credentials from properties file
		credentials = new PropertiesCredentials(DeployNewVersion.class
                .getResourceAsStream("AwsCredentials.properties"));

		beanstalk = new AWSElasticBeanstalkClient(credentials);
		
		this.versionLabel = versionLabel;
		this.bucketName = bucketName;
		this.warName = warName;

	}
	
	public void execute(final String fileName, final FinishedListener listener) 
		throws FileNotFoundException {
		// first upload the war to S3
        File warToUpload = new File(fileName);
        if (!warToUpload.exists()) {
        	throw new FileNotFoundException();
        }

        // A ProgressListener will receive updates about the uploading
        // of the file, and we can know when it is finished
        ProgressListener progressListener = new ProgressListener() {
            public void progressChanged(ProgressEvent progressEvent) {
                if (upload == null) return;
                
                switch (progressEvent.getEventCode()) {
                case ProgressEvent.COMPLETED_EVENT_CODE:
                    // done uploading war! now create the new version in Beanstalk
                	log.info("War "+ fileName+" has been uploaded.");

                	try {
	                	createApplicationVersion();
	            		deployVersion();
                	} catch (AmazonClientException e) {
                		if (listener !=null) listener.failed(e);
                	}
                    break;
                case ProgressEvent.FAILED_EVENT_CODE:
                    try {
                        AmazonClientException e = upload.waitForException();
                        log.error("Unable to upload file "+fileName+" to Amazon S3: " + e.getMessage(), e); 
                    } catch (InterruptedException e) {}
                    break;
                }
            }
        };
        
        TransferManager transferManager = new TransferManager(credentials);

        PutObjectRequest request = new PutObjectRequest(
                bucketName, warName, warToUpload)
            .withProgressListener(progressListener);
        
        // create the bucket if it doesn't already exist
        createS3Bucket(transferManager);
        
        log.info("Uploading war to S3...");
        upload = transferManager.upload(request);
	}

	/**
	 * 
	 * @param fileName the file location of the war to upload
	 */
	public void execute(final String fileName) throws FileNotFoundException {

		execute(fileName, null);

      }
	
	/**
	 * Create an Elastic Beanstalk application version for this war,
	 * indicating its location in S3.
	 */
	private void createApplicationVersion() throws AmazonClientException {
		SimpleDateFormat friendlyDateFormat = new SimpleDateFormat("dd MMM yyy HH:mm");
		
		log.info("Creating application version " + versionLabel);

		CreateApplicationVersionRequest request = 
			new CreateApplicationVersionRequest("heystaq", versionLabel);
		request.setDescription("War created by Hudson maven on " + friendlyDateFormat.format(new Date()));
		request.setSourceBundle(new S3Location(bucketName, warName));
		
		CreateApplicationVersionResult result = beanstalk.createApplicationVersion(request);
		
		log.info("Version " + result.getApplicationVersion().getVersionLabel() + " has been created.");
		log.info("Version details: " + result.getApplicationVersion());

	}
	
	/**
	 * Deploy the newly created version to the test environment.
	 */
	private void deployVersion() throws AmazonClientException {
		
		String environmentName = "test";
		log.info("Updating environment "+environmentName+" with version " +versionLabel);
		UpdateEnvironmentRequest request = new UpdateEnvironmentRequest();
		request.setEnvironmentName(environmentName);
		request.setVersionLabel(versionLabel);
		
		UpdateEnvironmentResult result = beanstalk.updateEnvironment(request);
		log.info("SUCCESS! Version deploy requested. Test environment is now " + result.getStatus());
		
	}

    private void createS3Bucket(TransferManager transferManager) {
        try {
            if (transferManager.getAmazonS3Client().doesBucketExist(bucketName) == false) {
                transferManager.getAmazonS3Client().createBucket(bucketName);
            }
        } catch (AmazonClientException ace) {
            log.error("Unable to create a new Amazon S3 bucket: " + ace.getMessage(), ace);
        }
    }
    
	/**
	 * @param args one argument containing the location of the war to deploy
	 */
	public static void main(String[] args) throws Exception {

		if (args.length < 1) {
			System.out.println("Required argument: location of war to upload");
			System.exit(0);
		}

		FinishedListener listener = new FinishedListener() {
			@Override
			public void succeeded() {
				System.exit(0);
			}
			@Override
			public void failed(Throwable e) {
				System.exit(1);
			}
		};
		
		String fileName = args[0];
		try {

			// the version label will be of the form "heystaq-test_20110520T1450"
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm");
			String versionLabel = "heystaq-test_" + dateFormat.format(new Date());
			
			// the name that we give to the S3 resource containing the war is "heystaq-test_20110520T1450.war"
			// and the S3 bucket where we upload the wars is called "hudson-wars"
			DeployNewVersion deployer = new DeployNewVersion(
					versionLabel,
					"hudson-wars",
					versionLabel + ".war");
			
			deployer.execute(fileName, listener);
		} catch (FileNotFoundException e) {
        	System.out.println("Sorry, the file "+fileName+" doesn't exist");
        	System.exit(0);
		}

	}
	
	private interface FinishedListener {
		void succeeded();
		void failed(Throwable e);
	}

}
