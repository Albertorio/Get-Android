package com.chamas.luis.get;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class SetUpProfile extends ActionBarActivity {
    private Spinner sexSelect;
    private EditText name, age, bio;
    private String usernameFromParse;
    private TextView UserName;
    ParseUser parseUser = ParseUser.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_profile);
        sexSelect = (Spinner)findViewById(R.id.GenderSetUpSpinner);
        name = (EditText)findViewById(R.id.NameSetUpEditText);
        UserName = (TextView)findViewById(R.id.UsernameSetUpTextView);
        age = (EditText)findViewById(R.id.AgeSetUpEditText);
        bio = (EditText)findViewById(R.id.BioSetUpEditText);

        String[] items = new String[]{"Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        sexSelect.setAdapter(adapter);

        usernameFromParse = "<u>" + parseUser.getUsername().toString() + "</u>";
        UserName.setText(parseUser.getUsername().toString());

    }

    public void changeProfilePic(View view) {


    }

    public void finishSetUp(View view) throws ParseException {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving profile");
        progressDialog.show();
        parseUser.put("Name", name.getText().toString());
        parseUser.put("Sex", sexSelect.getSelectedItem().toString());
        parseUser.put("Bio", bio.getText().toString());
        parseUser.put("Age", Integer.parseInt(age.getText().toString()));
        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SetUpProfile.this, "setup success", Toast.LENGTH_LONG).show();
                    Intent region = new Intent(SetUpProfile.this, SelectRegion.class);
                    SetUpProfile.this.startActivity(region);
                    SetUpProfile.this.finish();
                } else {
                    Toast.makeText(SetUpProfile.this, "setup failed", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            }
        });


    }
}
