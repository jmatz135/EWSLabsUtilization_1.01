package edu.illinois.ewslabsutilization;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebViewFragment extends Fragment{
		
	//WebView fWebView;
	//ReloadWebView autoReload;
	
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);	   
	    setHasOptionsMenu(true);
	  }
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.ewslabs_main, menu);
		MenuItem mRefresh = menu.findItem(R.id.menu_refresh);	
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View mainView = (View) inflater.inflate(R.layout.webview_fragment, container, false); 	
    	((EWSLabsMainActivity)getActivity()).mWebView = (WebView) mainView.findViewById(R.id.wv1);   	
        WebSettings webSettings = ((EWSLabsMainActivity)getActivity()).mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        ((EWSLabsMainActivity)getActivity()).mWebView.loadUrl("file:///android_asset/www/LabsUtilization.html");  
        ((EWSLabsMainActivity)getActivity()).autoReload = new ReloadWebView((EWSLabsMainActivity)getActivity(), EWSLabsMainActivity.updateFreq, ((EWSLabsMainActivity)getActivity()).mWebView);
        return mainView;
    }
    
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_refresh){
        	((EWSLabsMainActivity)getActivity()).mWebView.reload();
            return true;
        }       
        else if(item.getItemId() == R.id.menu_settings){
        	Intent i = new Intent((EWSLabsMainActivity)getActivity(), PreferencesActivity.class);
            getActivity().startActivityForResult(i, EWSLabsMainActivity.RESULT_SETTINGS);	    
        	return true;
        }
        return true;
    }



}
