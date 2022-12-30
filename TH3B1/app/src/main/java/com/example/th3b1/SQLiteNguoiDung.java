package com.example.th3b1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteNguoiDung extends SQLiteOpenHelper {

    public SQLiteNguoiDung(@Nullable Context context) {
        super(context, "tb_nguoidung.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE tb_nguoidung (" +
                "hoten text PRIMARY KEY," +
                "email text, " +
                "sdt text);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(NguoiDung nd){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("hoten", nd.getHoten());
        cv.put("email", nd.getEmail());
        cv.put("sdt", nd.getSdt());

        long kq = db.insert("tb_nguoidung", null, cv);
        if(kq < 1)
            return false;
        return true;
    }

    public ArrayList<NguoiDung> getAll(){

        ArrayList<NguoiDung> listview = new ArrayList<>();
        String query = "SELECT * FROM tb_nguoidung";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery(query, null);
        if(cr.moveToFirst()){
            do{
                String hoten = cr.getString(0);
                String email = cr.getString(1);
                String sdt = cr.getString(2);
                NguoiDung item = new NguoiDung();
                item.setHoten(hoten);
                item.setEmail(email);
                item.setSdt(sdt);
                listview.add(item);
            } while(cr.moveToLast());
        }
        return listview;
    }

}
