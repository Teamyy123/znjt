package com.example.ksron.znjt;

        import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import java.util.HashMap;

public class F4_Main extends AppCompatActivity implements  View.OnClickListener{
    ImageView imageView_a1,imageView_a2,imageView_a3,imageView_a4,imageView_a5;
        ImageView    imageView_b1,imageView_b2,imageView_b3,imageView_b4;
        String data1,uri12;
        Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f4_main);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.hide();
        }

        TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        LayoutInflater inflater=LayoutInflater.from(this);
        inflater.inflate(R.layout.f4_a1,tabHost.getTabContentView());
        inflater.inflate(R.layout.f4_b1,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("f4_bofan").setIndicator("违章视频").setContent(R.id.f4_a1));
        tabHost.addTab(tabHost.newTabSpec("f4_tupian").setIndicator("违章图片").setContent(R.id.f4_b1));

        imageView_a1=(ImageView)findViewById(R.id.inmage_a1);
        imageView_a2=(ImageView)findViewById(R.id.inmage_a2);
        imageView_a3=(ImageView)findViewById(R.id.inmage_a3);
        imageView_a4=(ImageView)findViewById(R.id.inmage_a4);
        imageView_a5=(ImageView)findViewById(R.id.inmage_a5);

        imageView_a1.setOnClickListener(this);
        imageView_a2.setOnClickListener(this);
        imageView_a3.setOnClickListener(this);
        imageView_a4.setOnClickListener(this);
        imageView_a5.setOnClickListener(this);


        /**
         * 图片
         */
        imageView_b1=(ImageView)findViewById(R.id.inmage_b1);
        imageView_b2=(ImageView)findViewById(R.id.inmage_b2);
        imageView_b3=(ImageView)findViewById(R.id.inmage_b3);
        imageView_b4=(ImageView)findViewById(R.id.inmage_b4);

        for (int i=1;i<=5;i++)
        {

            switch (i)
            {
                case 1:
                    uri12 = "http://39.108.121.6/pengjianye/ship_a1.mp4";
                    Bitmap  bitmap1=tupain1(uri12,100,100);//调用createdViewoThumbnail方法
                    imageView_a1.setImageBitmap(bitmap1);//设置Imagview
                    break;
                case 2:
                    uri12 = "http://39.108.121.6/pengjianye/ship_a1.mp4";
                    Bitmap  bitmap2=tupain1(uri12,100,100);
                    imageView_a2.setImageBitmap(bitmap2);
                    break;
                case 3:
                    uri12 = "http://39.108.121.6/pengjianye/ship_a2.mp4";
                    Bitmap  bitmap3=tupain1(uri12,100,100);
                   imageView_a3.setImageBitmap(bitmap3);
                    break;
                case 4:
                    uri12 = "http://39.108.121.6/pengjianye/ship_a3.mp4";
                    Bitmap  bitmap4=tupain1(uri12,100,100);
                 imageView_a4.setImageBitmap(bitmap4);
                    break;
                case 5:
                    uri12 = "http://39.108.121.6/pengjianye/ship_a4.mp4";
                    Bitmap  bitmap5=tupain1(uri12,100,100);
                 imageView_a5.setImageBitmap(bitmap5);
                    break;
            }
        }

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.inmage_a1:
            Intent intent1=new Intent(F4_Main.this,F4_main2.class);
            intent1.putExtra("a1",1);
            startActivity(intent1);
            break;
            case R.id.inmage_a2:
                Intent intent2=new Intent(F4_Main.this,F4_main2.class);
                intent2.putExtra("a1",2);
                startActivity(intent2);break;
            case R.id.inmage_a3:
                Intent intent3=new Intent(F4_Main.this,F4_main2.class);
                intent3.putExtra("a1",3);
                startActivity(intent3);break;
            case R.id.inmage_a4:
                Intent intent4=new Intent(F4_Main.this,F4_main2.class);
                intent4.putExtra("a1",4);
                startActivity(intent4);break;
            case R.id.inmage_a5:
                Intent intent5=new Intent(F4_Main.this,F4_main2.class);
                intent5.putExtra("a1",5);
                startActivity(intent5);break;
        }




    }

    private Bitmap tupain1(String data1, int i, int i1)
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 14)
            {
                retriever.setDataSource(data1, new HashMap<String, String>());
            } else
            {
                retriever.setDataSource(data1);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException ex)
        {

        } catch (RuntimeException ex) {

        } finally
        {

            try
            {
                retriever.release();
            } catch (RuntimeException ex)
            {

            }
        }

        return bitmap;

    }



}
