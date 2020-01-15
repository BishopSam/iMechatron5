package com.example.imechatron;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FourthYearActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirsthAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstyearcourses);

        final ArrayList<Firsth> firsthList = new ArrayList<>();
        firsthList.add(new Firsth(R.drawable.fourthh));


        mRecyclerView = findViewById(R.id.rv_firsty);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FirsthAdapter(firsthList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
