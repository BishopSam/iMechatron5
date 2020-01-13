package com.example.imechatron;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.imechsplash);

        int secsdelayed = 1;

        ImageView imView= findViewById(R.id.imechatronsplash);
        imView.setImageResource(0);

        Drawable draw = getResources().getDrawable(R.drawable.imechatron);
        imView.setImageDrawable(draw);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, secsdelayed *2000);
    }
}
