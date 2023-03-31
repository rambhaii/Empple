package com.empeople.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.empeople.Data.Dataum;
import com.empeople.R;

import java.util.ArrayList;

public class ReferralListAdapter extends RecyclerView.Adapter<ReferralListAdapter.MyViewHolder> {
    private ArrayList<Dataum> refferalList;

    public ReferralListAdapter(ArrayList<Dataum> refferalList, Context mContext) {
        this.refferalList = refferalList;
        this.mContext = mContext;
    }

    private Context mContext;
    @NonNull
    @Override
    public ReferralListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.referrallayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReferralListAdapter.MyViewHolder holder, int position) {
        final Dataum operator = refferalList.get(position);
        holder.tvname.setText(operator.getName());
        holder.tvuserid.setText(operator.getUserID());
        holder.tvdate.setText(operator.getJoindate());
        Glide
                .with(mContext)
                .load(operator.getProfile())
                .centerCrop()
                .placeholder(R.drawable.profiledemopic)
                .into(holder.prfile_img);
    }




    @Override
    public int getItemCount() {
        return refferalList.size();}


        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView prfile_img;
            TextView tvuserid,tvname,tvdate;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                prfile_img=itemView.findViewById(R.id.profile_image);
                tvuserid=itemView.findViewById(R.id.tvuserid);
                tvname=itemView.findViewById(R.id.tvname);
                tvdate=itemView.findViewById(R.id.tvdate);



            }
        }
    }

