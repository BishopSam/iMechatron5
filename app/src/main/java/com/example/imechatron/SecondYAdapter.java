package com.example.imechatron;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondYAdapter extends RecyclerView.Adapter<SecondYAdapter.SecondYViewHolder> {
    private ArrayList<SecondY> mSecondYList;

    public static class SecondYViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageV;

        public SecondYViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageV = itemView.findViewById(R.id.second_s);
        }
    }

    public SecondYAdapter(ArrayList<SecondY> secondYList) {
        mSecondYList = secondYList;
    }

    @NonNull
    @Override
    public SecondYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.secondy, parent, false);
        SecondYViewHolder ivh1 = new SecondYViewHolder(v);

        return ivh1;

    }

    @Override
    public void onBindViewHolder(@NonNull SecondYViewHolder holder, int position) {

        SecondY currentItem = mSecondYList.get(position);

        holder.mImageV.setImageResource(currentItem.getImageResource4());

    }

    @Override
    public int getItemCount() {

            return mSecondYList.size();

    }




}
