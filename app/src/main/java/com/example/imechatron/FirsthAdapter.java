package com.example.imechatron;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirsthAdapter extends RecyclerView.Adapter<FirsthAdapter.FirsthViewHolder> {
    private ArrayList<Firsth> mFirsthList;
    private Context mContext ;

    public static class FirsthViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView3;
        CardView cardView;


        public FirsthViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView3 = itemView.findViewById(R.id.first_h);
            cardView = itemView.findViewById(R.id.card_view3);
        }
    }

    public FirsthAdapter(ArrayList<Firsth> firsthList){
        mFirsthList = firsthList;
    }
    @NonNull
    @Override
    public FirsthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.firsth,parent, false);
        FirsthViewHolder ivh1 = new FirsthViewHolder(v);

        return ivh1;

    }

    @Override
    public void onBindViewHolder(@NonNull FirsthViewHolder holder, final int position) {
        Firsth currentItem = mFirsthList.get(position);

        holder.mImageView3.setImageResource(currentItem.getImageResource3());



    }

    @Override
    public int getItemCount() {
        return mFirsthList.size();
    }


}
