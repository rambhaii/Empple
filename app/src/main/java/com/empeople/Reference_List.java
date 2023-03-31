package com.empeople;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.empeople.Adapters.ReferralListAdapter;
import com.empeople.Data.Dataum;
import com.empeople.Data.GalleryListResponse;
import com.empeople.Utils.FragmentActivityMessage;
import com.empeople.Utils.GlobalBus;
import com.empeople.Utils.Loader;
import com.empeople.Utils.UtilMethods;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reference_List#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reference_List extends Fragment {
    Loader loader;
    RecyclerView recyclerefrencelist;
    ReferralListAdapter mAdapter;
    GalleryListResponse refferrelres;
    ArrayList<Dataum> refferrelList = new ArrayList<>();
    LinearLayoutManager mLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Reference_List() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reference_List.
     */
    // TODO: Rename and change types and number of parameters
    public static Reference_List newInstance(String param1, String param2) {
        Reference_List fragment = new Reference_List();
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
        View v = inflater.inflate(R.layout.fragment_reference__list, container, false);
        loader = new Loader(getActivity(), android.R.style.Theme_Translucent_NoTitleBar);
        loader.show();
        loader.setCancelable(false);
        loader.setCanceledOnTouchOutside(false);
        UtilMethods.INSTANCE.getRefferalList(getActivity(), loader);
        recyclerefrencelist = v.findViewById(R.id.recyclerefrencelist);
        return v;
    }
  @Subscribe
public void onFragmentActivityMessage(FragmentActivityMessage activityFragmentMessage) {
    if (activityFragmentMessage.getMessage().equalsIgnoreCase("referrallist")) {
        dataParse(activityFragmentMessage.getFrom());
    }
}

    private void dataParse(String from) {
        Gson gson = new Gson();
        refferrelres = gson.fromJson(from, GalleryListResponse.class);
        refferrelList = refferrelres.getData();
        mAdapter=new ReferralListAdapter(refferrelList,getContext());
        mLayoutManager=new LinearLayoutManager(getActivity());
        recyclerefrencelist.setLayoutManager(mLayoutManager);
        recyclerefrencelist.setAdapter(mAdapter);
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