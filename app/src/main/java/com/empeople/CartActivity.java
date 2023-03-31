package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

 ImageView reverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        reverse= findViewById(R.id.reverse);
        reverse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==reverse)
        {
            Intent i = new Intent(CartActivity.this,Purchase.class);
            startActivity(i);
            finish();
        }
    }
}