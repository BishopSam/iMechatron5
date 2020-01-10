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

public class ItemMyCoursesAdapter extends RecyclerView.Adapter<ItemMyCoursesAdapter.ItemMyCoursesViewHolder> {
    private ArrayList<ItemMycourses> mItemMycoursesList;
    private Context mContext ;



    public static class ItemMyCoursesViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView2;
        public TextView mTextView3;
        public TextView mTextView4;
        CardView cardview;

        public ItemMyCoursesViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView2 = itemView.findViewById(R.id.iv_mycourses);
            mTextView3 = itemView.findViewById(R.id.tv1_mycourses);
            mTextView4 = itemView.findViewById(R.id.tv2_mycourses);
            cardview = itemView.findViewById(R.id.card_view2);
        }
    }


    public ItemMyCoursesAdapter(ArrayList<ItemMycourses> itemMycoursesList){
        mItemMycoursesList = itemMycoursesList;
    }
    @NonNull
    @Override

    public ItemMyCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mycourses,parent, false);
        ItemMyCoursesViewHolder ivh1 = new ItemMyCoursesViewHolder(v);
        return ivh1;

    }



    @Override
    public void onBindViewHolder(@NonNull ItemMyCoursesViewHolder holder, final int position) {

        ItemMycourses currentItem = mItemMycoursesList.get(position);

        holder.mImageView2.setImageResource(currentItem.getImageResource2());
        holder.mTextView3.setText(currentItem.getText3());
        holder.mTextView4.setText(currentItem.getText4());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext=view.getContext();
                Intent intent;
                switch (position){
                    case 0:
                    intent = new Intent(mContext, FirstYearCoursesActivity.class);
                    mContext.startActivity(intent);
                    break;

                    case 1:
                        intent = new Intent(mContext, SecondYearActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(mContext, ThirdYearActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(mContext, FourthYearActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(mContext, FinalYearActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(mContext, RegisterCoursesActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(mContext,GetStudyMaterialsActivity.class);
                        mContext.startActivity(intent);
                        break;


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemMycoursesList.size();
    }


}
