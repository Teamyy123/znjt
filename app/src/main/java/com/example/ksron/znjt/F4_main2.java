package com.example.ksron.znjt;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class F4_main2 extends AppCompatActivity {
    String url;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f4_main2);
        ActionBar A = getSupportActionBar();
        if (A != null)
        {
            A.hide();
        }
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        int data = intent.getIntExtra("a1", 1);

        switch (data)
        {
            case 1:
                url ="http://39.108.121.6/pengjianye/ship_a1.mp4";
                break;
            case 2:
                url = "http://39.108.121.6/pengjianye/ship_a2.mp4";
                break;
            case 3:
                url = "http://39.108.121.6/pengjianye/ship_a3.mp4";
                break;
            case 4:
                url = "http://39.108.121.6/pengjianye/ship_a4.mp4";
                break;
            case 5:
                url = "http://39.108.121.6/pengjianye/ship_a5.mp4";
                break;

        }
        try {
            bofan();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    private void bofan() throws IOException
    {
//        Uri uri=Uri.parse(url);
//        video=(VideoView)findViewById(R.id.vide123);
//        video.setOnCompletionListener(new may());
//        video.setVideoURI(uri);
//        video.setMediaController(new MediaController(this));
//        video.requestFocus();
//        video.start();

        video=(VideoView) findViewById(R.id.vide123);
        Uri uri=Uri.parse(url);
        video.setMediaController(new MediaController(this));
        video.setOnCompletionListener(new mymede());
        video.setVideoURI(uri);
        video.requestFocus();
        video.start();

    }





    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {
            video.stopPlayback();
            }

        return super.onKeyDown(keyCode, event);
    }

    private class mymede  implements MediaPlayer.OnCompletionListener
    {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            Toast.makeText(F4_main2.this,"播放完成",Toast.LENGTH_SHORT).show();
        }
    }

}
