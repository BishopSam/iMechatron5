package com.example.imechatron;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FinalYAdapter extends RecyclerView.Adapter<FinalYAdapter.FinalYViewHolder>{
    private ArrayList<FinalY> mFinalYList;

    public static class FinalYViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageV3;
        TextView mTextView;
        public FinalYViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageV3 = itemView.findViewById(R.id.final_s);
            mTextView = itemView.findViewById(R.id.tv_finaly);
        }
    }

    public FinalYAdapter(ArrayList<FinalY> finalYList){
        mFinalYList = finalYList;
    }
    @NonNull
    @Override
    public FinalYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.finaly,parent, false);
        FinalYViewHolder ivh1 = new FinalYViewHolder(v);

        return ivh1;

    }

    @Override
    public void onBindViewHolder(@NonNull FinalYViewHolder holder, int position) {

        FinalY currentItem = mFinalYList.get(position);

        holder.mImageV3.setImageResource(currentItem.getImageResource7());
        holder.mTextView.setText(currentItem.getmText5());

        switch (position) {
            case 1:
            holder.mTextView.setVisibility(View.GONE);
            break;
            case 3:
                holder.mTextView.setVisibility(View.GONE);
                break;
            default:
                holder.mTextView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {

            return mFinalYList.size();

    }




}
