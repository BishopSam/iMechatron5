package com.example.imechatron;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FourthYAdapter extends RecyclerView.Adapter<FourthYAdapter.FourthYViewHolder>{
    private ArrayList<FourthY> mFourthYList;

    public static class FourthYViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageV2;
        public FourthYViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageV2 = itemView.findViewById(R.id.fourth_s);
        }
    }

    public FourthYAdapter(ArrayList<FourthY> fourthYList){
        mFourthYList = fourthYList;
    }
    @NonNull
    @Override
    public FourthYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fourthy,parent, false);
        FourthYViewHolder ivh1 = new FourthYViewHolder(v);

        return ivh1;

    }

    @Override
    public void onBindViewHolder(@NonNull FourthYViewHolder holder, int position) {

        FourthY currentItem = mFourthYList.get(position);

        holder.mImageV2.setImageResource(currentItem.getImageResource6());

    }

    @Override
    public int getItemCount() {

            return mFourthYList.size();

    }




}
