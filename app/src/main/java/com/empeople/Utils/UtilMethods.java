package com.empeople.Utils;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;


import com.empeople.Createpassword2;
import com.empeople.Data.Data;
import com.empeople.Data.FaqData;
import com.empeople.Data.GalleryListResponse;
import com.empeople.Data.secureLoginResponse;
import com.empeople.MainActivity;
import com.empeople.R;
import com.empeople.Register;
import com.empeople.home;
import com.google.gson.Gson;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public enum UtilMethods {
    INSTANCE;

    public void blur(Context context, BlurView blurView, View decorView) {
        float radius = 25f;
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(context))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);
    }

    public void blurforfragment(Context context, BlurView blurView, View decorView) {
        float radius = 3f;
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(context))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);
    }

    public void getreferralList(Context context, Loader loader) {
        //  Toast.makeText(context, ""+usersid, Toast.LENGTH_SHORT).show();
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // Toast.makeText(context, ""+hit api, Toast.LENGTH_SHORT).show();

        Call<GalleryListResponse> call = api.getreferralList(header);
        call.enqueue(new Callback<GalleryListResponse>() {
            @Override
            public void onResponse(Call<GalleryListResponse> call, Response<GalleryListResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        //  Toast.makeText(context, "" + new Gson().toJson(response.body().getData().get(0).getUserID()), Toast.LENGTH_SHORT).show();
                        Register.useid = response.body().getData().get(0).getUserID();
                        Register.reffid = response.body().getData().get(0).getId();
                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<GalleryListResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getCountry(Context context, Loader loader) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<GalleryListResponse> call = api.getCountry(header);
        call.enqueue(new Callback<GalleryListResponse>() {
            @Override
            public void onResponse(Call<GalleryListResponse> call, Response<GalleryListResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        //Toast.makeText(context, "" + new Gson().toJson(response.body().getData().get(0).getUserID()), Toast.LENGTH_SHORT).show();
                        //Log.d("onResponseddsdsddsd: ", new Gson().toJson(response.body().getData().get(0).getName()));
//                        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
//                        SharedPreferences.Editor editor = prefs.edit();
//                        editor.putString(ApplicationConstant.INSTANCE.ReferenceList, new Gson().toJson(response.body()).toString());
//                        editor.commit();
                        ActivityActivityMessage fragmentActivityMessage = new ActivityActivityMessage("countrylist",
                                "" + new Gson().toJson(response.body()).toString());
                        GlobalBus.getBus().post(fragmentActivityMessage);
                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<GalleryListResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getBank(Context context, Loader loader) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<GalleryListResponse> call = api.getBank(header);
        call.enqueue(new Callback<GalleryListResponse>() {
            @Override
            public void onResponse(Call<GalleryListResponse> call, Response<GalleryListResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        //Toast.makeText(context, "" + new Gson().toJson(response.body().getData().get(0).getUserID()), Toast.LENGTH_SHORT).show();
                        //Log.d("onResponseddsdsddsd: ", new Gson().toJson(response.body().getData().get(0).getName()));
//                        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
//                        SharedPreferences.Editor editor = prefs.edit();
//                        editor.putString(ApplicationConstant.INSTANCE.ReferenceList, new Gson().toJson(response.body()).toString());
//                        editor.commit();
                        ActivityActivityMessage fragmentActivityMessage = new ActivityActivityMessage("banklist",
                                "" + new Gson().toJson(response.body()).toString());
                        GlobalBus.getBus().post(fragmentActivityMessage);
                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<GalleryListResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getstate(Context context, Loader loader, String countryId) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<GalleryListResponse> call = api.getState(header, countryId);
        call.enqueue(new Callback<GalleryListResponse>() {
            @Override
            public void onResponse(Call<GalleryListResponse> call, Response<GalleryListResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        //Toast.makeText(context, "" + new Gson().toJson(response.body().getData().get(0).getUserID()), Toast.LENGTH_SHORT).show();
                        Log.d("onResponseddsdsddsd: ", new Gson().toJson(response.body().getData().get(0).getName()));
//                        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
//                        SharedPreferences.Editor editor = prefs.edit();
//                        editor.putString(ApplicationConstant.INSTANCE.ReferenceList, new Gson().toJson(response.body()).toString());
//                        editor.commit();
                        ActivityActivityMessage fragmentActivityMessage = new ActivityActivityMessage("statelist",
                                "" + new Gson().toJson(response.body()).toString());
                        GlobalBus.getBus().post(fragmentActivityMessage);
                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<GalleryListResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getCity(Context context, Loader loader, String state) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<GalleryListResponse> call = api.getCity(header, state);
        call.enqueue(new Callback<GalleryListResponse>() {
            @Override
            public void onResponse(Call<GalleryListResponse> call, Response<GalleryListResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        //Toast.makeText(context, "" + new Gson().toJson(response.body().getData().get(0).getUserID()), Toast.LENGTH_SHORT).show();
                        // Log.d("onResponseddsdsddsd: ", new Gson().toJson(response.body().getData().get(0).getName()));
//                        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
//                        SharedPreferences.Editor editor = prefs.edit();
//                        editor.putString(ApplicationConstant.INSTANCE.ReferenceList, new Gson().toJson(response.body()).toString());
//                        editor.commit();
                        ActivityActivityMessage fragmentActivityMessage = new ActivityActivityMessage("citylist",
                                "" + new Gson().toJson(response.body()).toString());
                        GlobalBus.getBus().post(fragmentActivityMessage);
                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<GalleryListResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getpickReferral(Context context, Loader loader, String referalId, String type, String position) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        Log.d("idddfggfd",referalId);
        Call<secureLoginResponse> call = api.getpickReferral(header, referalId);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        Register.reffid = response.body().getData().getUserID();
                        Intent i = new Intent(context, Createpassword2.class);
                        i.putExtra("userId", new Gson().toJson(response.body().getData().getUserID()));
                        i.putExtra("referral_id", referalId);
                        i.putExtra("type", type);
                        i.putExtra("position", position);
                        context.startActivity(i);


                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void createAccount(Context context, Loader loader, String referalId, String password, String cpassword, String email, String position, String UserId, String type) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<secureLoginResponse> call = api.createAccount(header, referalId, password, UserId, cpassword, email, position);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        if (response.body().getStatus().equals("1")) {
                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("Your New User Id Is:" + UserId)
                                    .setContentText("Account Verification Link Has Been Sent To Your Mail" + "" + response.body().getMessage())
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            if (type.equalsIgnoreCase("1")) {
                                                Intent i = new Intent(context, MainActivity.class);
                                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                context.startActivity(i);

                                            } else {
                                                Intent i = new Intent(context, home.class);
                                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                context.startActivity(i);
                                            }
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();


                        } else {
                            UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 2);
                        }

                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void SignIn(Context context, Loader loader, String password, String UserId) {
        //Toast.makeText(context.getApplicationContext(), ""+password+""+UserId,Toast.LENGTH_SHORT).show();
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        Call<secureLoginResponse> call = api.signIn(header, UserId, password, "1234567", "1234567");
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                Log.d("derctfv", response.body().toString());

                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }

                    if (response.body().getStatus().equals("1")) {

                        UtilMethods.INSTANCE.setLoginrespose(context, "" + new Gson().toJson(response.body().getData()).toString(), "1");
                        Intent i = new Intent(context, home.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(i);
                        Toast.makeText(context.getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();

                    } else {
                        UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 1);
                    }

                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void forgotPassword(Context context, Loader loader, String UserId) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        Call<secureLoginResponse> call = api.forgotPassword(header, UserId, "");
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }

                    if (response.body().getStatus().equals("1")) {
                        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("")
                                .setContentText("" + "" + response.body().getMessage())
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        // SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, context.MODE_PRIVATE);
//                                            UtilsMethods.INSTANCE.SaveToken(context, prefs.getString(ApplicationConstant.INSTANCE.token, ""));
//                                            UtilsMethods.INSTANCE.setnumber(context, number);
                                        Intent i = new Intent(context, MainActivity.class);
                                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        context.startActivity(i);
                                        sweetAlertDialog.dismiss();
                                    }
                                }).show();


                    } else {
                        UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 1);
                    }

                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void EmailLogin(Context context, Loader loader, String EmailId) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        Call<secureLoginResponse> call = api.EmailLogin(header, EmailId, "");
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }

                    if (response.body().getStatus().equals("1")) {
                        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("")
                                .setContentText("" + "" + response.body().getMessage())
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        // SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, context.MODE_PRIVATE);
//                                            UtilsMethods.INSTANCE.SaveToken(context, prefs.getString(ApplicationConstant.INSTANCE.token, ""));
//                                            UtilsMethods.INSTANCE.setnumber(context, number);
                                        Intent i = new Intent(context, MainActivity.class);
                                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        context.startActivity(i);
                                        sweetAlertDialog.dismiss();
                                    }
                                }).show();


                    } else {
                        UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 1);
                    }

                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void updatePersonalInfo(Context context, Loader loader, String name, String fname, String dob, String email, String mobile) {
        // Toast.makeText(context.getApplicationContext(), "" + name + "" + fname + "" + dob + "" + email + "" + mobile + "" + email, Toast.LENGTH_SHORT).show();
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        SharedPreferences myPreferences = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        String id = securelogincheckResponse.getId();
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<secureLoginResponse> call = api.updatepersonalInfo(header, id, name, fname, dob, email, mobile);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        if (response.body().getStatus().equals("1")) {
                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("")
                                    .setContentText("" + "" + response.body().getMessage())
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            UtilMethods.INSTANCE.setLoginrespose(context, "" + new Gson().toJson(response.body().getData()).toString(), "1");
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        } else {
                            UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 2);
                        }

                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void updateBankInfo(Context context, Loader loader, String pan, String bankId, String ifsc, String accountNo, String accountName) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        SharedPreferences myPreferences = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        String id = securelogincheckResponse.getId();
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<secureLoginResponse> call = api.updatebankInfo(header, id, pan, bankId, ifsc, accountNo, accountName);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        if (response.body().getStatus().equals("1")) {
                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("")
                                    .setContentText("" + "" + response.body().getMessage())
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            UtilMethods.INSTANCE.setLoginrespose(context, "" + new Gson().toJson(response.body().getData()).toString(), "1");
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        } else {
                            UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 2);
                        }

                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }


    public void updateuserContactDetails(Context context, Loader loader, String houseNo, String add, String zip, String countryId, String stateId, String cityId) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        SharedPreferences myPreferences = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        String id = securelogincheckResponse.getId();
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<secureLoginResponse> call = api.updateuserContactDetails(header, id, houseNo, add, zip, countryId, stateId, cityId);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                Log.d("xxyyzz", response.body().toString());
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        if (response.body().getStatus().equals("1")) {
                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("")
                                    .setContentText("" + "" + response.body().getMessage())
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            UtilMethods.INSTANCE.setLoginrespose(context, "" + new Gson().toJson(response.body().getData()).toString(), "1");

                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        } else {
                            UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 2);
                        }

                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public boolean isValidEmail(String email) {

        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public void Failed(final Context context, final String message, final int i) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
        pDialog.setTitleText(context.getResources().getString(R.string.attention_error_title));
        pDialog.setContentText(message);
        pDialog.setCustomImage(AppCompatResources.getDrawable(context, R.drawable.ic_cancel_black_24dp));
        pDialog.setCancelable(false);
        pDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                if (i == 1) {
                    sweetAlertDialog.dismiss();
                } else {
                    sweetAlertDialog.dismiss();
                }
            }
        });
        pDialog.show();
    }

    public void NetworkError(final Context context, String title, final String message) {
        new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .setCustomImage(AppCompatResources.getDrawable(context, R.drawable.ic_connection_lost_24dp))
                .show();
    }

    public boolean isNetworkAvialable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void setLoginrespose(Context context, String Loginrespose, String one) {
        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ApplicationConstant.INSTANCE.Loginrespose, Loginrespose);
        editor.putString(ApplicationConstant.INSTANCE.one, one);
        editor.commit();

    }

    public void logout(final Context context) {
        UtilMethods.INSTANCE.logoutfromServer(context);
        UtilMethods.INSTANCE.setLoginrespose(context, "", "");
        Intent startIntent = new Intent(context, MainActivity.class);
        startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(startIntent);

    }

    public void logoutfromServer(Context context) {
        SharedPreferences myPreferences = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        String id = securelogincheckResponse.getId();
        // Toast.makeText(context, ""+id, Toast.LENGTH_SHORT).show();
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        Call<secureLoginResponse> call = api.SignOut(header, id);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (response.body().getStatus().equals("1")) {
                        Toast.makeText(context, "Logout Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 1);
                    }

                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {

                Log.e("onFailure: ", t.getMessage());
            }
        });

    }

    public void UpdateProfilePic(final Activity context, Loader loader, String userimage) {
        SharedPreferences myPreferences = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        String id = securelogincheckResponse.getId();
        File file = new File(userimage);
        MultipartBody.Part fileToUpload1;
        RequestBody requestBody1 = RequestBody.create(MediaType.parse("*image/*"), file);
        fileToUpload1 = MultipartBody.Part.createFormData("profile_pic", file.getName(), requestBody1);
        RequestBody iduser = RequestBody.create(MediaType.parse("text/plain"), id);

        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        Call<secureLoginResponse> call = api.getUploadPic(header, iduser, fileToUpload1);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    if (response.body().getStatus().equals("1")) {
                        UtilMethods.INSTANCE.setLoginrespose(context, "" + new Gson().toJson(response.body().getData()).toString(), "1");
                        UtilMethods.INSTANCE.Successful(context, response.body().getMessage(), 1);
                    } else {
                        UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 1);
                    }

                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }

            }
        });

    }

    public void Successful(final Context context, final String message, final int i) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.setTitleText(context.getResources().getString(R.string.successful_title));
        pDialog.setContentText(message);
        pDialog.setCancelable(false);
        pDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
            }
        });
        pDialog.show();
    }

    public void getRefferalList(Context context, Loader loader) {
        SharedPreferences mypref = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String alldata = mypref.getString(ApplicationConstant.INSTANCE.Loginrespose, "");
        Data alldataresponse = new Gson().fromJson(alldata, Data.class);
        String id = alldataresponse.getId();
        String header = ApplicationConstant.INSTANCE.Headertoken;
        AllAPIs apIs = APIClient.getClient().create(AllAPIs.class);
        Call<GalleryListResponse> call = apIs.getrefferralList(header, id);
        call.enqueue(new Callback<GalleryListResponse>() {
            @Override
            public void onResponse(Call<GalleryListResponse> call, Response<GalleryListResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    if (response.body().getStatus().equals("1")) {
                        FragmentActivityMessage fragmentActivityMessage = new FragmentActivityMessage("referrallist",
                                "" + new Gson().toJson(response.body()).toString());
                        GlobalBus.getBus().post(fragmentActivityMessage);
//                            Toast.makeText(context, ""
//                                    +response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                            Log.d( "vxgdfgbfcbhfcb: ",response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<GalleryListResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
            }
        });


    }

    public void getAllPoints(Context context, Loader loader) {
        SharedPreferences mypref = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String alldata = mypref.getString(ApplicationConstant.INSTANCE.Loginrespose, "");
        Data alldataresponse = new Gson().fromJson(alldata, Data.class);
        String id = alldataresponse.getId();
        String header = ApplicationConstant.INSTANCE.Headertoken;
        AllAPIs apIs = APIClient.getClient().create(AllAPIs.class);
        Call<secureLoginResponse> call = apIs.getUserDetailLog(header, id);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    if (response.body().getStatus().equals("1")) {
//                        Toast.makeText(context, ""
//                                    +response.body().getData().getJoininglist().getNewJoin(), Toast.LENGTH_SHORT).show();
                        SharedPreferences prefs = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefpoint, MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(ApplicationConstant.INSTANCE.pointresponse, new Gson().toJson(response.body().getData().getJoininglist()));
                        editor.commit();
                        SharedPreferences preffs = context.getSharedPreferences(ApplicationConstant.INSTANCE.Usermatchpoint, MODE_PRIVATE);
                        SharedPreferences.Editor editors = preffs.edit();
                        editors.putString(ApplicationConstant.INSTANCE.pointresponse1, new Gson().toJson(response.body().getData().getUserpoints()));
                        editors.commit();
//                            Log.d( "vxgdfgbfcbhfcb: ",response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
            }
        });


    }

    public void ChangePasssword(Context context, Loader loader, String password, String cpassword, String oldpass) {
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        Log.d("cbbvxnbvxcnvb", password + "cpss:---" + cpassword + "old--" + oldpass);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        SharedPreferences mypref = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String alldata = mypref.getString(ApplicationConstant.INSTANCE.Loginrespose, "");
        Data alldataresponse = new Gson().fromJson(alldata, Data.class);
        String id = alldataresponse.getId();
        // Toast.makeText(context, "hit api", Toast.LENGTH_SHORT).show();
        Call<secureLoginResponse> call = api.changePassword(header, id, oldpass, password, cpassword);
        call.enqueue(new Callback<secureLoginResponse>() {
            @Override
            public void onResponse(Call<secureLoginResponse> call, Response<secureLoginResponse> response) {
                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                    try {
                        if (response.body().getStatus().equals("1")) {
                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("")
                                    .setContentText("" + "" + response.body().getMessage())
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                        }
                                    }).show();
                        } else {
                            UtilMethods.INSTANCE.Failed(context, response.body().getMessage(), 2);
                        }

                    } catch (Exception e) {
                        Log.e("error: ", e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<secureLoginResponse> call, Throwable t) {
                if (loader != null) {
                    if (loader.isShowing())
                        try {
                            loader.dismiss();
                        } catch (Exception e) {

                        }
                }
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }


    public void getFaq(Context context, Loader loader) {
        Log.d("abcdef", "id");
        AllAPIs api = APIClient.getClient().create(AllAPIs.class);
        String header = ApplicationConstant.INSTANCE.Headertoken;
        // SharedPreferences mypref = context.getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        // String alldata = mypref.getString(ApplicationConstant.INSTANCE.Loginrespose, "");
        // Data alldataresponse = new Gson().fromJson(alldata, Data.class);
        Call<FaqData> call = api.getFaq(header);

        call.enqueue(new Callback<FaqData>() {

            @Override
            public void onResponse(Call<FaqData> call, Response<FaqData> response) {

                if (response != null) {
                    if (loader != null) {
                        if (loader.isShowing())
                            loader.dismiss();
                    }
                }
                try {

                } catch (Exception e) {
                    Log.e("error: ", e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<FaqData> call, Throwable t) {

                if (loader.isShowing())
                    try {
                        loader.dismiss();
                    } catch (Exception e) {
                        Log.e("onFailure: ", t.getMessage());

                    }
            }


        });
    }
    }











