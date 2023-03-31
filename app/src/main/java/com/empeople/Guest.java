package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.empeople.Utils.UtilMethods;
import com.smb.glowbutton.GlowButton;
import com.smb.glowbutton.NeonButton;

public class Guest extends AppCompatActivity implements View.OnClickListener {
    NeonButton signin;
    NeonButton signup;
    TextView browse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        signin=findViewById(R.id.btin);
        signup=findViewById(R.id.btup);
        browse=findViewById(R.id.browse);
        signin.setOnClickListener(this);
        signin.setGradientStart(getResources().getColor(R.color.white70));
        signin.setGradientEnd(getResources().getColor(R.color.white70));
        signup.setGradientStart(getResources().getColor(R.color.white70));
        signup.setGradientEnd(getResources().getColor(R.color.white70));

        signup.setOnClickListener(this);
        browse.setOnClickListener(this);


        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView = getWindow().getDecorView();

                decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
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


















    @Override
    public void onClick(View v) {
        if (v==signin)
        {
            Intent y= new Intent(Guest.this,MainActivity.class);
            startActivity(y);
            finish();
        }
        else if (v==signup) {
            if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            } else {
                Intent z = new Intent(Guest.this, Register.class);
                startActivity(z);
                finish();
            }
        }

      else if (v==browse)
        {
            Intent q = new Intent(Guest.this,home.class);
            startActivity(q);
            finish();
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