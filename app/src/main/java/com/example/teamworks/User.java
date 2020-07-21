package com.example.teamworks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class User extends SQLiteOpenHelper {

    public User(Context context)
    {
        super(context,"users",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(emailid text, name text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addUser(String emailid,String name,String password)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("emailid",emailid);
        cv.put("name",name);
        cv.put("password",password);
        db.insert("users",null,cv);
        return true;
    }
    public Cursor viewUsers()
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.query("users",null,null,null,null,null,null);
        return c;
    }
}
