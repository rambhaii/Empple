package com.empeople.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.empeople.Data.SliderModel;
import com.empeople.Data.SubSliderModel;
import com.empeople.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class IntroSlider extends
        SliderViewAdapter<IntroSlider.SliderAdapterVH> {

    private Context context;
    private List<SubSliderModel> msubslider = new ArrayList<>();

    public IntroSlider(Context context,List<SubSliderModel> SliderItems) {
        this.context = context;
        msubslider=SliderItems;
    }

  /*  public void renewItems(List<SliderModel> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderModel sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }     */


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.introimgslider, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        SubSliderModel sliderItem = msubslider.get(position);

          viewHolder.textViewDescription.setText(sliderItem.getDescription());
           viewHolder.textViewDescription.setTextSize(20);
           viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImg())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

    }


    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return msubslider.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {


        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;
       // TextView tvmain;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
         //   tvmain=itemView.findViewById(R.id.tvmain);
            this.itemView = itemView;
        }
    }

}