package com.empeople;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.empeople.Data.userPoints;
import com.empeople.Utils.ApplicationConstant;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewMatch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewMatch extends Fragment {
    TextView tvnematch,tvtotalmatch,tvleftmatch,tvrightmatch;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewMatch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewMatch.
     */
    // TODO: Rename and change types and number of parameters
    public static NewMatch newInstance(String param1, String param2) {
        NewMatch fragment = new NewMatch();
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
        View v=inflater.inflate(R.layout.fragment_new_match, container, false);
        tvnematch=v.findViewById(R.id.tvnewmatch);
        tvtotalmatch=v.findViewById(R.id.tvtotalmatch);
        tvleftmatch=v.findViewById(R.id.tvleftmatch);
        tvrightmatch=v.findViewById(R.id.tvrightmatch);
        SharedPreferences myPreferences = getActivity().getSharedPreferences(ApplicationConstant.INSTANCE.Usermatchpoint, +MODE_PRIVATE);
        String secureloginResponse = myPreferences.getString(ApplicationConstant.INSTANCE.pointresponse1, null);
        userPoints securelogincheckResponse = new Gson().fromJson(secureloginResponse, userPoints.class);
        if(secureloginResponse!=null)
        {
            tvnematch.setText(securelogincheckResponse.getNewMatchPoint());
            tvtotalmatch.setText(securelogincheckResponse.getAllTotalMatchPoint());
            tvleftmatch.setText(securelogincheckResponse.getLeft_point());
            tvrightmatch.setText(securelogincheckResponse.getRight_point());



        }
        return  v;
    }
}