package com.example.imechatron;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GetStudyMaterialsActivity extends AppCompatActivity {
    private Button btPq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.past_questions);

        btPq = findViewById(R.id.bt_pq);

        btPq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
                String url = "https://chat.whatsapp.com/GthAx9VgNFjAQcTOPoMXf5";
                intentWhatsapp.setData(Uri.parse(url));
                intentWhatsapp.setPackage("com.whatsapp");
                startActivity(intentWhatsapp);
            }
        });
    }
}
