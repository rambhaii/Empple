package com.empeople;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.empeople.Data.Data;
import com.empeople.Utils.ApplicationConstant;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import eightbitlab.com.blurview.BlurView;

public class Settings extends AppCompatActivity implements View.OnClickListener {
    TextView name, useid, changepass, getsuppport, like;
    ImageView profile_image,faqimage;
    ImageView editprof;
    ImageView faq;
    ImageView sendback;
    ImageView editimg;
    Button left, right, signout, setings, refer;
    Loader loader;
    BlurView blur;
    BlurView blue;
    String img = "1";
    EditText oldpass, newpass, confirmpass;
    Button confirmbtn;
    // Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        name = findViewById(R.id.tv_name);
        sendback = findViewById(R.id.sendback);
        changepass = findViewById(R.id.tv_changepas);
        getsuppport = findViewById(R.id.tv_getsupport);
        like = findViewById(R.id.tv_like);
        profile_image = findViewById(R.id.profile_image);
        faqimage=findViewById(R.id.faqimage);
        faqimage.setOnClickListener(this);

        editprof = findViewById(R.id.editprof);
        editimg=findViewById(R.id.editimg);
        useid = findViewById(R.id.tv_id);
        blue = findViewById(R.id.blu);
        oldpass = findViewById(R.id.oldpass);
        newpass = findViewById(R.id.newpass);
        confirmbtn = findViewById(R.id.btnconfirm);
        confirmpass = findViewById(R.id.confirmpass);
        left = findViewById(R.id.buttonleft);
        left.setVisibility(View.INVISIBLE);
        right = findViewById(R.id.buttonright);
        right.setVisibility(View.INVISIBLE);
        signout = findViewById(R.id.signout);
        setings = findViewById(R.id.set);
        refer = findViewById(R.id.buttonshare);
        blur = findViewById(R.id.blurry);
        signout.setOnClickListener(this);
        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        SharedPreferences myPreferences = Settings.this.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, +MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        //persiona Info
        String id = securelogincheckResponse.getUserID();
        String tvname = securelogincheckResponse.getName();
        String pic = securelogincheckResponse.getProfile();
        // Toast.makeText(getActivity(), ""+pic, Toast.LENGTH_SHORT).show();
        Log.d("sdvdsvdsvsdvdsvds: .", pic);
       // name.setText(name + "!");
        Glide.with(Settings.this)
                .load(pic)
                .into(profile_image);
        Glide.with(Settings.this)
                .load(pic)
                .into(editprof);
        name.setText(tvname);
        useid.setText(id);


        sendback.setOnClickListener(this);
        changepass.setOnClickListener(this);
        editprof.setOnClickListener(this);
        setings.setOnClickListener(this);
        refer.setOnClickListener(this);
        editimg.setOnClickListener(this);

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





    @Override
    public void onClick(View v) {
        if (v == sendback) {
            Intent k = new Intent(Settings.this, home.class);
            startActivity(k);
            finish();
        }
        if (v == signout) {
            if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
            }
            else {
                loader.show();
                loader.setCancelable(false);
                loader.setCanceledOnTouchOutside(false);
                UtilMethods.INSTANCE.logout(this);
            }

        }

        else if (v==faqimage)
        {
            Intent f= new Intent(Settings.this,FaqActivity.class);
            startActivity(f);
            finish();

        }





        else if (v == changepass) {


            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Settings.this, R.style.ButtomSheetDailog);
            View view = LayoutInflater.from(Settings.this).inflate(R.layout.bottomsheetchangepass,
                    (LinearLayout) findViewById(R.id.sheet)


            );

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
            blur = bottomSheetDialog.findViewById(R.id.blurry);
            View decorView = getWindow().getDecorView();
            UtilMethods.INSTANCE.blur(Settings.this, blur, decorView);


            oldpass = bottomSheetDialog.findViewById(R.id.oldpass);
            newpass = bottomSheetDialog.findViewById(R.id.newpass);
            confirmpass = bottomSheetDialog.findViewById(R.id.confirmpass);
            confirmbtn = bottomSheetDialog.findViewById(R.id.btnconfirm);
            loader = new Loader(Settings.this, android.R.style.Theme_Translucent_NoTitleBar);

            confirmbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loader.show();
                    loader.setCancelable(false);
                    loader.setCanceledOnTouchOutside(false);


                    UtilMethods.INSTANCE.ChangePasssword(Settings.this, loader, newpass.getText().toString(), confirmpass.getText().toString(), oldpass.getText().toString());

