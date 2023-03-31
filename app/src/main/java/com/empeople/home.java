package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.empeople.Adapters.SliderAdapterExample;
import com.empeople.Data.Data;
import com.empeople.Data.SliderModel;
import com.empeople.Data.SubSliderModel;
import com.empeople.Utils.ApplicationConstant;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.gson.Gson;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smb.glowbutton.NeonButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ss.com.bannerslider.Slider;

public class home extends AppCompatActivity implements View.OnClickListener {
    CircleImageView dashboard,opinion,purchase,quiz;
    NeonButton registernow;
    CircleImageView notify,list,search;
    Loader loader;
    CircleImageView prof;
    String referenceId;
    Context context;
    private Slider slider;
    List<SliderModel> sliderModelList = new ArrayList<>();
  //  List<SubSliderModel> subSliderModelList = new ArrayList<>();

    int backpress =0;
    @Override
    public void onBackPressed() {
       backpress = (backpress + 1);
        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

        if (backpress > 1) {
            super.onBackPressed();
        }
    }


    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        prof=findViewById(R.id.profile_image);
        dashboard=findViewById(R.id.btn_clipboard);
        purchase=findViewById(R.id.btn_purchase);
        //  search=findViewById(R.id.mag);
        opinion=findViewById(R.id.btn_opinion);
         registernow=findViewById(R.id.register);

        registernow.setGradientStart(getResources().getColor(R.color.white70));
        registernow.setGradientEnd(getResources().getColor(R.color.white70));
        registernow.setOnClickListener(this);
        purchase.setOnClickListener(this);
        quiz=findViewById(R.id.btn_quiz);
        notify=findViewById(R.id.notif);
        notify.setOnClickListener(this);
        list=findViewById(R.id.seting);
        list.setOnClickListener(this);
        loader = new Loader(this,android.R.style.Theme_Translucent_NoTitleBar);
        dashboard.setOnClickListener(this);
        purchase.setOnClickListener(this);
        SharedPreferences myPreferences = getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        referenceId=securelogincheckResponse.getId();
     //   String tvname = securelogincheckResponse.getName();
        String pic = securelogincheckResponse.getProfile();
        // Toast.makeText(getActivity(), ""+pic, Toast.LENGTH_SHORT).show();
        Log.d("sdvdsvdsvsdvdsvds: .", pic);
        // name.setText(name + "!");
        Glide.with(home.this)
                .load(pic)
                .into(prof);

        sliderModelList.add(new SliderModel(R.drawable.bnrc,R.drawable.bnrc));
       // subSliderModelList.add(new SubSliderModel(R.drawable.bnrb));
        sliderModelList.add(new SliderModel(R.drawable.bnra,R.drawable.bnrc));



        SliderView sliderView = findViewById(R.id.sliderimage);
        sliderView.setSliderAdapter(new SliderAdapterExample(home.this,sliderModelList));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SLIDE);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();


        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.BLUE);
        sliderView.setScrollTimeInSec(4);

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
















 /*       dashboard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentv= new Intent(home.this,Dashboard.class);
                        startActivity(intentv);
                                finish();
                    }
                }
        );


        pressbck.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentz= new Intent(home.this,MainActivity.class);
                        startActivity(intentz);
                        finish();

                    }
                }
        ); */




    @Override
    public void onClick(View v) {
        if(v==dashboard) {
            if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(home.this, Dashboard.class), ActivityOptions.makeSceneTransitionAnimation(home.this).toBundle());
            }
        }
        if (v==purchase)
        {
          startActivity(new Intent(home.this,Purchase.class),ActivityOptions.makeSceneTransitionAnimation(home.this).toBundle());

        }
        else if(v==registernow)
        {

            loader.show();
            loader.setCancelable(false);
            loader.setCanceledOnTouchOutside(false);
            //   UtilMethods.INSTANCE.getpickReferral(this,loader,referenceId,"2");
            startActivity(new Intent(home.this, HomeSignup.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            loader.dismiss();
        }
        else if (v==notify)
        {
            startActivity(new Intent(home.this, Notification.class), ActivityOptions.makeSceneTransitionAnimation(home.this).toBundle());
        }
        else if (v==list)
        {
            startActivity(new Intent(home.this, Settings.class), ActivityOptions.makeSceneTransitionAnimation(home.this).toBundle());
        }

    }
}



