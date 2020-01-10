package com.example.imechatron;

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

public class RoboticsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_robotics, container, false);

        ArrayList<FinalY> finalYList = new ArrayList<>();
        finalYList.add(new FinalY(R.drawable.roboticsh, "ROBOTICS & AUTOMATION OPTION"));
        finalYList.add(new FinalY(R.drawable.roboticsr, ""));
        finalYList.add(new FinalY(R.drawable.electivesh, "AVAILABLE ELECTIVES"));
        finalYList.add(new FinalY(R.drawable.electivesr, ""));

        mRecyclerView = view.findViewById(R.id.rv_robotics);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FinalYAdapter(finalYList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

}

