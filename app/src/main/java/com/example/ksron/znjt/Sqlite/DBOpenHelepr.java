package com.example.ksron.znjt.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelepr extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE = "user.db";
    public DBOpenHelepr( Context context) {
        super(context,DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists u_user(_id integer primary key autoincrement,yu_e varchar(20),chehao integer,chongzhijin_e varchar(5),caozuoren varchar(10),time varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
