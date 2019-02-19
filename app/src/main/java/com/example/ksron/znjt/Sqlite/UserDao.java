package com.example.ksron.znjt.Sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDao {

    private DBOpenHelepr helepr;
    public UserDao(Context context){
        helepr = new DBOpenHelepr(context);
    }

    public void add(UserSqlite user){
        SQLiteDatabase db = helepr.getWritableDatabase();
        String sql = "Insert into u_user(_id,yu_e,chehao,chongzhijin_e,caozuoren,time) values(null,?,?,?,?,?)";
        db.execSQL(sql,new Object[]
                {
                        user.getYu_e(),user.getChehao(),user.getChongzhijin_e(),user.getCaozuoren(),user.getTime()
                }
        );
        db.close();
    }

    public Cursor shijianshengxu(){
        SQLiteDatabase db = helepr.getReadableDatabase();
        Cursor cursor = db.query("u_user",null,null,null,null,null,"time asc");
        return cursor;
    }
    public Cursor shijiangjiangxu(){
        SQLiteDatabase db = helepr.getReadableDatabase();
        Cursor cursor = db.query("u_user",null,null,null,null,null,"time desc");
        return cursor;
    }
    public Cursor yu_eshengxu(){
        SQLiteDatabase db = helepr.getReadableDatabase();
        Cursor cursor = db.query("u_user",null,null,null,null,null,"yu_e asc");
        return cursor;
    }
    public Cursor yu_ejiangxu(){
        SQLiteDatabase db = helepr.getReadableDatabase();
        Cursor cursor = db.query("u_user",null,null,null,null,null,"yu_e desc");
        return cursor;
    }
}
