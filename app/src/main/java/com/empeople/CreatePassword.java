package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.empeople.Utils.UtilMethods;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import eightbitlab.com.blurview.BlurView;

public class CreatePassword extends AppCompatActivity {
    ImageView backicon;
    Button createnewpass;
    BottomSheetDialog bottomSheetDialog;
    BlurView blurView;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CreatePassword.this, MainActivity.class);
        startActivity(intent);
        finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        blurView=findViewById(R.id.blurView);
        View decorView =getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this,blurView,decorView);

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





    createnewpass=findViewById(R.id.create_new_pass);
        backicon=findViewById(R.id.backicon);
        backicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CreatePassword.this,Verification.class);
                startActivity(intent);
                finish();

            }
        });
        createnewpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog =new BottomSheetDialog(CreatePassword.this,R.style.ButtomSheetDailog);
                View view= LayoutInflater.from(CreatePassword.this).inflate(R.layout.popup,
                        (LinearLayout)findViewById(R.id.sheet)
                );
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });


    }
}

