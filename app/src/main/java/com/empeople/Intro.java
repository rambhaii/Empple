package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.empeople.Adapters.IntroSlider;
import com.empeople.Adapters.SliderAdapterExample;
import com.empeople.Data.SliderModel;
import com.empeople.Data.SubSliderModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.Slider;

public class Intro extends AppCompatActivity implements View.OnClickListener {
    TextView skip,stext;
    ImageButton hoverback;
    private Slider slider;
    Context context;
    List<SubSliderModel> subSliderModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
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



    skip=findViewById(R.id.skip);
        hoverback=findViewById(R.id.hoverback);
        stext=findViewById(R.id.slidertext);

        skip.setOnClickListener(this);
        hoverback.setOnClickListener(this);

        subSliderModelList.add(new SubSliderModel(R.drawable.screenfirst));
        subSliderModelList.add(new SubSliderModel(R.drawable.screensecond));
        subSliderModelList.add(new SubSliderModel(R.drawable.screenthird));



        SliderView sliderView = findViewById(R.id.imageslider);
        sliderView.setSliderAdapter(new IntroSlider(context,subSliderModelList));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
       // sliderView.startAutoCycle();
       // sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.BLACK);
        sliderView.setIndicatorUnselectedColor(Color.BLACK);

        //sethomebanner();
    }

   /* private void sethomebanner() {
        Slider.init(new PicassoImageLoadingService(this));
        slider = findViewById(R.id.bannerslider);
        slider.setAdapter(new MainSliderAdapter());

    }  */

    @Override
    public void onClick(View v) {
        if (v==hoverback)
        {
            Intent k=new Intent(Intro.this,Splash.class);
            startActivity(k);
            finish();

        }
        else if (v==skip)
        {
            Intent x = new Intent(Intro.this,Guest.class);
            skip.setEnabled(false);
            startActivity(x);
            finish();
        }
    }
}