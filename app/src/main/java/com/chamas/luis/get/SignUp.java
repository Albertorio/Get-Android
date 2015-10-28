package com.chamas.luis.get;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends ActionBarActivity {
    private EditText Username, Email, password, ConfirmPass;
    private Button SignupButton;
    private String usernameStr, emailStr, passwordStr, confirmPassStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username = (EditText)findViewById(R.id.SignUpUsernameEditText);
        Email = (EditText)findViewById(R.id.SignUpEmailEditText);
        password = (EditText)findViewById(R.id.SignUpPasswordEditText);
        ConfirmPass = (EditText)findViewById(R.id.SignUpConfirmPasswordEditText);
        SignupButton = (Button)findViewById(R.id.SignUpButton);

    }

    public void finishSignUp(View view) {
        usernameStr = Username.getText().toString();
        emailStr = Email.getText().toString();
        passwordStr = password.getText().toString();
       // confirmPassStr = ConfirmPass.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(usernameStr);
        user.setPassword(passwordStr);
        user.setEmail(emailStr);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SignUp.this, "sign up successful",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUp.this, "failed", Toast.LENGTH_LONG).show();
                    Log.d("parse error", e.toString());
                }
            }
        });
    }
}
