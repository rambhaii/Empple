package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Notification extends AppCompatActivity implements View.OnClickListener {
    ImageButton arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        arrow=findViewById(R.id.backpress);
        arrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==arrow)
        {
            startActivity(new Intent(Notification.this, home.class), ActivityOptions.makeSceneTransitionAnimation(Notification.this).toBundle());

        }
    }
}