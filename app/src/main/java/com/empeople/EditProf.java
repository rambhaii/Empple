package com.empeople;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.le.AdvertiseData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.empeople.Data.Data;
import com.empeople.Data.Dataum;
import com.empeople.Data.GalleryListResponse;
import com.empeople.Utils.ActivityActivityMessage;
import com.empeople.Utils.ApplicationConstant;
import com.empeople.Utils.GlobalBus;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProf extends AppCompatActivity implements View.OnClickListener {
    TextView personal, contact, account,username,userid;
    TextInputEditText etname, etfathername, etdob, etmobile, etemail, ethouseno, etadd, etzip,
            etpan, etifsc, etaccno, etaccname;
    TextInputLayout namelayout, fnamelayout, doblayout, mobilelayout, emaillayout, houselayout,
            addlayout, ziplayout,statelayout, panlayout, ifsclayout, accountnumberlayout, accountnamelayout;
    Button personalsumit, contactsumit, accsumit;
    Spinner spcity, spstate, spcountry, spbankname;
    Loader loader;
    CircleImageView profile;
    ImageButton revert;

    GalleryListResponse countryresponse = new GalleryListResponse();
    ArrayList<String> CountryList = new ArrayList<String>();
    ArrayList<String> CountryId = new ArrayList<String>();
    ArrayList<Dataum> countrysponsespinner = new ArrayList<>();
    String countryId = "0";
    GalleryListResponse stateresponse = new GalleryListResponse();
    ArrayList<String> StateList = new ArrayList<String>();
    ArrayList<String> StateId = new ArrayList<String>();
    ArrayList<Dataum> statesponsespinner = new ArrayList<>();
    String stateId = "0";
    GalleryListResponse cityresponse = new GalleryListResponse();
    ArrayList<String> CityList = new ArrayList<String>();
    ArrayList<String> CityId = new ArrayList<String>();
    ArrayList<Dataum> citysponsespinner = new ArrayList<>();
    String cityId = "0";
    GalleryListResponse bankresponse = new GalleryListResponse();
    ArrayList<String> BankList = new ArrayList<String>();
    ArrayList<String> BankId = new ArrayList<String>();
    ArrayList<Dataum> banksponsespinner = new ArrayList<>();
    String country = "0";
    String state = "0";
    String city = "0";
    String bank;
    String bankId = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prof);
        initialize();
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










       public void initialize()
       {
           username=findViewById(R.id.tv_name);
           userid=findViewById(R.id.tv_id);
        personal = findViewById(R.id.personal);
        contact = findViewById(R.id.contact);
        account = findViewById(R.id.account);
        etname = findViewById(R.id.name);
        etname.setVisibility(View.VISIBLE);
        namelayout = findViewById(R.id.namelayout);
        namelayout.setVisibility(View.VISIBLE);
        fnamelayout = findViewById(R.id.fnamelayout);
        fnamelayout.setVisibility(View.VISIBLE);
        doblayout = findViewById(R.id.doblayout);
        doblayout.setVisibility(View.VISIBLE);
        emaillayout = findViewById(R.id.emaillayout);
        emaillayout.setVisibility(View.VISIBLE);
        mobilelayout = findViewById(R.id.moblayout);
        mobilelayout.setVisibility(View.VISIBLE);

        personalsumit = findViewById(R.id.personalbutton);
        personalsumit.setOnClickListener(this);
        contactsumit = findViewById(R.id.btncontact);
        contactsumit.setOnClickListener(this);
        accsumit = findViewById(R.id.btnaccount);
        accsumit.setOnClickListener(this);
        revert = findViewById(R.id.revert);
        revert.setOnClickListener(this);


        etfathername = findViewById(R.id.fathername);
        etfathername.setVisibility(View.VISIBLE);
        etdob = findViewById(R.id.dob);
        etdob.setVisibility(View.VISIBLE);
        etmobile = findViewById(R.id.mobile);
        etmobile.setVisibility(View.VISIBLE);
        etemail = findViewById(R.id.email);
        etemail.setVisibility(View.VISIBLE);
        ethouseno = findViewById(R.id.houseno);
        ethouseno.setVisibility(View.INVISIBLE);
        houselayout = findViewById(R.id.houselayout);
        houselayout.setVisibility(View.INVISIBLE);
        etadd = findViewById(R.id.add);
        etadd.setVisibility(View.INVISIBLE);
        addlayout = findViewById(R.id.addlayout);
        addlayout.setVisibility(View.INVISIBLE);
       // statelayout=findViewById(R.id.statelayout);
//        statelayout.setVisibility(View.INVISIBLE);
        etzip = findViewById(R.id.zip);
        etzip.setVisibility(View.INVISIBLE);
        ziplayout = findViewById(R.id.ziplayout);
        ziplayout.setVisibility(View.INVISIBLE);
        spcity = findViewById(R.id.spcity);
        spcity.setVisibility(View.GONE);
        spstate = findViewById(R.id.spstate);
        spstate.setVisibility(View.GONE);
        spcountry = findViewById(R.id.spcountry);
        spcountry.setVisibility(View.GONE);

        etpan = findViewById(R.id.pan);
        etpan.setVisibility(View.INVISIBLE);
        panlayout = findViewById(R.id.panlayout);
        panlayout.setVisibility(View.INVISIBLE);
        spbankname = findViewById(R.id.spbank);
        spbankname.setVisibility(View.GONE);
        etifsc = findViewById(R.id.ifsc);
        etifsc.setVisibility(View.INVISIBLE);
        ifsclayout = findViewById(R.id.ifsclayout);
        ifsclayout.setVisibility(View.INVISIBLE);
        etaccno = findViewById(R.id.accno);
        etaccno.setVisibility(View.INVISIBLE);
        accountnumberlayout = findViewById(R.id.accountnolayout);
        accountnumberlayout.setVisibility(View.INVISIBLE);
        etaccname = findViewById(R.id.accname);
        etaccname.setVisibility(View.INVISIBLE);
        accountnamelayout = findViewById(R.id.accountnamelayout);
        accountnamelayout.setVisibility(View.INVISIBLE);
        profile = findViewById(R.id.profilerimg);

        personal.setOnClickListener(this);
        contact.setOnClickListener(this);
        account.setOnClickListener(this);


        loader = new Loader(this, android.R.style.Theme_Translucent_NoTitleBar);
        UtilMethods.INSTANCE.getCountry(this, loader);
        UtilMethods.INSTANCE.getBank(this, loader);
        SharedPreferences myPreferences = getSharedPreferences(ApplicationConstant.INSTANCE.prefNamePref, MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.Loginrespose, null);
        Data securelogincheckResponse = new Gson().fromJson(secureloginResponse, Data.class);
        //persiona Info
        String id = securelogincheckResponse.getUserID();
        String name = securelogincheckResponse.getName();
        String pic = securelogincheckResponse.getProfile();

        Glide.with(EditProf.this)
                   .load(pic)
                   .into(profile);

        username.setText(name);
        userid.setText(id);






        etname.setText(name);
        String fname = securelogincheckResponse.getFather_name();
        etfathername.setText(fname);
        String dob = securelogincheckResponse.getDob();
        etdob.setText(dob);
        String email = securelogincheckResponse.getEmail();
        etemail.setText(email);
        String mobile = securelogincheckResponse.getMobile();
        etmobile.setText(mobile);
        //Contact Info
        String houseNo = securelogincheckResponse.getLandmark();
        ethouseno.setText(houseNo);
        String add = securelogincheckResponse.getAddress1();
        etadd.setText(add);
        String zip = securelogincheckResponse.getZip();
        etzip.setText(zip);
        country = securelogincheckResponse.getCountry();
        // Toast.makeText(this, ""+country, Toast.LENGTH_SHORT).show();
        state = securelogincheckResponse.getState();
        city = securelogincheckResponse.getCity();
        //Bank Info
        String pan = securelogincheckResponse.getPan_no();
        etpan.setText(pan);
        bank = securelogincheckResponse.getBank_master_id();
        String ifsc = securelogincheckResponse.getIfsc_code();
        etifsc.setText(ifsc);
        String accountNo = securelogincheckResponse.getAccount_no();
        etaccno.setText(accountNo);
        String accountName = securelogincheckResponse.getAc_holder_name();
        etaccname.setText(accountName);
        BankList.add("Select Bank");
        BankId.add("0");
        CountryList.add("Select Country");
        CountryId.add("0");
        StateList.add("Select State");
        StateId.add("0");
        CityList.add("Select City");
        CityId.add("0");

    }


    @Subscribe
    public void onActivityActivityMessage(ActivityActivityMessage activityFragmentMessage) {
        if (activityFragmentMessage.getMessage().equalsIgnoreCase("countrylist")) {
            dataParse(activityFragmentMessage.getFrom());
        } else if (activityFragmentMessage.getMessage().equalsIgnoreCase("statelist")) {
            dataParseState(activityFragmentMessage.getFrom());
        } else if (activityFragmentMessage.getMessage().equalsIgnoreCase("citylist")) {
            dataParseCity(activityFragmentMessage.getFrom());
        } else if (activityFragmentMessage.getMessage().equalsIgnoreCase("banklist")) {
            dataParsebank(activityFragmentMessage.getFrom());
        }
    }

    private void dataParse(String from) {
        //Log.d("dataParse: ",from);

        Gson gson = new Gson();
        countryresponse = gson.fromJson(from, GalleryListResponse.class);
        countrysponsespinner = countryresponse.getData();
        if (countrysponsespinner.size() > 0) {
            if (countrysponsespinner != null && countrysponsespinner.size() > 0) {
                for (int i = 0; i < countrysponsespinner.size(); i++) {

                    CountryList.add(countrysponsespinner.get(i).getName());
                    CountryId.add(countrysponsespinner.get(i).getId());
                }
            }
            spcountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.e("spinner", "  position   " + position + "  ,  id  " + id);
                    if (parent.getItemAtPosition(position).toString().equals("Select Country")) {
                    } else {
                        countryId = CountryId.get(position);
                        UtilMethods.INSTANCE.getstate(EditProf.this, loader, countryId);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            ArrayAdapter<String> countryAdapter;
            countryAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, CountryList);
            spcountry.setAdapter(countryAdapter);
            spcountry.setSelection(Integer.parseInt(country));
            // userid.setSelection(((ArrayAdapter<String>) userid.getAdapter()).getPosition(balanceCheckResponse.getDistrict_name()));

        }
    }

    private void dataParseState(String from) {
        Gson gson = new Gson();
        stateresponse = gson.fromJson(from, GalleryListResponse.class);
        statesponsespinner = stateresponse.getData();
        if (statesponsespinner.size() > 0) {
            if (statesponsespinner != null && statesponsespinner.size() > 0) {
                for (int i = 0; i < statesponsespinner.size(); i++) {
                    StateList.add(statesponsespinner.get(i).getName());
                    StateId.add(statesponsespinner.get(i).getId());
                }
            }
            spstate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.e("spinner", "  position   " + position + "  ,  id  " + id);
                    if (parent.getItemAtPosition(position).toString().equals("Select Country")) {
                    } else {
                        stateId = StateId.get(position);
                        UtilMethods.INSTANCE.getCity(EditProf.this, loader, stateId);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            ArrayAdapter<String> stateAdapter;
            stateAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, StateList);
            spstate.setAdapter(stateAdapter);
            //  spstate.setSelection(Integer.parseInt(state));
        }
    }

    private void dataParseCity(String from) {
        //Log.d("dataParse: ",from);

        Gson gson = new Gson();
        cityresponse = gson.fromJson(from, GalleryListResponse.class);
        citysponsespinner = cityresponse.getData();
        if (citysponsespinner.size() > 0) {
            if (citysponsespinner != null && citysponsespinner.size() > 0) {
                for (int i = 0; i < citysponsespinner.size(); i++) {
                    CityList.add(citysponsespinner.get(i).getName());
                    CityId.add(citysponsespinner.get(i).getId());
                }
            }
            spcity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.e("spinner", "  position   " + position + "  ,  id  " + id);
                    if (parent.getItemAtPosition(position).toString().equals("Select City")) {
                    } else {
                        cityId = CityId.get(position);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            ArrayAdapter<String> cityAdapter;
            cityAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, CityList);
            spcity.setAdapter(cityAdapter);
            // spcity.setSelection(Integer.parseInt(city));
            // userid.setSelection(((ArrayAdapter<String>) userid.getAdapter()).getPosition(balanceCheckResponse.getDistrict_name()));

        }
    }

    private void dataParsebank(String from) {
        //Log.d("dataParse: ",from);

        Gson gson = new Gson();
        bankresponse = gson.fromJson(from, GalleryListResponse.class);
        banksponsespinner = bankresponse.getData();
        if (banksponsespinner.size() > 0) {
            if (banksponsespinner != null && banksponsespinner.size() > 0) {
                for (int i = 0; i < banksponsespinner.size(); i++) {
                    BankList.add(banksponsespinner.get(i).getName());
                    BankId.add(banksponsespinner.get(i).getId());
                }
            }
            spbankname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.e("spinner", "  position   " + position + "  ,  id  " + id);
                    if (parent.getItemAtPosition(position).toString().equals("Select City")) {
                    } else {
                        bankId = BankId.get(position);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            ArrayAdapter<String> cityAdapter;
            cityAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, BankList);
            spbankname.setAdapter(cityAdapter);
            spbankname.setSelection(Integer.parseInt(bank));
            // userid.setSelection(((ArrayAdapter<String>) userid.getAdapter()).getPosition(balanceCheckResponse.getDistrict_name()));

        }
    }



    @Override
    public void onClick(View v) {

        if (v == personal) {
            personal.setTextColor(getResources().getColor(R.color.darkblack));
            personal.setTypeface(personal.getTypeface(), Typeface.BOLD);
            account.setTextColor(getResources().getColor(R.color.texttoggle));
            contact.setTextColor(getResources().getColor(R.color.texttoggle));


            etname.setVisibility(View.VISIBLE);
            namelayout.setVisibility(View.VISIBLE);
            etfathername.setVisibility(View.VISIBLE);
            fnamelayout.setVisibility(View.VISIBLE);
            etdob.setVisibility(View.VISIBLE);
            doblayout.setVisibility(View.VISIBLE);
            etemail.setVisibility(View.VISIBLE);
            emaillayout.setVisibility(View.VISIBLE);
            etmobile.setVisibility(View.VISIBLE);
            mobilelayout.setVisibility(View.VISIBLE);
            personalsumit.setVisibility(View.VISIBLE);


            ethouseno.setVisibility(View.GONE);
            houselayout.setVisibility(View.GONE);
            etadd.setVisibility(View.GONE);
            addlayout.setVisibility(View.GONE);
            etzip.setVisibility(View.GONE);
            ziplayout.setVisibility(View.GONE);
          //  statelayout.setVisibility(View.GONE);
            spcity.setVisibility(View.GONE);
            spstate.setVisibility(View.GONE);
            spcountry.setVisibility(View.GONE);
            contactsumit.setVisibility(View.GONE);

            etpan.setVisibility(View.GONE);
            panlayout.setVisibility(View.GONE);
            spbankname.setVisibility(View.GONE);
            etifsc.setVisibility(View.GONE);
            ifsclayout.setVisibility(View.GONE);
            etaccno.setVisibility(View.GONE);
            accountnamelayout.setVisibility(View.GONE);
            etaccname.setVisibility(View.GONE);
            accountnumberlayout.setVisibility(View.GONE);
            accsumit.setVisibility(View.GONE);
        }


            else if (v == personalsumit) {
                if (etname.getText().toString().isEmpty()) {
                    etname.setError("Please enter your name");
                    etname.requestFocus();
                } else if (etfathername.getText().toString().isEmpty()) {
                    etfathername.setError("Please enter your father's name");
                    etfathername.requestFocus();
                } else if (etemail.getText().toString().isEmpty()) {
                    etemail.setError("Please enter your email");
                    etemail.requestFocus();
                } else if (etdob.getText().toString().isEmpty()) {
                    etdob.setError("Please enter select dob");
                    etdob.requestFocus();
                } else if (etmobile.getText().toString().isEmpty()) {
                    etmobile.setError("Please enter your mobile no.");
                    etmobile.requestFocus();
                }
                else if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                    Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
                }


                else {
                    loader.show();
                    loader.setCancelable(false);
                    loader.setCanceledOnTouchOutside(false);
                    UtilMethods.INSTANCE.updatePersonalInfo(EditProf.this, loader, etname.getText().toString(), etfathername.getText().toString()
                            , etdob.getText().toString(), etemail.getText().toString(), etmobile.getText().toString());

                }

            }



     /*       personalsumit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (etname.getText().toString().isEmpty()) {
                        etname.setError("Please enter your name");
                        etname.requestFocus();
                    }
                    else if (etdob.getText().toString().isEmpty()) {
                        etdob.setError("Please enter select dob");
                        etdob.requestFocus();
                    }
                    else if (etmobile.getText().toString().isEmpty()) {
                        etmobile.setError("Please enter your mobile no.");
                        etmobile.requestFocus();
                    }
                    else {
                        loader.show();
                        loader.setCancelable(false);
                        loader.setCanceledOnTouchOutside(false);
                        UtilMethods.INSTANCE.updatePersonalInfo(EditProf.this, loader, etname.getText().toString(), etfathername.getText().toString()
                                , etdob.getText().toString(), etemail.getText().toString(), etmobile.getText().toString()
                        );


                    }

                }
            });  */


            else if (v == contact) {
            contact.setTextColor(getResources().getColor(R.color.darkblack));
            contact.setTypeface(contact.getTypeface(), Typeface.BOLD);
            personal.setTextColor(getResources().getColor(R.color.texttoggle));
            account.setTextColor(getResources().getColor(R.color.texttoggle));

            ethouseno.setVisibility(View.VISIBLE);
            houselayout.setVisibility(View.VISIBLE);
            etadd.setVisibility(View.VISIBLE);
           // statelayout.setVisibility(View.VISIBLE);
            addlayout.setVisibility(View.VISIBLE);
            etzip.setVisibility(View.VISIBLE);
            ziplayout.setVisibility(View.VISIBLE);
            spcity.setVisibility(View.VISIBLE);
            spstate.setVisibility(View.VISIBLE);
            spcountry.setVisibility(View.VISIBLE);
            contactsumit.setVisibility(View.VISIBLE);


            etname.setVisibility(View.GONE);
            namelayout.setVisibility(View.GONE);
            etfathername.setVisibility(View.GONE);
            fnamelayout.setVisibility(View.GONE);
            etdob.setVisibility(View.GONE);
            doblayout.setVisibility(View.GONE);
            etemail.setVisibility(View.GONE);
            emaillayout.setVisibility(View.GONE);
            etmobile.setVisibility(View.GONE);
            mobilelayout.setVisibility(View.GONE);
            personalsumit.setVisibility(View.GONE);

            etpan.setVisibility(View.GONE);
            panlayout.setVisibility(View.GONE);
            spbankname.setVisibility(View.GONE);
            etifsc.setVisibility(View.GONE);
            ifsclayout.setVisibility(View.GONE);
            etaccno.setVisibility(View.GONE);
            accountnumberlayout.setVisibility(View.GONE);
            etaccname.setVisibility(View.GONE);
            accountnumberlayout.setVisibility(View.GONE);
            accsumit.setVisibility(View.GONE);
        }

            else if (v == contactsumit) {
                    if (ethouseno.getText().toString().isEmpty()) {
                        ethouseno.setError("Please enter your house no.");
                        ethouseno.requestFocus();
                    } else if (etadd.getText().toString().isEmpty()) {
                        etadd.setError("Please enter address");
                        etadd.requestFocus();
                    } else if (etzip.getText().toString().isEmpty()) {
                        etzip.setError("Please enter your zip");
                        etzip.requestFocus();
                    } else if (countryId.equalsIgnoreCase("0")) {
                        Toast.makeText(EditProf.this, "Please select country", Toast.LENGTH_SHORT).show();
                    } else if (stateId.equalsIgnoreCase("0")) {
                        Toast.makeText(EditProf.this, "Please select state", Toast.LENGTH_SHORT).show();
                    } else if (cityId.equalsIgnoreCase("0")) {
                        Toast.makeText(EditProf.this, "Please select city", Toast.LENGTH_SHORT).show();
                    }
                    else if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                        Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        loader.show();
                        loader.setCancelable(false);
                        loader.setCanceledOnTouchOutside(false);
                        UtilMethods.INSTANCE.updateuserContactDetails(EditProf.this, loader, ethouseno.getText().toString(), etadd.getText().toString()
                                , etzip.getText().toString(), countryId, stateId, cityId
                        );
                    }


                }



           /* contactsumit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(ethouseno.getText().toString().isEmpty())
                    {
                        ethouseno.setError("Please enter your house no.");
                        ethouseno.requestFocus();
                    }
                    else if(etadd.getText().toString().isEmpty())
                    {
                        etadd.setError("Please enter address");
                        etadd.requestFocus();
                    }
                    else if(etzip.getText().toString().isEmpty())
                    {
                        etzip.setError("Please enter your zip");
                        etzip.requestFocus();
                    }
                    else if(countryId.equalsIgnoreCase("0"))
                    {
                        Toast.makeText(EditProf.this, "Please select country", Toast.LENGTH_SHORT).show();
                    }
                    else if(stateId.equalsIgnoreCase("0"))
                    {
                        Toast.makeText(EditProf.this, "Please select state", Toast.LENGTH_SHORT).show();
                    }
                    else if(cityId.equalsIgnoreCase("0"))
                    {
                        Toast.makeText(EditProf.this, "Please select city", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        loader.show();
                        loader.setCancelable(false);
                        loader.setCanceledOnTouchOutside(false);
                        UtilMethods.INSTANCE.updateuserContactDetails(EditProf.this,loader,ethouseno.getText().toString(),etadd.getText().toString()
                                ,etzip.getText().toString(),countryId,stateId,cityId
                        );
                    }


                }
            }); */


           else if (v == account) {
            account.setTextColor(getResources().getColor(R.color.darkblack));
            account.setTypeface(account.getTypeface(), Typeface.BOLD);
            personal.setTextColor(getResources().getColor(R.color.texttoggle));
            contact.setTextColor(getResources().getColor(R.color.texttoggle));

            ethouseno.setVisibility(View.GONE);
            houselayout.setVisibility(View.GONE);
            etadd.setVisibility(View.GONE);
            addlayout.setVisibility(View.GONE);
            etzip.setVisibility(View.GONE);
          //  statelayout.setVisibility(View.GONE);
            ziplayout.setVisibility(View.GONE);
            spcity.setVisibility(View.GONE);
            spstate.setVisibility(View.GONE);
            spcountry.setVisibility(View.GONE);

            contactsumit.setVisibility(View.GONE);

            etname.setVisibility(View.GONE);
            namelayout.setVisibility(View.GONE);
            etfathername.setVisibility(View.GONE);
            fnamelayout.setVisibility(View.GONE);
            etdob.setVisibility(View.GONE);
            doblayout.setVisibility(View.GONE);
            etemail.setVisibility(View.GONE);
            emaillayout.setVisibility(View.GONE);
            etmobile.setVisibility(View.GONE);
            mobilelayout.setVisibility(View.GONE);
            personalsumit.setVisibility(View.GONE);

            etpan.setVisibility(View.VISIBLE);
            panlayout.setVisibility(View.VISIBLE);
            spbankname.setVisibility(View.VISIBLE);
            etifsc.setVisibility(View.VISIBLE);
            ifsclayout.setVisibility(View.VISIBLE);
            etaccno.setVisibility(View.VISIBLE);
            accountnumberlayout.setVisibility(View.VISIBLE);
            etaccname.setVisibility(View.VISIBLE);
            accountnamelayout.setVisibility(View.VISIBLE);
            accsumit.setVisibility(View.VISIBLE);
        }

               else if (v == accsumit) {
                    if (etpan.getText().toString().isEmpty()) {
                        etpan.setError("Please enter your pan no.");
                        etpan.requestFocus();
                    } else if (bankId.equalsIgnoreCase("0")) {
                        Toast.makeText(EditProf.this, "Please select bank", Toast.LENGTH_SHORT).show();
                    } else if (etifsc.getText().toString().isEmpty()) {
                        etifsc.setError("Please enter your IFSC");
                        etifsc.requestFocus();
                    } else if (etaccno.getText().toString().isEmpty()) {
                        etaccno.setError("Please enter your account no.");
                        etaccno.requestFocus();
                    } else if (etaccname.getText().toString().isEmpty()) {
                        etaccname.setError("Please enter your account holder name");
                        etaccname.requestFocus();
                    }

                    else if (UtilMethods.INSTANCE.isNetworkAvialable(this) == false) {
                        Toast.makeText(this, "Please Check Your Network Connectivity", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        loader.show();
                        loader.setCancelable(false);
                        loader.setCanceledOnTouchOutside(false);
                        UtilMethods.INSTANCE.updateBankInfo(EditProf.this, loader, etpan.getText().toString(), bankId
                                , etifsc.getText().toString(), etaccno.getText().toString(), etaccname.getText().toString()
                        );
                    }

                }




          /*  accsumit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(etpan.getText().toString().isEmpty())
                    {
                        etpan.setError("Please enter your pan no.");
                        etpan.requestFocus();
                    }
                    else if(bankId.equalsIgnoreCase("0"))
                    {
                        Toast.makeText(EditProf.this, "Please select bank", Toast.LENGTH_SHORT).show();
                    }
                    else if(etifsc.getText().toString().isEmpty())
                    {
                        etifsc.setError("Please enter your IFSC");
                        etifsc.requestFocus();
                    }
                    else if(etaccno.getText().toString().isEmpty())
                    {
                        etaccno.setError("Please enter your account no.");
                        etaccno.requestFocus();
                    }
                    else if(etaccname.getText().toString().isEmpty())
                    {
                        etaccname.setError("Please enter your account holder name");
                        etaccname.requestFocus();
                    }
                    else
                    {
                        loader.show();
                        loader.setCancelable(false);
                        loader.setCanceledOnTouchOutside(false);
                        UtilMethods.INSTANCE.updateBankInfo(EditProf.this,loader,etpan.getText().toString(),bankId
                                ,etifsc.getText().toString(),etaccno.getText().toString(),etaccname.getText().toString()
                        );
                    }

                }
            });    */

           else if (v == revert) {
                Intent intent = new Intent(EditProf.this, Settings.class);
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
