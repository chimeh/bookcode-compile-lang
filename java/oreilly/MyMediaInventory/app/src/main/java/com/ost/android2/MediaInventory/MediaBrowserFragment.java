package com.ost.android2.MediaInventory;


import com.ost.android2.MediaInventory.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.widget.Toast;
import android.webkit.URLUtil;
import android.view.View.OnClickListener;

public class MediaBrowserFragment extends Fragment  {
  private static final String TAG = "MediaBrowserFragment";
  protected Activity mActivity;
  public    String mTitle, mArtist, mURL, mURLFull;
  
  public WebView mWebView;
  public Button mBackButton, mForwardButton, mGoButton, mReloadButton;
  public TextView mURLText;
  public ProgressBar mProgressBar;
 
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
	  
	    super.onCreate(savedInstanceState);
	    Log.d(TAG, "enter OnCreate()"); 
	    
	    mActivity = getActivity();
	//*    mActivity.getWindow().requestFeature(Window.FEATURE_PROGRESS);

    setRetainInstance(true);
    
    mURLFull = null;
 
   
    Bundle extras = getActivity().getIntent().getExtras();
    if (extras != null) {
      mArtist     = extras.getString(MediaInventoryTableContract.C_ARTIST);
      mTitle      = extras.getString(MediaInventoryTableContract.C_TITLE);
      mURL        = extras.getString(MediaURLTableContract.C_URL);
      String tString = getResources().getString(R.string.browser_title);
      mActivity.setTitle(tString + " for " + mTitle + " with " + mArtist);
      Log.d(TAG, "onCreate() found " + mURL + ", " + mArtist + ", " + mTitle);

    } else {
        Log.d(TAG, "onCreate() extras missing"); 
    }
  }
  

  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedinstanceState) {
    Log.d(TAG, "OnCreateView() called"); 
    View v = inflater.inflate(R.layout.fragment_browser, parent, false);
    Log.d(TAG, "....View Inflated"); 
    
    
   mProgressBar = (ProgressBar) v.findViewById(R.id.progressBar1);
   mProgressBar.setMax(100);
   
   mWebView = (WebView) v.findViewById(R.id.webview);

   WebSettings settings = mWebView.getSettings();
   settings.setBuiltInZoomControls(true);
   settings.setSupportZoom(true);
   mWebView.getSettings().setJavaScriptEnabled(true);

   mWebView.setWebChromeClient(new WebChromeClient() {
     public void onProgressChanged(WebView view, int progress) { 
      if (progress == 100) {
    	  mProgressBar.setVisibility(View.INVISIBLE);
      } else {
    	  mProgressBar.setVisibility(View.VISIBLE);
    	  mProgressBar.setProgress(progress);
      }
     }  
   });
   
   mWebView.setWebViewClient(new WebViewClient() {
     @Override
     public void onPageFinished(WebView view, String url) {
       Log.d(TAG, "OnPageFinished");
       mBackButton.setEnabled(mWebView.canGoBack());
       mForwardButton.setEnabled(mWebView.canGoForward());
       mReloadButton.setEnabled(true);
     }
     
     @Override
     public void onReceivedError(WebView view, int errorCode, String description, String url) {
       Log.d(TAG, "OnReceivedError");
       Toast.makeText(getActivity(), "On Received Error",Toast.LENGTH_LONG).show();
       mReloadButton.setEnabled(false);
     }
     
     public boolean shouldOverrideUrlLoading(WebView view, String url)
     {
         view.loadUrl(url);
         return true;
     }    });
   
   mURLText = (TextView) v.findViewById(R.id.textViewURL);
 
   mBackButton = (Button) v.findViewById(R.id.buttonBackward);
   mBackButton.setOnClickListener(mBackButtonOnClickListener);
   mBackButton.setEnabled(false);

   mForwardButton = (Button) v.findViewById(R.id.buttonForward);
   mForwardButton.setOnClickListener(mForwardButtonOnClickListener);
   mForwardButton.setEnabled(false);
   
   mReloadButton = (Button) v.findViewById(R.id.buttonReload);
   mReloadButton.setOnClickListener(mReloadButtonOnClickListener);
   mReloadButton.setEnabled(false);

   mGoButton = (Button) v.findViewById(R.id.buttonGo);
   mGoButton.setOnClickListener(mGoButtonOnClickListener);
   mGoButton.setEnabled(true);
   
   
   getUrl(); 
  
   return v;
  }
  


  public void getUrl() {
    mURLFull = mURL.trim();
   /* if (mURLFull.substring(0,4) != "http") {
      mURLFull = "http://" + mURLFull;
    } */
    
    mURLText.setText(mURLFull);
    
    if (URLUtil.isValidUrl(mURLFull)) {
      mWebView.loadUrl(mURLFull);
    } else {
        Toast.makeText(getActivity(),  " Invalid URL " + mURLFull,Toast.LENGTH_LONG).show();
    }
  } 
  
  
  
  
  public static MediaBrowserFragment newInstance() {
    Log.d(TAG, "MediaBrowserFragment newInstance called"); 
    MediaBrowserFragment fragment = new MediaBrowserFragment();
    return fragment;
  }
  
  
  private OnClickListener mBackButtonOnClickListener = new OnClickListener() {
      @Override
      public void onClick(View v) {
          mWebView.goBack();
      }
  };

  private OnClickListener mForwardButtonOnClickListener = new OnClickListener() {
      @Override
      public void onClick(View v) {
          mWebView.goForward();
      }
  };
  
  private OnClickListener mGoButtonOnClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
        getUrl();
    }
  };

	private OnClickListener mReloadButtonOnClickListener = new OnClickListener() {
	  @Override
	  public void onClick(View v) {
	    mWebView.reload();
	  }
	};

  

}