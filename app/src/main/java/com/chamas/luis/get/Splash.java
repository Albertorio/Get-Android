package com.chamas.luis.get;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

import com.parse.Parse;
import com.parse.ParseUser;

public class Splash extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "T4mKLSOGaa3dLavmKuvMlLvuXClmAdHxj295mOzc", "6KjuRBv415crv76Go4vqQyUD9Nt7pbCBS5CrLvQB");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ParseUser currentUser = ParseUser.getCurrentUser();
                if(currentUser != null){
                    Intent eventIntent = new Intent(Splash.this, EventList.class);
                    Splash.this.startActivity(eventIntent);
                    Splash.this.finish();
                }else{
                    Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                    Splash.this.startActivity(mainIntent);
                    Splash.this.finish();
                }
            }
        }, 2000);
    }
}

