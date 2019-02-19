package com.example.ksron.znjt;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ksron.znjt.Sqlite.UserDao;

public class Thrid extends AppCompatActivity {

    Spinner spinner3;
    ListView listView;
    private String name3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thrid);
        TextView textView = (TextView)findViewById(R.id.biaoti);
        textView.setText("账单管理");
        listView = (ListView)findViewById(R.id.id_list3);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arrdd = getResources().getStringArray(R.array.spinner3);
                name3 = arrdd[position];
            }

            @Override
              public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void chaxun3(View view) {
        UserDao userDao = new UserDao(this);
        if(name3.equals("时间升序")){
            Cursor cursor = userDao.shijianshengxu();
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this,
                    R.layout.tab3,
                    cursor,
                    new String[]{"_id","chehao","yu_e","chongzhijin_e","caozuoren","time"},
                    new int[]{R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6}
            );
            listView.setAdapter(adapter);
        }else if(name3.equals("时间降序")){
            Cursor cursor = userDao.shijiangjiangxu();
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this,
                    R.layout.tab3,
                    cursor,
                    new String[]{"_id","chehao","yu_e","chongzhijin_e","caozuoren","time"},
                    new int[]{R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6}
            );
            listView.setAdapter(adapter);
        }else if(name3.equals("余额升序")){
            Cursor cursor = userDao.yu_eshengxu();
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this,
                    R.layout.tab3,
                    cursor,
                    new String[]{"_id","chehao","yu_e","chongzhijin_e","caozuoren","time"},
                    new int[]{R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6}
            );
            listView.setAdapter(adapter);
        }else if (name3.equals("余额降序")){
            Cursor cursor = userDao.yu_ejiangxu();
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this,
                    R.layout.tab3,
                    cursor,
                    new String[]{"_id","chehao","yu_e","chongzhijin_e","caozuoren","time"},
                    new int[]{R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6}
            );
            listView.setAdapter(adapter);
        }
    }
}
