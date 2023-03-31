package com.empeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.empeople.Adapters.RecyclerAdapter;
import com.empeople.Data.Data;
import com.empeople.Data.Dataum;
import com.empeople.Data.GalleryListResponse;
import com.empeople.Utils.ApplicationConstant;
import com.empeople.Utils.FragmentActivityMessage;
import com.empeople.Utils.GlobalBus;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import eightbitlab.com.blurview.BlurView;

public class Register extends AppCompatActivity implements View.OnClickListener {
   public static String useid;
   public static String reffid;
   String position="R";

    ImageView bck,sinup;
    TextView tvclickher,head,id;
    Button confirm,pick;
    BlurView blurView;
    BottomSheetDialog bottomSheetDialog;
    GalleryListResponse refereceresponse = new GalleryListResponse();
    ArrayList<String> ReferralList = new ArrayList<String>();
    ArrayList<String> ReferanceId = new ArrayList<String>();
    ArrayList<Dataum> refereceresponsespinner = new ArrayList<>();
  public static String referenceID;
  public  String refid;
    EditText etuserid;
    Loader loader;
    EditText reference;
    private RecyclerView recyclerView1;
    public ArrayList<Dataum> referrallist;
    Data balanceCheckResponse;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bck = findViewById(R.id.bk1);
        bck.setOnClickListener(this);
        confirm = findViewById(R.id.cbtn);
        sinup=findViewById(R.id.sinup);
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        sinup.startAnimation(aniFade);
        confirm.setOnClickListener(this);
        tvclickher = findViewById(R.id.clkhere);
        reference=findViewById(R.id.refid);
        reference.setVisibility(View.GONE);

        tvclickher.setOnClickListener(this);
        blurView = findViewById(R.id.blurView);
        etuserid = findViewById(R.id.userid);
        referrallist= new ArrayList<Dataum>();


        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        View decorView = getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this, blurView, decorView);



        SharedPreferences prefs = getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, Context.MODE_PRIVATE);
        String refrence = prefs.getString(ApplicationConstant.INSTANCE.ReferenceList, "");

        //dataParsesState(refrence);
        loader.show();
        loader.setCancelable(false);
        loader.setCanceledOnTouchOutside(false);
        UtilMethods.INSTANCE.getreferralList(this, loader);

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




    @Subscribe
    public void onFragmentActivityMessage(FragmentActivityMessage activityFragmentMessage) {
        if (activityFragmentMessage.getMessage().equalsIgnoreCase("ReferenceList")) {
            dataParsesState(activityFragmentMessage.getFrom());
        }
    }

    private void dataParsesState(String refrence) {
        //  referrallist.add("Select RefenceId");


        ReferanceId.add("0");
        Gson gson = new Gson();
        refereceresponse = gson.fromJson(refrence, GalleryListResponse.class);


        referrallist = refereceresponse.getData();


        Dataum dataum = referrallist.get(0);
        final Dataum operator = referrallist.get(0);


        if (referrallist.size() > 0) {
            if (referrallist != null && referrallist.size() > 0) {
                for (int i = 0; i < referrallist.size(); i++) {
                    ReferralList.add(referrallist.get(0).getUserID());
                    ReferanceId.add(referrallist.get(0).getId());
                }
            }
        }
    }









//            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(referrallist);
//            recyclerView = findViewById(R.id.recyclerview);
//            recyclerView.setAdapter(recyclerAdapter);
    //      recyclerView.setLayoutManager(new GridLayoutManager(Register.this,3));


















    @Override
    public void onClick(View v) {
        if (v == confirm) {
            if (etuserid.getText().toString().isEmpty()) {
                etuserid.setError("Please enter userid");
                etuserid.requestFocus();
            }
            else if (UtilMethods.INSTANCE.isNetworkAvialable(this)==false)
            {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            }

            else {

                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);
                UtilMethods.INSTANCE.getpickReferral(this, loader, reffid,"1",position);
               // Toast.makeText(this, "" + reffid, Toast.LENGTH_SHORT).show();

             /*   Intent intent = new Intent(Register.this, Createpassword2.class);
                startActivity(intent);
                finish(); */




                //  startActivity(new Intent(this, Createpassword2.class).putExtra("userId",reffid), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }
        }


        if (v == tvclickher) {



              /* tvclickher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   userid.setText(""+id);
                   // Toast.makeText(context, dataum.getId()+"", Toast.LENGTH_SHORT).show();
                  //  Register.referenceID=dataum.getId();
                    bottomSheetDialog.dismiss();
                }
            });

        } */
            bottomSheetDialog = new BottomSheetDialog(Register.this, R.style.ButtomSheetDailog);
            View view = LayoutInflater.from(Register.this).inflate(R.layout.bottomsheet,
                    (LinearLayout) findViewById(R.id.sheet)

            );
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
            pick = bottomSheetDialog.findViewById(R.id.pick);
            head = bottomSheetDialog.findViewById(R.id.head);
            id = bottomSheetDialog.findViewById(R.id.usersid);
            // recyclerView1=bottomSheetDialog.findViewById(R.id.recyclerview1);

            id.setText("" + useid);


            pick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etuserid.setText("" + useid);
                    etuserid.setError(null);

                    //Toast.makeText(context, dataum.getId()+"", Toast.LENGTH_SHORT).show();
                    // Register.referenceID=dataum.getId();

                    bottomSheetDialog.dismiss();

                }
            });
        }


            // RecyclerAdapter recyclerAdapter = new RecyclerAdapter(referrallist,Register.this,userid,refid);
            //  recyclerView1.setLayoutManager(new LinearLayoutManager(bottomSheetDialog.getContext()));
            //  recyclerView1.setAdapter(recyclerAdapter);


            if (v == bck) {
                Intent s = new Intent(Register.this,MainActivity.class);
                startActivity(s);
                finish();

            }


        }


   /* private void validate() {
        TextView errorText = (TextView)userid.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);//just to highlight that this is an error
        errorText.setText("my actual error text");//changes the selected item text to this

    } */


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






