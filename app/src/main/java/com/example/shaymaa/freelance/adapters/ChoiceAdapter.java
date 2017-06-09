package com.example.shaymaa.freelance.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


import com.example.shaymaa.freelance.R;
import com.example.shaymaa.freelance.models.Choice;

import java.util.List;

import static com.example.shaymaa.freelance.Utility.Constant.CHOICE_SELECTED_POSITION;

//import static com.truedreamz.akc_parallelrecyclerview.Utility.Constant.CHOICE_SELECTED_POSITION;

/**
 * Created by wisdom-JP on 12/1/2016.
 */

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.AKCViewHolder>{

    private Context mContext;
    private List<Choice> mChoiceList;
    private final static int FADE_DURATION = 300; // in milliseconds
    private int lastPosition = -1;

    public class AKCViewHolder extends RecyclerView.ViewHolder {
        public ImageView choiceIcon;

        public AKCViewHolder(View view) {
            super(view);
            choiceIcon = (ImageView) view.findViewById(R.id.choiceImage);
        }
    }

    public ChoiceAdapter(Context mContext, List<Choice> choiceList) {
        this.mContext = mContext;
        this.mChoiceList = choiceList;
    }

    @Override
    public AKCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View categoryItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_choice_card,parent,false);

        return new AKCViewHolder(categoryItem);
    }

    @Override
    public void onBindViewHolder(AKCViewHolder holder, int position) {
        Choice choiceItem=mChoiceList.get(position);
        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),choiceItem.choice_icon);
        holder.choiceIcon.setImageBitmap(icon);
        //holder.choiceIcon.setBackgroundResource(choiceItem.choice_icon);
        // Set the view to fade in
        //setScaleAnimation(holder.itemView);

        if(CHOICE_SELECTED_POSITION == position){
            // Here I am just highlighting the background
            holder.choiceIcon.setBackgroundColor(mContext.getResources().getColor(R.color.colorPickedItem));
        }else{
            holder.choiceIcon.setBackgroundColor(mContext.getResources().getColor(R.color.colorItembg));
        }

    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return mChoiceList.size();
    }
}