package com.empeople;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import eightbitlab.com.blurview.BlurView;

public class Createpassword2 extends AppCompatActivity implements View.OnClickListener {
    Button btncreate;
    // BottomSheetDialog bottomSheetDialog;
    BlurView blurView;
    SignInButton signInButton;
    public GoogleSignInClient mGoogleSignInClient;
    private static int SIGN_IN=100;
    Loader loader;
    TextView fullname, userID, password, cpassword, email;
    String referal_id = "";
    String type = "";
    //RadioButton radioLeft;
    //RadioButton radioRight;
    //RadioGroup radioGroup;
    String position = "R";
    ImageView arrbk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpassword2);

        arrbk = findViewById(R.id.arrback);
        btncreate = findViewById(R.id.btncreate);
        blurView = findViewById(R.id.blurView);
        btncreate.setOnClickListener(this);
        userID = findViewById(R.id.etuserid);
        password = findViewById(R.id.etpassword);
        cpassword = findViewById(R.id.cpassword);
        signInButton = findViewById(R.id.sign_in_button);




        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestServerAuthCode("337547785564-oq3g7q4c0c9oft0jl3tj6lh7ic7vrkk0.apps.googleusercontent.com")
                .requestEmail()
                .build();

        createKeyHash("com.empeople");

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        TextView textView = (TextView) signInButton.getChildAt(0);
        textView.setText("Sign in with Google");
        signInButton.setOnClickListener(this);

        // radioLeft.setActivated(true);

        Log.d("kjfgkjfg",getIntent().getStringExtra("userId"));
        userID.setText(getIntent().getStringExtra("userId").replace('"', ' '));
        referal_id = getIntent().getStringExtra("referral_id");
        type = getIntent().getStringExtra("type");
        if (type.equals("2")) {
            position = getIntent().getStringExtra("position");
        }
        if (type.equals("1")) {
            position = getIntent().getStringExtra("position");
        }
        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        email = findViewById(R.id.etemail);
        arrbk.setOnClickListener(this);
        View decorView = getWindow().getDecorView();
        UtilMethods.INSTANCE.blur(this, blurView, decorView);

        //   radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //       @Override
        //    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //  if(checkedId==R.id.radioLeft)
        //  {
        // position="L";
        // }
        //else {
        // position="R";
        //  }
        // }
        //});
        //  }


        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView1 = getWindow().getDecorView();
        decorView
                .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {

                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            decorView.setSystemUiVisibility(flags);
                        }
                    }
                });

    }


    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
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

        if (v==signInButton)
        {
            signIn();

        }






        if (v==arrbk) {
            Intent intents = new Intent(Createpassword2.this, Register.class);
            startActivity(intents);
            finish();
        }


        if(v==btncreate)
        {
            if(password.getText().toString().isEmpty())
            {
                password.setError("Please enter password");
                password.requestFocus();
            }
            else if(cpassword.getText().toString().isEmpty())
            {
                cpassword.setError("Please enter Confirm Password");
                cpassword.requestFocus();
            }
            else if(email.getText().toString().isEmpty())
            {
                email.setError("Please Enter E-mail");
                email.requestFocus();
            }
            else if(!password.getText().toString().equals(cpassword.getText().toString()))
            {
                password.setError("Confirm password does not match");
                cpassword.requestFocus();
            }
            else if(UtilMethods.INSTANCE.isValidEmail(email.getText().toString())==false)
            {
                Toast.makeText(this, "Please Enter valid E-mail Id", Toast.LENGTH_SHORT).show();
//                  password.setError("Please Enter valid E-mail Id");
//                  password.requestFocus();
            }
           else if (UtilMethods.INSTANCE.isNetworkAvialable(this)==false)
            {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            }
            else {
                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);
                UtilMethods.INSTANCE.createAccount(Createpassword2.this,loader,referal_id,password.getText().toString(),cpassword.getText().toString(),email.getText().toString(),position,userID.getText().toString().trim(),type);
            }
            // UtilsMethods.INSTANCE.createAccount(this,);


        }

    }

    public  void createKeyHash(String yourPackage) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(yourPackage, PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    private void signIn()
    {
        Intent SigninIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(SigninIntent,SIGN_IN);;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
                Toast.makeText(this, "User Email"+personEmail, Toast.LENGTH_SHORT).show();

            }

            // Signed in successfully, show authenticated UI.
        }
            catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d ("Message",e.toString());
        }
    }

}


