package com.empeople.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.empeople.Data.Dataum;
import com.empeople.Data.Dataz;
import com.empeople.Data.FaqData;
import com.empeople.R;
import com.empeople.Register;

import java.util.ArrayList;
import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

   // private List<FaqData> faqList;
    private List<Dataz> faqList;

    Context context;

    public FaqAdapter(List<Dataz> faqList, Context context ) {
        this.faqList = faqList;
        this.context=context;


    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.card_item, null,false);
        FaqAdapter.ViewHolder viewHolder = new FaqAdapter.ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       // FaqData datas = faqList.get(faqList.size());
        Dataz request = faqList.get(position);
       // final Dataum operator = refferalList.get(0);
        holder.title.setText(request.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



   @Override
   public int getItemCount() {
        return faqList.size();
   }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CardView cardView;
        ImageView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            photo = itemView.findViewById(R.id.photo);
            cardView=itemView.findViewById(R.id.cardView);



        }
    }
    public void setList(List<Dataz> list) {
        this.faqList = list;
        notifyDataSetChanged();
    }
}
























