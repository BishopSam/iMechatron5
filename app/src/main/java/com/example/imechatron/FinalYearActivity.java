package com.example.imechatron;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FinalYearActivity extends AppCompatActivity {
    private SoftwareFragment softwareFragment;
    private RoboticsFragment roboticsFragment;
    private ControlFragment controlFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalyearcourses);
        BottomNavigationView navView = findViewById(R.id.nav_view2);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState == null){
            softwareFragment= new SoftwareFragment();
            roboticsFragment = new RoboticsFragment();
            controlFragment = new ControlFragment();

        }

        displaySoftwareFragment();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_computer:
                    displaySoftwareFragment();
                    break;
                case R.id.navigation_control:
                    displayControlFragment();
                    break;
                case R.id.navigation_robotics:
                    displayRoboticsFragment();
                    break;

            }

            return true;
        }
    };

    private void displayRoboticsFragment() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (roboticsFragment.isAdded()){
            ft.show(roboticsFragment);
        } else {
            ft.add(R.id.fragment_container2, roboticsFragment, "Robotics");
        }
        if (softwareFragment.isAdded()){ft.hide(softwareFragment);}
        if (controlFragment.isAdded()) {ft.hide(controlFragment);}

        ft.commit();

    }

    private void displayControlFragment() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (controlFragment.isAdded()){
            ft.show(controlFragment);
        } else {
            ft.add(R.id.fragment_container2, controlFragment, "Control");
        }
        if (softwareFragment.isAdded()){ft.hide(softwareFragment);}
        if (roboticsFragment.isAdded()) {ft.hide(roboticsFragment);}

        ft.commit();

    }

    private void displaySoftwareFragment() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (softwareFragment.isAdded()){
            ft.show(softwareFragment);
        } else {
            ft.add(R.id.fragment_container2, softwareFragment, "Software");
        }
        if (roboticsFragment.isAdded()){ft.hide(roboticsFragment);}
        if (controlFragment.isAdded()) {ft.hide(controlFragment);}

        ft.commit();

    }


}
/*final ArrayList<FinalY> finalYList = new ArrayList<>();
        finalYList.add(new FinalY(R.drawable.computerh,"COMPUTER SYSTEMS & SOFTWARE DEVELOPMENT OPTION"));
        finalYList.add(new FinalY(R.drawable.computerr,""));
        finalYList.add(new FinalY(R.drawable.controlh,"CONTROL " + "& DRIVES OPTION"));
        finalYList.add(new FinalY(R.drawable.controlr,""));
        finalYList.add(new FinalY(R.drawable.roboticsh,"ROBOTICS AND AUTOMATION OPTION"));
        finalYList.add(new FinalY(R.drawable.roboticsr,""));
        finalYList.add(new FinalY(R.drawable.electivesh,"ELECTIVE COURSES FOR THE ABOVE OPTIONS"));
        finalYList.add(new FinalY(R.drawable.electivesr,""));

        mRecyclerView = findViewById(R.id.rv_finaly);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FinalYAdapter(finalYList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);*/
