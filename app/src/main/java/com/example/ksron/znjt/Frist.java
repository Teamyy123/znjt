package com.example.ksron.znjt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ksron.znjt.Sqlite.UserDao;
import com.example.ksron.znjt.Sqlite.UserSqlite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Frist extends AppCompatActivity {

    private TextView yu_e;
    private EditText chongzhijin_e;
    private Spinner spinner;
    private String name;
    private int num1 = 55;
    private int num2 =0;
    private int num3 = 0;
    private int key = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist);

        yu_e = (TextView)findViewById(R.id.textView3);
        chongzhijin_e = (EditText)findViewById(R.id.editText);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arr = getResources().getStringArray(R.array.spinner);
                name = arr[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        yu_e.setText(num1+"元");
    }

    public void chongzhi(View view) {
        if (TextUtils.isEmpty(chongzhijin_e.getText().toString())){
            Toast.makeText(this, "输入金额", Toast.LENGTH_SHORT).show();
            chongzhijin_e.setText("");
        }else {
            try{
                int money = Integer.valueOf(chongzhijin_e.getText().toString());
                if(money>=0&&money<=999){
                    if(name.equals("1")){
                        num1 = num1+money;
                        yu_e.setText(num1+"元");
                        chongzhijin_e.setText("");
                    }else if (name.equals("2")){
                        num2 = num2+money;
                        yu_e.setText(num2+"元");
                        chongzhijin_e.setText("");
                    }else if(name.equals("3")){
                        num3 = num3+money;
                        yu_e.setText(num3+"元");
                        chongzhijin_e.setText("");
                    }
                    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");    //设置日期格式
                    TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
                    TimeZone.setDefault(tz);

                    UserDao userDao = new UserDao(this);
                    UserSqlite user = new UserSqlite(
                            key,
                            yu_e.getText().toString(),
                            Integer.valueOf(name),
                            chongzhijin_e.getText().toString(),
                            "admin",
                            df.format(new Date())
                    );
                    Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "充值成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "输入金额", Toast.LENGTH_SHORT).show();
                    chongzhijin_e.setText("");
                }
            }catch (Exception e){
                Toast.makeText(this, "输入金额", Toast.LENGTH_SHORT).show();
                chongzhijin_e.setText("");
            }
        }
    }

    public void chaxun(View view) {
        if(name.equals("1")){
            yu_e.setText(num1+"元");
        }else if (name.equals("2")){
            yu_e.setText(num2+"元");
        }else if(name.equals("3")){
            yu_e.setText(num3+"元");
        }
        Toast.makeText(this, "成功查询", Toast.LENGTH_SHORT).show();
    }
}
