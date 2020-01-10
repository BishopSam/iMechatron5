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

import com.example.imechatron.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Item1> itemList = new ArrayList<>();
        itemList.add(new Item1(R.drawable.bluetooth, "Sensor", "Bluetooth Sensor"));
        itemList.add(new Item1(R.drawable.logo, "NAMES", "About"));
        itemList.add(new Item1(R.drawable.sensor2, "sensor2", "About"));

        mRecyclerView = view.findViewById(R.id.rv_home);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ItemAdapter(itemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

}

