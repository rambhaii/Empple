package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.empeople.Utils.UtilMethods;

import eightbitlab.com.blurview.BlurView;

public class Verification extends AppCompatActivity implements View.OnClickListener {
    ImageButton backvec;
    Button btnverification;
    BlurView blurView;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Verification.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        backvec=findViewById(R.id.backvec);
        btnverification=findViewById(R.id.verifycode);
        blurView=findViewById(R.id.blurView);
        View decorView =getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this,blurView,decorView);
              /*  new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentd= new Intent(Verification.this,createpassword.class);
                        startActivity(intentd);
                        finish();
                    }
                }
        );
        backvec.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentc=new Intent(Verification.this,forgetpassword.class);
                        startActivity(intentc);
                        finish();
                    }
                }
        );*/

    }



    @Override
    public void onClick(View v) {
        if(v==btnverification)
        {
            startActivity(new Intent(this, CreatePassword.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());


        }
    }

    }
