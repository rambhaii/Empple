package com.empeople.Adapters;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.empeople.Data.SliderModel;
import com.empeople.Data.SubSliderModel;
import com.empeople.R;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private List<SliderModel> mSliderItems = new ArrayList<>();
  //  private List<SubSliderModel> nSliderItems = new ArrayList<>();
    int lastPosition=-1;
    boolean value=false;

    public SliderAdapterExample(Context context,List<SliderModel> SliderItems) {
        this.context = context;
            mSliderItems=SliderItems;
          //nSliderItems=SubsliderItems;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliderimage, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        SliderModel sliderItem = mSliderItems.get(position);
        Log.d("dklfgjkfjgk",""+position);
     if (position==1)
     {        viewHolder.relative1.setVisibility(View.GONE);
         Animation ainm=AnimationUtils.loadAnimation(context,R.anim.left_to_right);
         viewHolder.collection.startAnimation(ainm);
         viewHolder.winter.startAnimation(AnimationUtils.loadAnimation(context,R.anim.winter));
         Animation Bottom=AnimationUtils.loadAnimation(context,R.anim.bottom);
         viewHolder.vv.startAnimation(AnimationUtils.loadAnimation(context,R.anim.bottom));
         // Bottom.setRepeatMode(position);
       //  Bottom.setRepeatCount(500);
     }
     else if(position==0)
     {
         viewHolder.relative.setVisibility(View.GONE);
         viewHolder.relative1.setVisibility(View.VISIBLE);
         viewHolder.winter2.startAnimation(AnimationUtils.loadAnimation(context,R.anim.winter2));}
     Glide.with(viewHolder.itemView)
                .load(sliderItem.getImg())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

         Glide.with(viewHolder.itemView)
                .load(sliderItem.getImage(R.drawable.bnrb))
                .fitCenter()
                .into(viewHolder.imageGifContainer);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImage(R.drawable.lastlogo))
                .fitCenter()
                .into(viewHolder.vv);
    }
    
    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }


    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {


        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer,vv;
        TextView textViewDescription,collection,winter,winter2;
        FrameLayout fl_shadow_container;
        RelativeLayout relative,relative1;
        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            vv = itemView.findViewById(R.id.vv);
            fl_shadow_container = itemView.findViewById(R.id.fl_shadow_container);
            collection = itemView.findViewById(R.id.collection);
            winter = itemView.findViewById(R.id.winter);
            relative = itemView.findViewById(R.id.relative);
            relative1 = itemView.findViewById(R.id.relative1);
            winter2 = itemView.findViewById(R.id.winter2);
            this.itemView = itemView;
        }
    }

}
