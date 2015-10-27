package com.chamas.luis.get;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.TextView;

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

        emailOrUserStr = EmailOrUsername.getText().toString();
        passStr = Password.getText().toString();
    }

}
