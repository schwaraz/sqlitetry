package com.example.sqlitetry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_Name = "MyDB";
    private static final String TB_Name = "Users";
    private static final String Key_Id = "id";
    private static final String Key_Nama = "nama";
    private static final String Key_Paswword = "password";


    public DBHandler(Context C) {
        super(C, DB_Name,null, DB_VERSION);
        Log.d("tes","contect");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("tes","tabel");

        String query ="CREATE TABLE " +TB_Name+"("+Key_Id+" INTEGER PRIMARY KEY, "+Key_Nama+" TEXT,"+Key_Paswword+" TEXT"+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_Name);
    }
//    public boolean insertUser(String nama,String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("nama",nama);
//        cv.put("password",password);
//        db.insert(TB_Name,null,cv);
//        return true;
//    } untuk versi bawah
    public boolean insertUser(DataModel user){
        Log.d("tes","inseruser");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Key_Nama,user.getNama());
        cv.put(Key_Paswword,user.getPassword());
        db.insert(TB_Name,null,cv);
        db.close();
        return true;
    }


    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery( "SELECT * FROM "+TB_Name+" WHERE id="+id,null);
        return result;
    }
    public int getdatacount(){
        String query = "SELECT * FROM "+TB_Name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        return c.getCount();
    }
    public List<DataModel> getAll(){
        List<DataModel> userList = new ArrayList<DataModel>();
        String query = "SELECT * FROM "+TB_Name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        if (c.moveToFirst()){
            do{
                DataModel u = new DataModel();
                u.setId(Integer.parseInt(c.getString(0)));
                u.setNama(c.getString(1));
                u.setPassword(c.getString(2));
                userList.add(u);
            } while (c.moveToNext());
        }    return userList;

    }
}
