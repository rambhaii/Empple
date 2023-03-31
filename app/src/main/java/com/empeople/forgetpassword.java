package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;

import eightbitlab.com.blurview.BlurView;

public class forgetpassword extends AppCompatActivity implements View.OnClickListener {
    ImageButton bk;
    Button submit, esubmit;
    EditText userId, email;
    BlurView blurView;
    Loader loader;
    TextView tryanotherway, tryuid;
    ImageView passdesign;
    Animation animfade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        bk = findViewById(R.id.bk);
        email = findViewById(R.id.email);
        tryuid = findViewById(R.id.tryuid);
        tryuid.setVisibility(View.INVISIBLE);
        tryuid.setOnClickListener(this);
        email.setVisibility(View.INVISIBLE);
        userId = findViewById(R.id.userid);
        bk.setOnClickListener(this);
        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
        tryanotherway = findViewById(R.id.tryanother);
        tryanotherway.setOnClickListener(this);
       esubmit = findViewById(R.id.emailsubmit);
       esubmit.setOnClickListener(this);
        esubmit.setVisibility(View.INVISIBLE);

        //setting up fade animation
        passdesign = findViewById(R.id.passdesign);
        Animation animfade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        passdesign.setAnimation(animfade);

        blurView = findViewById(R.id.blurView);
        View decorView = getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this, blurView, decorView);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView1 = getWindow().getDecorView();
        decorView
                .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
                {

                    @Override
                    public void onSystemUiVisibilityChange(int visibility)
                    {
                        if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                        {
                            decorView.setSystemUiVisibility(flags);
                        }
                    }
                });
    }




    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }




    /*    submit.setOnClickListener(new View.OnClickListener() {

            @Override
             public void onClick(View v) {
                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);
                UtilMethods.INSTANCE.forgotPassword(forgetpassword.this, loader, userId.getText().toString());
            }
        });
        blurView = findViewById(R.id.blurView);
        View decorView = getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this, blurView, decorView);  */


    @Override
    public void onClick(View v) {
        if (v == bk) {
            startActivity(new Intent(forgetpassword.this, MainActivity.class),
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            finish();
        }
        if (v == submit) {
            if (userId.getText().toString().isEmpty()) {
                userId.setError("Please enter userid");
                userId.requestFocus();
            }
            if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            } else {
                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);
                UtilMethods.INSTANCE.forgotPassword(forgetpassword.this, loader, userId.getText().toString());

            }
        }


        if (v == tryanotherway) {
            userId.setVisibility(View.GONE);
            email.setVisibility(View.VISIBLE);
            tryanotherway.setVisibility(View.GONE);
            tryuid.setVisibility(View.VISIBLE);
            esubmit.setVisibility(View.VISIBLE);
            submit.setVisibility(View.GONE);
        }


            if (v == esubmit) {
                if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                    Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();

                }
          /*      else if (email.getText().toString().isEmpty()) {
                    email.setError("Please enter userid");
                    email.requestFocus();
                }  */
                else {
                    loader.show();
                    loader.setCancelable(false);
                    loader.setCanceledOnTouchOutside(false);
                    UtilMethods.INSTANCE.EmailLogin(forgetpassword.this, loader, email.getText().toString());
                }
            }


      /*      submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loader.show();
                    loader.setCancelable(false);
                    loader.setCanceledOnTouchOutside(false);
                    UtilMethods.INSTANCE.EmailLogin(forgetpassword.this, loader, email.getText().toString());
                }
            });
            blurView = findViewById(R.id.blurView);
            View decorView = getWindow().getDecorView();
            UtilMethods.INSTANCE.blur(this, blurView, decorView);
        }    */
            if (v == tryuid) {
                email.setVisibility(View.GONE);
                userId.setVisibility(View.VISIBLE);
                tryanotherway.setVisibility(View.VISIBLE);
                tryuid.setVisibility(View.GONE);
            }
        }
    }










       /* cnewpass.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentk=new Intent(forgetpassword.this,Verification.class);
                        startActivity(intentk);
                        finish();
                    }
                }
        );
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intenta= new Intent(forgetpassword.this,MainActivity.class);
                        startActivity(intenta);
                        finish();
                    }
                }
        );*/








