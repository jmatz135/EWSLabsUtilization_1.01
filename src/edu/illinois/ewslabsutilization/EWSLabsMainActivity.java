package edu.illinois.ewslabsutilization;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;

public class EWSLabsMainActivity extends FragmentActivity {

	public static final int RESULT_SETTINGS = 1;
	private MenuItem mRefresh = null;
	public ReloadWebView autoReload;
	public WebView mWebView;
	public static boolean autoUpdateChecked = false;
	public static int updateFreq = 15;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ewslabs_main);	
		
		showUserSettings();
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 
        switch (requestCode) {
        case EWSLabsMainActivity.RESULT_SETTINGS:
        	showUserSettings();
            break;
        }
    }
	
	public void showUserSettings() {
		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		autoUpdateChecked = sharedPrefs.getBoolean(PreferencesActivity.PREF_AUTO_UPDATE, false);
	    updateFreq = 
	      Integer.parseInt(sharedPrefs.getString(PreferencesActivity.PREF_UPDATE_FREQ, "60"));
	    autoReload.cancel();
	    if (autoUpdateChecked){   
		    autoReload = new ReloadWebView(this, updateFreq, mWebView);
		    Log.e("New AutoReload", "AutoReload was redone");
	    }	    		
	}
}

