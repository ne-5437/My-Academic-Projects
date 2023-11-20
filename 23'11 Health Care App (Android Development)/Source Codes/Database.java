package com.example.ayushmanbhava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  qry1="create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String username, String password) {
        int result = 0;
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"username"};
        String selection = "username=? and password=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            result = 1; // User exists
        }

        cursor.close();
        db.close();
        return result;
    }
    public void addCart(String username,String product,float price,String otype){
        ContentValues cv=new ContentValues();
        cv.put("useranme",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("otype",otype);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("cart",null,cv);
        db.close();

    }
    public int checkcart(String username,String product){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=product;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from cart where username=? and product=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        db.close();
        return  result;
    }
    public void removecart(String username,String otype)
    {
        String str[]=new String[2];
        str[0]=username;
        str[1]=otype;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();
    }
}
