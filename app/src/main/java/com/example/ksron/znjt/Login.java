package com.example.ksron.znjt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
private EditText editText;
private EditText editText1;
private Button button;
private CheckBox checkbox;
public SharedPreferences sp;
Boolean chek;
Boolean che1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_login);
        editText=findViewById(R.id.edit);
        editText1=findViewById(R.id.edit1);
        button=findViewById(R.id.button);
        checkbox=findViewById(R.id.checkbox);
        /**
         * 取出
         */
        sp=this.getSharedPreferences("sql",this.MODE_PRIVATE);
        Boolean qw=sp.getBoolean("chek",false);
        String qq = sp.getString("qq","");
        String pas = sp.getString("pas","");

        if (qw){
            editText.setText(qq);
            editText1.setText(pas);
        }else {
            editText.setText("");
            editText1.setText("");
        }


    }

    public void login(View view) {
        String qq = editText.getText().toString().trim();
        String pass = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(qq)||TextUtils.isEmpty(pass)){
            Toast.makeText(this, "账号跟密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            if ("admin".equals(qq)&&"admin".equals(pass))
            {
                Boolean zhengque=true;
                SharedPreferences.Editor editor1=sp.edit();//编辑
                editor1.putBoolean("zhengque",zhengque);
                editor1.apply();
                /**
                 * 密码被选中就存一个ture 否则就存一个falase
                 */
                if (checkbox.isChecked())
                {
                    //被选中状态，需要记录用户名和密码  将数据保存到sp文件中
                    Boolean  chek=true;
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("qq",qq);
                    editor.putBoolean("chek",chek);
                    editor.putString("pass",pass);
                    editor.apply();
                }else
                {
                    che1=false;
                    SharedPreferences.Editor editor2=sp.edit();//编辑
                    editor2.putBoolean("chek",che1);
                    editor2.apply();
                }
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
