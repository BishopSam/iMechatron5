package com.example.imechatron;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    public final int RQ_AUTH_UI = 100;
    private TextView mTextMessage;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String rpi;
    private HomeFragment homeFragment;
    private ScholarshipFragment scholarshipFragment;
    private MyCoursesFragment mycoursesFragment;
    private MoreFragment moreFragment;
    private static final String TAG = "MainActivity";

 /*    ArrayList<Item1> itemList = new ArrayList<>();
        itemList.add(new Item1(R.drawable.bluetooth, "Sensor", "Bluetooth Sensor"));
        itemList.add(new Item1(R.drawable.logo, "NAMES", "About"));
        itemList.add(new Item1(R.drawable.sensor2, "sensor2", "About"));

    mRecyclerView = findViewById(R.id.rv_home);
        mRecyclerView.setHasFixedSize(true);
    mLayoutManager = new LinearLayoutManager(this);
    mAdapter = new ItemAdapter(itemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
*/


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    displayHomeFragment();
                    getSupportActionBar().setTitle("iMechatron");
                    break;
                case R.id.navigation_scholarships:
                    displayScholarshipFragment();
                    getSupportActionBar().setTitle("Scholarships");
                    break;
                case R.id.navigation_mycourses:
                    displayMyCoursesFragment();
                    getSupportActionBar().setTitle("My Courses");
                    break;

                case R.id.navigation_more:
                    displayMoreFragment();
                    getSupportActionBar().setTitle("More");
                    break;
            }

            return true;
        }
    };


    private void displayHomeFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (homeFragment.isAdded()) {
            ft.show(homeFragment);
        } else {
            ft.add(R.id.fragment_container, homeFragment, "Home");
        }
        if (scholarshipFragment.isAdded()) {
            ft.hide(scholarshipFragment);
        }
        if (moreFragment.isAdded()) {
            ft.hide(moreFragment);
        }
        if (mycoursesFragment.isAdded()) {
            ft.hide(mycoursesFragment);
        }
        ft.commit();
    }

    private void displayScholarshipFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (scholarshipFragment.isAdded()) {
            ft.show(scholarshipFragment);
        } else {
            ft.add(R.id.fragment_container, scholarshipFragment, "Scholarship");
        }
        if (mycoursesFragment.isAdded()) {
            ft.hide(mycoursesFragment);
        }
        if (moreFragment.isAdded()) {
            ft.hide(moreFragment);
        }
        if (homeFragment.isAdded()) {
            ft.hide(homeFragment);
        }

        ft.commit();
    }


    private void displayMyCoursesFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mycoursesFragment.isAdded()) {
            ft.show(mycoursesFragment);
        } else {
            ft.add(R.id.fragment_container, mycoursesFragment, "My Courses");
        }
        if (scholarshipFragment.isAdded()) {
            ft.hide(scholarshipFragment);
        }
        if (homeFragment.isAdded()) {
            ft.hide(homeFragment);
        }
        if (moreFragment.isAdded()) {
            ft.hide(moreFragment);
        }

        ft.commit();
    }


    private void displayMoreFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (moreFragment.isAdded()) {
            ft.show(moreFragment);
        } else {
            ft.add(R.id.fragment_container, moreFragment, "More");
        }
        if (scholarshipFragment.isAdded()) {
            ft.hide(scholarshipFragment);
        }
        if (mycoursesFragment.isAdded()) {
            ft.hide(mycoursesFragment);
        }
        if (homeFragment.isAdded()) {
            ft.hide(homeFragment);
        }

        ft.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            BottomNavigationView navView = findViewById(R.id.nav_view);
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            Menu menu = navView.getMenu();
            MenuItem menuItem = menu.getItem(0);
            menuItem.setChecked(true);
            menuItem.getTitle();


            if (savedInstanceState == null) {
                homeFragment = new HomeFragment();
                scholarshipFragment = new ScholarshipFragment();
                mycoursesFragment = new MyCoursesFragment();
                moreFragment = new MoreFragment();

            }

            displayHomeFragment();
            // Choose authentication providers
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());

// Create and launch sign-in intent
        if (currentUser==null) {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RQ_AUTH_UI);
        }else {
            Toast.makeText(this, "Welcome " + currentUser.getDisplayName(), Toast.LENGTH_SHORT).show();

        }

       /* FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()){
                    Log.w(TAG, "getInstanceId failed", task.getException());
                }
                //Get new Instance Id token
                String token = task.getResult().getToken();

                //Log and Toast
                String msg = getString(R.string.msg_token_fmt, token);
                Log.d(TAG, msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });*/
        }


    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RQ_AUTH_UI) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                currentUser = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this, "Welcome " + currentUser.getDisplayName(), Toast.LENGTH_SHORT).show();

                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }


    }

}

