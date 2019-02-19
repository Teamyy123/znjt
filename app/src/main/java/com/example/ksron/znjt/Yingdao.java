package com.example.ksron.znjt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Yingdao extends AppCompatActivity {
private  boolean re=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yingdao);
        SharedPreferences sharedPreferences= getSharedPreferences("re",this.MODE_PRIVATE);
        re=sharedPreferences.getBoolean("re",re);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if (re){
            startActivity(new Intent(Yingdao.this,Welcome.class));
        }else {
            startActivity(new Intent(Yingdao.this,Login.class));
        }finish();
      editor.putBoolean("re",false);
      editor.commit();
    }
}
