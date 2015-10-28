package com.chamas.luis.get;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogIn extends ActionBarActivity {
    EditText EmailOrUsername, Password;
    TextView ForgotPass;
    String emailOrUserStr, passStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        EmailOrUsername = (EditText)findViewById(R.id.SignInEmailOrUsernameEditText);
        Password = (EditText)findViewById(R.id.SignInPasswordEditText);
        ForgotPass = (TextView)findViewById(R.id.SignInForgotPasswordTextView);
    }

    public void finishLogIn(View view) {
        emailOrUserStr = EmailOrUsername.getText().toString();
        passStr = Password.getText().toString();

        ParseUser.logInInBackground(emailOrUserStr, passStr, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null){
                    Toast.makeText(LogIn.this, "log in successful", Toast.LENGTH_LONG).show();
                    Intent eventlist = new Intent(LogIn.this, EventList.class);
                    LogIn.this.startActivity(eventlist);
                    LogIn.this.finish();
                }else{
                    Toast.makeText(LogIn.this, "log in failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
