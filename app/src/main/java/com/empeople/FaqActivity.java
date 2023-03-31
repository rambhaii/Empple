package com.empeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.empeople.Adapters.FaqAdapter;
import com.empeople.Adapters.ReferralListAdapter;
import com.empeople.Data.Dataum;
import com.empeople.Data.Dataz;
import com.empeople.Data.FaqData;
import com.empeople.Data.GalleryListResponse;
import com.empeople.Utils.FragmentActivityMessage;
import com.empeople.Utils.GlobalBus;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FaqActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton backpress;
    RecyclerView recyclerView;
    Loader loader;
    FaqData faqres = new FaqData();;
    FaqAdapter faqAdapter;


    List<Dataz> faqListT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        backpress = findViewById(R.id.faqback);
        backpress.setOnClickListener(this);
        recyclerView = findViewById(R.id.rec);

        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        loader.show();
        loader.setCanceledOnTouchOutside(false);


        faqListT = new ArrayList<>();
        UtilMethods.INSTANCE.getFaq(this,loader);
        loader.dismiss();

    }
    @Subscribe
    public void onFragmentActivityMessage(FragmentActivityMessage activityFragmentMessage)
    {
        if (activityFragmentMessage.getMessage().equalsIgnoreCase("faq"))
        {
            dataParse(activityFragmentMessage.getFrom());
        }
    }

        private void dataParse(String from) {

            Gson gson = new Gson();

            faqres = gson.fromJson(from, FaqData.class);
            faqListT = faqres.getData();
            recyclerView.setLayoutManager(new GridLayoutManager(FaqActivity.this, 3));
            faqAdapter = new FaqAdapter(faqListT,FaqActivity.this);
            recyclerView.setAdapter(faqAdapter);

            Log.d("faqList=","Response = "+faqListT);
            faqAdapter.setList(faqListT);





        }




    @Override
    public void onClick(View v) {

        if (v==backpress)
        {
            Intent intent = new Intent(FaqActivity.this,Settings.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onDestroy() {
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);

        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            GlobalBus.getBus().register(this);
        }
    }
}