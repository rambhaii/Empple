package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Purchase extends AppCompatActivity implements View.OnClickListener {

   ImageView imgcart;
   ImageView backrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        imgcart=findViewById(R.id.imgcart);
        backrow=findViewById(R.id.backrow);
        imgcart.setOnClickListener(this);
        backrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

       if (v==backrow)
       {
           Intent k = new Intent(Purchase.this,home.class);
           startActivity(k);
           finish();
       }
        else if (v==imgcart)
        {
            Intent a = new Intent(Purchase.this,CartActivity.class);
            startActivity(a);
            finish();
        }


    }
}