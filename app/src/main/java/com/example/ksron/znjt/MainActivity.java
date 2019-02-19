package com.example.ksron.znjt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.biaoti);
        textView.setText("主界面");
    }

    public void t1(View view) {
        startActivity(new Intent(MainActivity.this,Frist.class));
    }
    public void t2(View view) {
        startActivity(new Intent(MainActivity.this,Scond.class));
    }
    public void t3(View view) {
        startActivity(new Intent(MainActivity.this,Thrid.class));
    }
    public void t4(View view) {
        startActivity(new Intent(MainActivity.this,F4_Main.class));
    }
    public void t5(View view) {
    }
    public void t6(View view) {
    }
    public void t7(View view) {
    }
}
