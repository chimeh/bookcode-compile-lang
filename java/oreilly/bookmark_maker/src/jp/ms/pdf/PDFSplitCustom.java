package jp.ms.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.Splitter;

/**
 * 公式で実装されているPDFSplitクラスだと若干都合が悪いので、微修正して再実装。
 *
 * @author mshoj
 */

//TODO とクラスの説明に書いたものの実際は継承した方が良いような気がしてきたので、そのうちリファクタリングしたい。
public class PDFSplitCustom {

	public List<String> split(String fileName) throws Exception {
		String password = "";
		int split = 25;
		List<String> fileNameList = new ArrayList<String>();
		Splitter splitter = new Splitter();

		if (fileName == null) {
			usage();
		} else {

			InputStream input = null;
			PDDocument document = null;
			List<PDDocument> documents = null;
			try {
				input = new FileInputStream(fileName);
				document = parseDocument(input);

				if (document.isEncrypted()) {
					try {
						document.decrypt(password);
					} catch (InvalidPasswordException e) {
						System.err.println("Error: The document is encrypted.");
						usage();
					}
				}

				splitter.setSplitAtPage(split);
				documents = splitter.split(document);
				File file = new File(fileName);
                String dirName = getDirName(file);
                // 作業対象のPDFファイルがあるディレクトリに「__tmp__」ディレクトリを作成します。
                dirName = mkTmpDir(dirName);
                String pdfFileName = file.getName();

				for (int i = 0; i < documents.size(); i++) {
					PDDocument doc = (PDDocument) documents.get(i);
                    String tmpFileName = dirName + pdfFileName.substring(0, pdfFileName.length()-4 ) + "-" + i + ".pdf";
					writeDocument(doc, tmpFileName);
					fileNameList.add(tmpFileName);
					doc.close();
				}

			} finally {
				if (input != null) {
					input.close();
				}
				if (document != null) {
					document.close();
				}
				for (int i = 0; documents != null && i < documents.size(); i++) {
					PDDocument doc = (PDDocument) documents.get(i);
					doc.close();
				}
			}
		}
		return fileNameList;
	}

	private static final void writeDocument(PDDocument doc, String fileName)
			throws IOException, COSVisitorException {
		FileOutputStream output = null;
		COSWriter writer = null;
		try {
			output = new FileOutputStream(fileName);
			writer = new COSWriter(output);
			writer.write(doc);
		} finally {
			if (output != null) {
				output.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * This will parse a document.
	 *
	 * @param input
	 *            The input stream for the document.
	 *
	 * @return The document.
	 *
	 * @throws IOException
	 *             If there is an error parsing the document.
	 */
	private static PDDocument parseDocument(InputStream input)
			throws IOException {
		PDFParser parser = new PDFParser(input);
		parser.parse();
		return parser.getPDDocument();
	}

	/**
	 * This will print the usage requirements and exit.
	 */
	private static void usage() {
		System.err
				.println("Usage: java org.apache.pdfbox.PDFSplit [OPTIONS] <PDF file>\n"
						+ "  -password  <password>        Password to decrypt document\n"
						+ "  -split     <integer>         split after this many pages\n"
						+ "  <PDF file>                   The PDF document to use\n");
		System.exit(1);
	}

	public static String getDirName(File file){
        String dirName = "";
        int last = file.getAbsolutePath().lastIndexOf(file.getName());
        dirName = file.getAbsolutePath().substring(0, last);
        return dirName;
	}

	/**
	 * PDFファイルがあるフォルダ内「に__tmp__」フォルダを作成します。
	 * @param dirPath
	 */
	private String mkTmpDir(String dirPath) throws Exception{
		String path = dirPath + "__tmp__/";
		File file = new File(path);
		if(!file.mkdir()){
			throw new Exception("作業場所が確保できませんでした。__tmp__ディレクトリの名称を変更するか、移動してください。");
		}
		return path;
	}

}
