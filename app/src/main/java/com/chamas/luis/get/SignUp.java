package com.chamas.luis.get;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;

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

        usernameStr = Username.getText().toString();
        emailStr = Email.getText().toString();
        passwordStr = password.getText().toString();
        confirmPassStr = ConfirmPass.getText().toString();

    }

}
