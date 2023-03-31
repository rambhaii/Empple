package com.empeople.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.empeople.Data.Dataum;
import com.empeople.R;
import com.empeople.Register;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
        private ArrayList<Dataum> refferalList;
        Context context;
        String refid;
        EditText etuserid;
        EditText etreference;


        public RecyclerAdapter(ArrayList<Dataum> arrayList,Context context,EditText etuserid, String refid) {
            this.refferalList = arrayList;
            this.context=context;
            this.etuserid=etuserid;
            this.refid=refid;


        }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.referral_list, null,false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Dataum dataum = refferalList.get(0);
        final Dataum operator = refferalList.get(0);
        holder.userid.setText(dataum.getUserID());
        holder.userid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etuserid.setText(dataum.getUserID()+"");
                Toast.makeText(context, ""+etuserid, Toast.LENGTH_SHORT).show();
                Register.referenceID=dataum.getId();
            }
        });

    }

    @Override
    public int getItemCount() {
        return refferalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userid=itemView.findViewById(R.id.uid);


        }
    }
}


