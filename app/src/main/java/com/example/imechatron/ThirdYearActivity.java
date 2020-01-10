package com.example.imechatron;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThirdYearActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ThirdYAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdyearcourses);

        final ArrayList<ThirdY> thirdYList = new ArrayList<>();
        thirdYList.add(new ThirdY(R.drawable.thirdh));
        thirdYList.add(new ThirdY(R.drawable.thirdr));

        mRecyclerView = findViewById(R.id.rv_thirdy);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ThirdYAdapter(thirdYList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
