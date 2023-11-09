package com.janhvi.health_hive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "create table users(username text, uemail text, Password text)";
        db.execSQL(query1);

        String query2 = "create table cart(username text, Product text, price float, otype text)";
        db.execSQL(query2);

        String query3 = "create table orderplace(username text, fullname text, address text, contactno text, pincode int, date text, time text, amount float, oType text) ";
        db.execSQL(query3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

        public void register(String username, String Password, String uemail){
            ContentValues cv = new ContentValues();
            cv.put("username", username);
            cv.put("email", uemail);
            cv.put("password", Password);
            SQLiteDatabase db = getWritableDatabase();
            db.insert("users", null, cv);
            db.close();
        }

        public int login (String username, String Password){
            int result = 0;
            String str[] = new String[2];
            str[0] = username;
            str[1] = Password;
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery("select * from users where username = ? and password =?", str);

            if (c.moveToFirst()) {
                result = 1;
            }
            db.close();

            return result;
        }

        public void addCart (String Username, String product,float price, String otype){
            ContentValues cv = new ContentValues();
            cv.put("username", Username);
            cv.put("product", product);
            cv.put("price", price);
            cv.put("otype", otype);
            SQLiteDatabase db = getWritableDatabase();
            db.insert("cart", null, cv);
            db.close();
        }


        public int checkCart (String username, String Product){
            int result = 0;
            String str[] = new String[2];
            str[0] = username;
            str[1] = Product;
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery("select * from users where username = ? and Product =?", str);

            if (c.moveToFirst()) {
                result = 1;
            }

            db.close();

            return result;
        }

        public void removeCart (String username, String oType){
            String str[] = new String[2];
            str[0] = username;
            str[1] = oType;
            SQLiteDatabase db = getWritableDatabase();
            db.delete("cart", "username=? and oType=?", str);
            db.close();
        }

        public ArrayList getCartData (String username, String oType){
            ArrayList<String> arrayList = new ArrayList<>();
            SQLiteDatabase db = getReadableDatabase();

            String str[] = new String[2];
            str[0] = username;
            str[1] = oType;
            Cursor c = db.rawQuery("select * from cart where username = ? and oType =?", str);
            if (c.moveToFirst()) {
                do {
                    String Product = c.getString(1);
                    String price = c.getString(2);
                    arrayList.add(Product + "$" + price);
                } while (c.moveToNext());
            }

            db.close();
            return arrayList;

        }
        public void addOrder (String username, String fullname, String address, String oType, String
        contact, String date, String time,int pincode, float price){
            ContentValues cv = new ContentValues();
            cv.put("username", username);
            cv.put("fullname", fullname);
            cv.put("address", address);
            cv.put("Otype", oType);
            cv.put("contact", contact);
            cv.put("date", date);
            cv.put("time", time);
            cv.put("pincode", pincode);
            cv.put("price", price);

            SQLiteDatabase db = getWritableDatabase();
            db.insert("orderplace", null, cv);
            db.close();

        }
}

