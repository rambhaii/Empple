package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.empeople.Data.Data;
import com.empeople.Utils.ApplicationConstant;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import de.hdodenhof.circleimageview.CircleImageView;
import eightbitlab.com.blurview.BlurView;

public class HomeSignup extends AppCompatActivity implements View.OnClickListener {

    CircleImageView bell, list;
    CircleImageView prof;
    TextView tvleft, tvright, btconfirm;
    EditText etid;
    Loader loader;
    String referenceId;
    String user_id;
    String position="L";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        loader.dismiss();
    }

    BlurView blur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_signup);
        bell = findViewById(R.id.notif);
        list = findViewById(R.id.list);
        prof = findViewById(R.id.image_profile);
        tvleft = findViewById(R.id.btleft);
        tvright = findViewById(R.id.btright);
        etid = findViewById(R.id.et_id);
        btconfirm = findViewById(R.id.btconfirm);
        btconfirm.setOnClickListener(this);
        bell.setOnClickListener(this);
        list.setOnClickListener(this);
        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        blur = findViewById(R.id.blurt);
        View decorView = getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this, blur, decorView);

        tvright.setOnClickListener(this);
        tvleft.setOnClickListener(this);
        SharedPreferences myPreferences = getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        referenceId = securelogincheckResponse.getId();
        String pic = securelogincheckResponse.getProfile();
        user_id=securelogincheckResponse.getUserID();
        // Toast.makeText(getActivity(), ""+pic, Toast.LENGTH_SHORT).show();
        Log.d("sdvdsvdsvsdvdsvds: .", pic);
        // name.setText(name + "!");
        Glide.with(HomeSignup.this)
                .load(pic)
                .into(prof);

        etid.setText(user_id);


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





    @Override
    public void onClick(View v) {

        if (v==tvleft)
        {
            position="L";
            tvleft.setBackgroundResource(R.drawable.oval_btn_green);
            tvright.setBackgroundResource(R.drawable.ic_ovalbtn);
        }
        if (v==tvright)
        {
            position="R";
            tvright.setBackgroundResource(R.drawable.oval_btn_green);
            tvleft.setBackgroundResource(R.drawable.ic_ovalbtn);
        }



       if (v==btconfirm)
        {
            loader.show();
            loader.setCancelable(false);
            loader.setCanceledOnTouchOutside(false);
             UtilMethods.INSTANCE.getpickReferral(this,loader,referenceId,"2",position);
          //  Toast.makeText(this, ""+referenceId, Toast.LENGTH_SHORT).show();
        }
        if (v== bell)
        {
            startActivity(new Intent(HomeSignup.this,Settings.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
        else if (v==list)
        {
            startActivity(new Intent(HomeSignup.this,Notification.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }

    }
}


























         /*   btconfirm.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {

                                                 if(v==btconfirm)
                                                 {
                                                     loader.show();
                                                     loader.setCancelable(false);
                                                     loader.setCanceledOnTouchOutside(false);
                                                     UtilMethods.INSTANCE.getpickReferral(HomeSignup.this,loader,referenceId,"2");
                                                 }


                                             }
                                         }

            );

           bell.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent x = new Intent(HomeSignup.this,Settings.class);
                   startActivity(x);
                   finish();
               }
           });

           list.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent b= new Intent(HomeSignup.this,Notification.class);
                   startActivity(b);
                   finish();
               }
           });


        }


        @Override
        public void onClick(View v) {


        }
    }  */

