package edu.illinois.ewslabsutilization;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;

public class ReloadWebView extends TimerTask{

	Activity context;
    Timer timer;
    WebView wv;

    public ReloadWebView(Activity context, int minutes, WebView wv) {
        this.context = context;
        this.wv = wv;

        timer = new Timer();
        /* execute the first task after seconds */
        timer.schedule(this,
        		minutes * 60 * 1000,  // initial delay
    			minutes * 60 * 1000); // subsequent rate

        /* if you want to execute the first task immediatly */
        /*
        timer.schedule(this,
                0,               // initial delay null
                seconds * 1000); // subsequent rate
        */
    }

    public void reScheduleTimer(Activity context, int minutes, WebView wv) {
    	this.context = context;
    	this.wv = wv;
    	
    	timer.schedule(this,
    			minutes * 60 * 1000,
    			minutes * 60 * 1000);
    }
    
    @Override
    public void run() {
        if(context == null || context.isFinishing()) {
            // Activity killed
            this.cancel();
            return;
        }

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
            	if (EWSLabsMainActivity.autoUpdateChecked){
            		wv.reload();
            		Log.e("Refresh", "Auto Refresh Happened");           	
            	}
            }
        });
    }
}

