package com.example.imechatron;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseResultAdapter extends RecyclerView.Adapter<CourseResultAdapter.CourseResultViewHolder> {

    private ArrayList<CourseResult> mCourseResult;

    public static class CourseResultViewHolder extends RecyclerView.ViewHolder{

        TextView tvCourseCode, tvGrade, tvUnit;

        public CourseResultViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseCode= itemView.findViewById(R.id.tv_resultlist);
            tvGrade=itemView.findViewById(R.id.tv1_resultlist);
            tvUnit = itemView.findViewById(R.id.tv2_resultlist);

        }
    }

    public  CourseResultAdapter (ArrayList<CourseResult> courseResults){
        mCourseResult=courseResults;
    }

    @NonNull
    @Override
    public CourseResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.resultlist,parent, false);
        CourseResultViewHolder ivh1 = new CourseResultViewHolder(v);

        return ivh1;

    }

    @Override
    public void onBindViewHolder(@NonNull CourseResultViewHolder holder, int position) {

        CourseResult currentItem = mCourseResult.get(position);

        holder.tvCourseCode.setText(currentItem.getCourseCode());
        holder.tvGrade.setText(currentItem.getGrade());
        holder.tvUnit.setText(currentItem.getNoUnits());
    }

    @Override
    public int getItemCount() {
        return mCourseResult.size();
    }


}
