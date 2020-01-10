package com.example.imechatron;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCoursesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ItemMyCoursesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycourses, container, false);



        final ArrayList<ItemMycourses> itemMycoursesList = new ArrayList<>();
        itemMycoursesList.add(new ItemMycourses(R.drawable.firstyear, "100l Courses", "Courses offered in your first year"));
        itemMycoursesList.add(new ItemMycourses(R.drawable.secondyear, "200l Courses", "Courses offered in your second year"));
        itemMycoursesList.add(new ItemMycourses(R.drawable.thirdyear, "300l Courses", "Courses offered in your third year"));
        itemMycoursesList.add(new ItemMycourses(R.drawable.fourthyear, "400l Courses", "Courses offered in your fourth year"));
        itemMycoursesList.add(new ItemMycourses(R.drawable.fifthyear, "500l Courses", "Courses offered in your final year"));
        itemMycoursesList.add(new ItemMycourses(R.drawable.rcourses, "Register My Courses", "Click here to register your courses"));
        itemMycoursesList.add(new ItemMycourses(R.drawable.pastquest, "Get Study Materials", "Click here to get study materials"));
        mRecyclerView = view.findViewById(R.id.rv_mycourses);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ItemMyCoursesAdapter(itemMycoursesList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }


}
