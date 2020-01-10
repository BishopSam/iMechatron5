package com.example.imechatron;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThirdYAdapter extends RecyclerView.Adapter<ThirdYAdapter.ThirdYViewHolder>{
    private ArrayList<ThirdY> mThirdYList;

    public static class ThirdYViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageV1;
        public ThirdYViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageV1 = itemView.findViewById(R.id.third_s);
        }
    }

    public ThirdYAdapter(ArrayList<ThirdY> thirdYList){
        mThirdYList = thirdYList;
    }
    @NonNull
    @Override
    public ThirdYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.thirdy,parent, false);
        ThirdYViewHolder ivh1 = new ThirdYViewHolder(v);

        return ivh1;

    }

    @Override
    public void onBindViewHolder(@NonNull ThirdYViewHolder holder, int position) {

        ThirdY currentItem = mThirdYList.get(position);

        holder.mImageV1.setImageResource(currentItem.getImageResource5());

    }

    @Override
    public int getItemCount() {

            return mThirdYList.size();

    }




}
