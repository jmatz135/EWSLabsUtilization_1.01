package edu.illinois.ewslabsutilization;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity{

	public static final String PREF_AUTO_UPDATE = "PREF_AUTO_UPDATE";
	public static final String PREF_UPDATE_FREQ = "PREF_UPDATE_FREQ";

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  addPreferencesFromResource(R.layout.preferences);
	}
}
