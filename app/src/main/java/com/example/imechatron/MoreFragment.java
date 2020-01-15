package com.example.imechatron;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MoreFragment extends Fragment implements View.OnClickListener {
    public FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private final int RQ_AUTH_UI = 100;
    private Button btMore, btMore1, btMore2, btMore3, btMore4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        btMore = view.findViewById(R.id.bt_more);
        btMore1 = view.findViewById(R.id.bt1_more);
        btMore2 = view.findViewById(R.id.bt2_more);
        btMore3 = view.findViewById(R.id.bt3_more);
        btMore4 = view.findViewById(R.id.bt4_more);


        btMore.setOnClickListener(this);
        btMore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), GpCalculateActivity.class);
                startActivity(i);
            }
        });

        btMore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutNamesActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }

    @Override
    public void onClick(View view) {
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            AuthUI.getInstance().signOut(getActivity())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            currentUser = null;
                            Toast.makeText(getActivity(), "You Have Signed Out", Toast.LENGTH_SHORT).show();
                            List<AuthUI.IdpConfig> providers = Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.GoogleBuilder().build());
                            startActivityForResult(
                                    AuthUI.getInstance()
                                            .createSignInIntentBuilder()
                                            .setAvailableProviders(providers)
                                            .build(),
                                    RQ_AUTH_UI);

                        }
                    });

            getActivity().finish();

        }

    }
}


/*    @Override
    public void onClick(View view) {
    }
}*/


/*public void signOut () {
            if (currentUser != null) {
                AuthUI.getInstance().signOut(getActivity())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                currentUser = null;
                                Toast.makeText(getActivity(), "You Have Signed Out", Toast.LENGTH_SHORT).show();
                                List<AuthUI.IdpConfig> providers = Arrays.asList(
                                        new AuthUI.IdpConfig.EmailBuilder().build(),
                                        new AuthUI.IdpConfig.GoogleBuilder().build());
                                startActivityForResult(
                                        AuthUI.getInstance()
                                                .createSignInIntentBuilder()
                                                .setAvailableProviders(providers)
                                                .build(),
                                        RQ_AUTH_UI);

                            }
                        });

                getActivity().finish();

            }

        }*/


