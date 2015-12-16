package com.test.a;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
   /* 
    *@author: ZhengHaibo   
    *web:     blog.csdn.net/nuptboyzhb  
    *mail:    zhb931706659@126.com 
    *2012-8-31  Nanjing njupt 
    */
public class WebBrowser extends Activity {
   
    TextView mTitle;
    WebView mWebView; 
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        
        setControl();
        setWebStyle();
    }
    private void setControl() {
   
    	mWebView=(WebView)findViewById(R.id.webshow);
    	mTitle=(TextView)findViewById(R.id.WebTitle);
		
	}
    private void setWebStyle() {
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		mWebView.requestFocus();
		mWebView.loadUrl("http://home.cnblogs.com/u/shaojiawen/");
		//mWebView.loadUrl("http://blog.csdn.net/nuptboyzhb/");
		mWebView.setWebViewClient(new MyWebViewClient());
	}
	
	class MyWebViewClient extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view,String url_){
			view.loadUrl(url_);
			mTitle.setText("you are browsing web: "+url_);
			return true;
		}
	}
}
