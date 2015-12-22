package com.chamas.luis.get;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class SelectRegion extends ActionBarActivity {
    ImageView region;
    Bitmap bitmap;
    TextView colorText;
    ParseUser parseUser = ParseUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);
        region = (ImageView)findViewById(R.id.regionImageView);
        colorText = (TextView)findViewById(R.id.ColorRegionText);

        region.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                final int action = ev.getAction();
                final int evx = (int)ev.getX();
                final int evy = (int)ev.getY();

                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        //  if(curren)
                        break;
                    case MotionEvent.ACTION_UP:
                        bitmap = ((BitmapDrawable)region.getDrawable()).getBitmap();
                        int pixel = bitmap.getPixel(evx, evy);
                        Log.d("region color: ", String.valueOf(pixel));
                        int redValue = Color.red(pixel);
                        int blueValue = Color.blue(pixel);
                        int greenValue = Color.green(pixel);
                        int rgb = Color.rgb(redValue, greenValue, blueValue);
                        String RGBhex = Integer.toHexString(pixel);
                        Log.d("rgb values: ", "red: " + String.valueOf(redValue) + ", blue: " + String.valueOf(blueValue) + ", green: " + String.valueOf(greenValue));
                        Log.d("real RGBhex", RGBhex);
                        Log.d("rgb from color", String.valueOf(rgb));


                        if(pixel == Color.RED){
                            colorText.setText("Color is red");
                        }else if (pixel == Color.GREEN){
                            colorText.setText("color is green");
                        }else if(pixel == Color.BLUE){
                            colorText.setText("color is blue");
                        }else if(pixel == Color.YELLOW){
                            colorText.setText("color is yellow");
                        }else{
                            colorText.setText("Can't decide");
                        }

//                int touchColor = getHotspotColor(R.id.regionImageView, evx, evy);
//                ColorTool ct = new ColorTool();
                }

                return false;
            }
        });
    }

    public boolean onTouch(View v, MotionEvent ev){

        final int action = ev.getAction();
        final int evx = (int)ev.getX();
        final int evy = (int)ev.getY();

        switch (action){
            case MotionEvent.ACTION_DOWN:
              //  if(curren)
                break;
            case MotionEvent.ACTION_UP:
                bitmap = ((BitmapDrawable)region.getDrawable()).getBitmap();
                int pixel = bitmap.getPixel(evx, evy);
                int redVal = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);

                if(pixel == Color.RED){
                    colorText.setText("Color is red");
                }else if (pixel == Color.GREEN){
                    colorText.setText("color is green");
                }else if(pixel == Color.BLUE){
                    colorText.setText("color is blue");
                }else if(pixel == Color.YELLOW){
                    colorText.setText("color is yellow");
                }else{
                    colorText.setText("Can't decide");
                }

//                int touchColor = getHotspotColor(R.id.regionImageView, evx, evy);
//                ColorTool ct = new ColorTool();
        }

        return true;
    }

    public void selRegion(View view) {

    }

    public void westRegion(View view) {
        parseUser.put("Region", "Oeste");
        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SelectRegion.this, "region selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SelectRegion.this, EventList.class);
                    SelectRegion.this.startActivity(intent);
                    SelectRegion.this.finish();
                }else{
                    Toast.makeText(SelectRegion.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    Log.d("DEBUG", "PARSE EXCEPTION: " + e.toString());
                }
            }
        });
    }

    public void southRegion(View view) {
        parseUser.put("Region", "Sur");
        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SelectRegion.this, "region selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SelectRegion.this, EventList.class);
                    SelectRegion.this.startActivity(intent);
                    SelectRegion.this.finish();
                }else{
                    Toast.makeText(SelectRegion.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    Log.d("DEBUG", "PARSE EXCEPTION: " + e.toString());
                }
            }
        });
    }

    public void northRegion(View view) {
        parseUser.put("Region", "Norte");
        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SelectRegion.this, "region selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SelectRegion.this, EventList.class);
                    SelectRegion.this.startActivity(intent);
                    SelectRegion.this.finish();
                }else{
                    Toast.makeText(SelectRegion.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    Log.d("DEBUG", "PARSE EXCEPTION: " + e.toString());
                }
            }
        });
    }

    public void metroRegion(View view) {
        parseUser.put("Region", "Metro");
        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SelectRegion.this, "region selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SelectRegion.this, EventList.class);
                    SelectRegion.this.startActivity(intent);
                    SelectRegion.this.finish();
                }else{
                    Toast.makeText(SelectRegion.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    Log.d("DEBUG", "PARSE EXCEPTION: " + e.toString());
                }
            }
        });
    }

    public void eastRegion(View view) {
        parseUser.put("Region", "Este");
        parseUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SelectRegion.this, "region selected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SelectRegion.this, EventList.class);
                    SelectRegion.this.startActivity(intent);
                    SelectRegion.this.finish();
                }else{
                    Toast.makeText(SelectRegion.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    Log.d("DEBUG", "PARSE EXCEPTION: " + e.toString());
                }
            }
        });
    }
}
