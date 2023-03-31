package com.empeople;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.empeople.Data.joiningList;
import com.empeople.Utils.ApplicationConstant;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewJoin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewJoin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView tvnewjoin,tvtotaljoin, verifyleft,nonverifyleft,verifyRight,nonverifyRight;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String newjoin="0";
    String totaljoin="0";

    public NewJoin() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewJoin.
     */
    // TODO: Rename and change types and number of parameters
    public static NewJoin newInstance(String param1, String param2) {
        NewJoin fragment = new NewJoin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_new_join, container, false);
        tvnewjoin=v.findViewById(R.id.tvnewjoin);
        tvtotaljoin=v.findViewById(R.id.tvtotaljoin);
        verifyRight=v.findViewById(R.id.verifyright);
        nonverifyRight=v.findViewById(R.id.nonverifyright);
        nonverifyleft=v.findViewById(R.id.nonverifyleft);
        verifyleft=v.findViewById(R.id.verifyleft);
        SharedPreferences myPreferences = getActivity().getSharedPreferences(ApplicationConstant.INSTANCE.prefpoint, +MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.pointresponse, null);
        joiningList securelogincheckResponse = new Gson().fromJson(secureloginResponse, joiningList.class);
        if(secureloginResponse!=null)
        {
            newjoin=securelogincheckResponse.getNewJoin();
            totaljoin=securelogincheckResponse.getTotalJoin();
            String vleft=securelogincheckResponse.getVerifyLeftUser();
            String nvleft=securelogincheckResponse.getNonVerifyLeftUser();
            String vright=securelogincheckResponse.getVerifyRightUser();
            String nvRight=securelogincheckResponse.getNonVerifyRightUser();

            tvtotaljoin.setText(totaljoin);
            tvnewjoin.setText(newjoin);
            verifyleft.setText(vleft);
            verifyRight.setText(vright);
            nonverifyleft.setText(nvleft);
            nonverifyRight.setText(nvRight);

        }
        else {

        }
//
        return v;
    }
}

