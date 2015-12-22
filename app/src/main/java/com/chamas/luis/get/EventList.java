package com.chamas.luis.get;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseUser;

public class EventList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

    }

    public void signOut(View view) {
        ParseUser.logOut();
        Intent logout = new Intent(this, MainActivity.class);
        startActivity(logout);
        finish();
    }
}
