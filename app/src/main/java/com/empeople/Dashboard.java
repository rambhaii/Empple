package com.empeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.empeople.Data.Data;
import com.empeople.Utils.ApplicationConstant;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.gson.Gson;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout btntopright,btntopleft,btnbottomright,btnbottomleft;
    ImageView backarrow,imgtopleft,ivtopleft,imgtopright,ivtopright,imgbottomleft,ivbottomleft,imgbottomright,ivbottomright,profile_image;
    TextView tvtopleft,tvtopright,tvbottomleft,tvbottomright;
    Loader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initilization();
        btnbottomright.setOnClickListener(this);
        btnbottomleft.setOnClickListener(this);
        btntopleft.setOnClickListener(this);
        btntopright.setOnClickListener(this);
        backarrow.setOnClickListener(this);
        loadFragment(new NewJoin());
        btntopleft.setBackground(this.getDrawable(R.drawable.btntopleft));
        tvtopleft.setVisibility(View.GONE);
        ivtopleft.setVisibility(View.GONE);
        imgtopleft.setVisibility(View.VISIBLE);
        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        loader.show();
        loader.setCancelable(false);
        loader.setCanceledOnTouchOutside(false);
        UtilMethods.INSTANCE.getAllPoints(this,loader);
        SharedPreferences myPreferences = getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, +MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        String pic=securelogincheckResponse.getProfile();
        // Toast.makeText(getActivity(), ""+pic, Toast.LENGTH_SHORT).show();
        Log.d( "sdvdsvdsvsdvdsvds: .",pic);

        Glide.with(this)
                .load(pic)
                .into(profile_image);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView = getWindow().getDecorView();

               decorView .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
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












    private void initilization() {
        btntopright = findViewById(R.id.topright);
        btntopleft = findViewById(R.id.topleft);
        btnbottomleft = findViewById(R.id.bottomleft);
        btnbottomright = findViewById(R.id.bottomRight);
        backarrow = findViewById(R.id.backarrow);
        imgtopleft = findViewById(R.id.imgtopleft);
        ivtopleft = findViewById(R.id.ivtopleft);
        tvtopleft = findViewById(R.id.tvtopleft);
        profile_image = findViewById(R.id.profile_image);
        imgtopright = findViewById(R.id.imgtopright);
        ivtopright = findViewById(R.id.ivtopright);
        tvtopright = findViewById(R.id.tvtopright);
        imgbottomleft = findViewById(R.id.imgbottomleft);
        ivbottomleft = findViewById(R.id.ivbottomleft);
        tvbottomleft = findViewById(R.id.tvbottomleft);
        imgbottomright = findViewById(R.id.imgbottomright);
        ivbottomright = findViewById(R.id.ivbottomRight);
        tvbottomright = findViewById(R.id.tvbottomRight);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("DASHBOARD");
        toolbar.setTitleTextAppearance(this,R.style.JosefinSans);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_new_24);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });
    }






    @Override
    public void onClick(View v) {
        if(v==backarrow)
        {
            startActivity(new Intent(this,Dashboard.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }



        if (v==btnbottomleft)
        {
            loadFragment(new NewMatch());
            btnbottomleft.setBackground(this.getResources().getDrawable(R.drawable.btnbottomleft));
            btnbottomright.setBackground(this.getResources().getDrawable(R.drawable.bottomrightquadrant));
            btntopleft.setBackground(this.getResources().getDrawable(R.drawable.quadrant));
            btntopright.setBackground(getResources().getDrawable(R.drawable.toprightquadrant));
            imgbottomleft.setImageDrawable(this.getDrawable(R.drawable.ic_baseline_equals));
            tvtopleft.setVisibility(View.VISIBLE);
            ivtopleft.setVisibility(View.VISIBLE);
            imgtopleft.setVisibility(View.INVISIBLE);

            tvtopright.setVisibility(View.VISIBLE);
            ivtopright.setVisibility(View.VISIBLE);
            imgtopright.setVisibility(View.INVISIBLE);

            tvbottomright.setVisibility(View.VISIBLE);
            ivbottomright.setVisibility(View.VISIBLE);
            imgbottomright.setVisibility(View.INVISIBLE);

            tvbottomleft.setVisibility(View.INVISIBLE);
            ivbottomleft.setVisibility(View.INVISIBLE);
            imgbottomleft.setVisibility(View.VISIBLE);



        }
        if (v==btnbottomright)
        {
            loadFragment(new Reference_List());
            btnbottomleft.setBackground(this.getResources().getDrawable(R.drawable.bottomleftquadrant));
            btnbottomright.setBackground(this.getResources().getDrawable(R.drawable.btnbottomright));
            btntopleft.setBackground(this.getResources().getDrawable(R.drawable.quadrant));
            btntopright.setBackground(getResources().getDrawable(R.drawable.toprightquadrant));
            tvtopleft.setVisibility(View.VISIBLE);
            ivtopleft.setVisibility(View.VISIBLE);
            imgtopleft.setVisibility(View.INVISIBLE);

            tvtopright.setVisibility(View.VISIBLE);
            ivtopright.setVisibility(View.VISIBLE);
            imgtopright.setVisibility(View.INVISIBLE);

            tvbottomright.setVisibility(View.INVISIBLE);
            ivbottomright.setVisibility(View.INVISIBLE);
            imgbottomright.setVisibility(View.VISIBLE);

            tvbottomleft.setVisibility(View.VISIBLE);
            ivbottomleft.setVisibility(View.VISIBLE);
            imgbottomleft.setVisibility(View.INVISIBLE);

//            btntopright.setText("");
//            btntopright.setText("1300000 Earn Point");
//            btnbottomleft.setText("1637 Match");
//            btnbottomright.setText("");
//            btntopleft.setText("2587 Friends");
        }
        if (v==btntopleft)
        {
            loadFragment(new NewJoin());
            btnbottomleft.setBackground(this.getResources().getDrawable(R.drawable.bottomleftquadrant));
            btnbottomright.setBackground(this.getResources().getDrawable(R.drawable.bottomrightquadrant));
            btntopleft.setBackground(this.getResources().getDrawable(R.drawable.btntopleft));
            btntopright.setBackground(getResources().getDrawable(R.drawable.toprightquadrant));
            tvtopleft.setVisibility(View.GONE);
            ivtopleft.setVisibility(View.GONE);
            imgtopleft.setVisibility(View.VISIBLE);

            tvtopright.setVisibility(View.VISIBLE);
            ivtopright.setVisibility(View.VISIBLE);
            imgtopright.setVisibility(View.INVISIBLE);

            tvbottomright.setVisibility(View.VISIBLE);
            ivbottomright.setVisibility(View.VISIBLE);
            imgbottomright.setVisibility(View.INVISIBLE);

            tvbottomleft.setVisibility(View.VISIBLE);
            ivbottomleft.setVisibility(View.VISIBLE);
            imgbottomleft.setVisibility(View.INVISIBLE);


        } if (v==btntopright)
        {
            loadFragment(new earnpoint());
            btnbottomleft.setBackground(this.getResources().getDrawable(R.drawable.bottomleftquadrant));
            btnbottomright.setBackground(this.getResources().getDrawable(R.drawable.bottomrightquadrant));
            btntopleft.setBackground(this.getResources().getDrawable(R.drawable.quadrant));
            btntopright.setBackground(getResources().getDrawable(R.drawable.btntopright));
            tvtopleft.setVisibility(View.VISIBLE);
            ivtopleft.setVisibility(View.VISIBLE);
            imgtopleft.setVisibility(View.INVISIBLE);

            tvtopright.setVisibility(View.INVISIBLE);
            ivtopright.setVisibility(View.INVISIBLE);
            imgtopright.setVisibility(View.VISIBLE);

            tvbottomright.setVisibility(View.VISIBLE);
            ivbottomright.setVisibility(View.VISIBLE);
            imgbottomright.setVisibility(View.INVISIBLE);

            tvbottomleft.setVisibility(View.VISIBLE);
            ivbottomleft.setVisibility(View.VISIBLE);
            imgbottomleft.setVisibility(View.INVISIBLE);

        }

    }
    private void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayoutFragmentContainer, fragment)
                    .commit();

        }
    }

}