                 /*   Toast.makeText(Settings.this, "" + newpass, Toast.LENGTH_SHORT).show();
                    Toast.makeText(Settings.this, "" + oldpass, Toast.LENGTH_SHORT).show();
                    Toast.makeText(Settings.this, "" + confirmpass, Toast.LENGTH_SHORT).show();  */

                }
            });


        } else if (v == editprof) {
            Intent intent = new Intent(Settings.this, EditProf.class);
            startActivity(intent);
            finish();


        } else if (v == setings) {
            BottomSheetDialog bt = new BottomSheetDialog(Settings.this, R.style.ButtomSheetDailog);
            View view = LayoutInflater.from(Settings.this).inflate(R.layout.bottomsheetnotification,
                    (LinearLayout) findViewById(R.id.sheet)
            );

            bt.setContentView(view);
            bt.show();
            blue = bt.findViewById(R.id.blu);
            View decorView = getWindow().getDecorView();
            UtilMethods.INSTANCE.blur(Settings.this, blue, decorView);
          /*  aSwitch=bt.findViewById(R.id.switch1);
            aSwitch.setTextOn("ON");
            aSwitch.setTextOff("OFF"); */


        }     /*else if (v == refer) {
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);
        }   */

        else if (v == editimg)

            showBottomSheetDialog();
    }




        private void showBottomSheetDialog()
        {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Settings.this);
            bottomSheetDialog.setContentView(R.layout.bottomsheet_dialog);
            ImageView gallery = bottomSheetDialog.findViewById(R.id.gallery);
            ImageView camera = bottomSheetDialog.findViewById(R.id.camera);

            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dexter.withContext(Settings.this)
                            .withPermissions(
                                    Manifest.permission.CAMERA,
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                            ).withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                            Intent pickimage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(pickimage, 2);
                            bottomSheetDialog.dismiss();


                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();

                        }
                    }).check();
                }

            });

            camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dexter.withContext(Settings.this)
                            .withPermissions(
                                    Manifest.permission.CAMERA,
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                            ).withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                            Intent imagecapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(imagecapture, 1);
                            bottomSheetDialog.dismiss();

                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();
                        }
                    }).check();
                }
            });
            bottomSheetDialog.show();


        }




        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK) {

                if (requestCode == 1)
                {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    profile_image.setImageBitmap(bitmap);
                    Uri tempUri = getImageUri(Settings.this, bitmap);
                    File finalFile = new File(getRealPathFromURI(tempUri));
                    loader.show();
                    loader.setCancelable(false);
                    loader.setCanceledOnTouchOutside(false);
                    UtilMethods.INSTANCE.UpdateProfilePic(Settings.this,loader,finalFile.toString());

                }
                else if (requestCode == 2) {
                    try {

                        Uri selectedImage = data.getData();
                        String[] filePath = {MediaStore.Images.Media.DATA};
                        Cursor c = this.getContentResolver().query(selectedImage, filePath, null, null, null);
                        c.moveToFirst();
                        int columnIndex = c.getColumnIndex(filePath[0]);
                        String picturePath = c.getString(columnIndex);
                        c.close();
                        img = picturePath;
                        loader.show();
                        loader.setCancelable(false);
                        loader.setCanceledOnTouchOutside(false);
                        UtilMethods.INSTANCE.UpdateProfilePic(Settings.this,loader,img);
                        Bitmap thumbnail = BitmapFactory.decodeFile(picturePath);
                        Log.e("xc", picturePath + "");
                        profile_image.setImageBitmap(thumbnail);

                        profile_image.setBackground(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                        BitmapFactory.Options options;
                        options = new BitmapFactory.Options();
                        options.inSampleSize = 2;
                        Uri selectedImage = data.getData();
                        String[] filePath = {MediaStore.Images.Media.DATA};
                        Cursor c = this.getContentResolver().query(selectedImage, filePath, null, null, null);
                        c.moveToFirst();
                        int columnIndex = c.getColumnIndex(filePath[0]);
                        String picturePath = c.getString(columnIndex);
                        c.close();
                        Bitmap bitmap = BitmapFactory.decodeFile(picturePath, options);
                        Log.e("xc", picturePath + "");
                        profile_image.setImageBitmap(bitmap);
                        profile_image.setBackground(null);
                    }
                }
            }
        }
        public Uri getImageUri(Context inContext, Bitmap inImage) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            inImage.compress(Bitmap.CompressFormat.JPEG, 75, bytes);
            String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
            return Uri.parse(path);
        }
        public String getRealPathFromURI(Uri uri) {
            String path = "";
            if (this.getContentResolver() != null) {
                Cursor cursor = this.getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    path = cursor.getString(idx);
                    cursor.close();
                }
            }
            return path;
        }



    }

