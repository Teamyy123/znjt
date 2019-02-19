package com.example.ksron.znjt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    private static final short SPLASH_DELAY_MILLD =(1000*3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Welcome.this,Login.class));
                finish();
            }
        },SPLASH_DELAY_MILLD);
    }
}
