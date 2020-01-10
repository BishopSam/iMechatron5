package com.example.imechatron;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FourthYearActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FourthYAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthyearcourses);

        final ArrayList<FourthY> fourthYlist = new ArrayList<>();
        fourthYlist.add(new FourthY(R.drawable.fourthh));


        mRecyclerView = findViewById(R.id.rv_fourthy);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FourthYAdapter(fourthYlist);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
