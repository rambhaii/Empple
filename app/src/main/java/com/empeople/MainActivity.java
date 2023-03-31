package com.empeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.regex.Pattern;

import eightbitlab.com.blurview.BlurView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERMS_REQUEST_CODE =0;
    TextView forgotpass, signup;
    LinearLayout relativedesc;
    BlurView blurView;
    Loader loader;
    EditText userid;
    EditText password;
    Button btnsignin;
    ImageView designsign;
    Animation anifade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsignin = findViewById(R.id.btnsignin);
        forgotpass = findViewById(R.id.forgot);
        forgotpass.setOnClickListener(this);
        userid = findViewById(R.id.user_id);
        password = findViewById(R.id.pass_word);
        blurView = findViewById(R.id.blurView);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(this);
        btnsignin.setOnClickListener(this);
        designsign = findViewById(R.id.signindesgn);














        //final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitionsContainer);
        // final ImageView designsign = (ImageView) transitionsContainer.findViewById(R.id.signindesgn);

        //setting up fade animation
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        designsign.startAnimation(aniFade);


        View decorView = getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this, blurView, decorView);
        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);

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



















       /* FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg ="Done";
                        if (!task.isSuccessful()) {
                            msg ="Failed";
                        }

                    }
                });*/
       /* btnsignin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentt= new Intent(MainActivity.this,home.class);
                        startActivity(intentt);
                        finish();
                    }
                }
        );
        signup.setOnClickListener(
                new View.OnClickListener() {
                  @Override
                    public void onClick(View v) {
                        Intent intenti= new Intent(MainActivity.this,Register.class);
                        startActivity(intenti);
                        finish();
                    }
                }
        );*/



 /*   private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }  */


    @Override
    public void onClick(View v) {
        if (v == forgotpass) {
            forgotpass.setTextColor(Color.BLACK);
            Intent i = new Intent(MainActivity.this, forgetpassword.class);
            Pair[] pairs = new Pair[2];

            pairs[0] = new Pair<View, String>(forgotpass, "forgot");
            pairs[1] = new Pair<View, String>(relativedesc, "description");
            pairs[1] = new Pair<View, String>(signup, "description");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
            // start the new activity
            startActivity(i, options.toBundle());


        }

        if (v == signup) {

            if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            } else {
                //      startActivity(new Intent(this,CreateAccount.class));

                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
                finish();

            }
        }
        if (v == btnsignin) {

            if (userid.getText().toString().isEmpty()) {
                userid.setError("Please enter Userid or Email");
                userid.requestFocus();
            } else if (password.getText().toString().isEmpty()) {
                password.setError("Please enter Password");
                password.requestFocus();

            }
            else if (UtilMethods.INSTANCE.isNetworkAvialable(this)==false)
            {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            }



            else {
                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);
                UtilMethods.INSTANCE.SignIn(this, loader, password.getText().toString(), userid.getText().toString());


                // Intent i=new Intent(MainActivity.this, home.class);
                //  startActivity(i,ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                //  finish();
            }
        }

    }

    int backpress = 0;

    @Override
    public void onBackPressed() {
        backpress = (backpress + 1);
        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

        if (backpress > 1) {
            super.onBackPressed();

        }
    }
}

