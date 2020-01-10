package com.example.imechatron;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondYearActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SecondYAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.firstyearcourses);


        final ArrayList<SecondY> secondYList = new ArrayList<>();
        secondYList.add(new SecondY(R.drawable.secondh));
        secondYList.add(new SecondY(R.drawable.secondr));


        mRecyclerView = findViewById(R.id.rv_firsty);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SecondYAdapter(secondYList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

}
