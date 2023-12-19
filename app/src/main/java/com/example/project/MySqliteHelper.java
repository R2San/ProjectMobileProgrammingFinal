package com.example.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteHelper extends SQLiteOpenHelper {

    static int version =1;

    public MySqliteHelper(Context context) {
        super(context, "mysqlitedb", null, version);
    }

    public static String TABLE_MS_USER = "msUser";
    public static String FIELD_MS_USER_USERNAME = "username";
    public static String FIELD_MS_USER_PASSWORD = "password";

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String qCreate="CREATE TABLE IF NOT EXISTS 'msUser' ('username' TEXT,'password' TEXT)";
        String qCreate="CREATE TABLE IF NOT EXISTS '"+TABLE_MS_USER+"' ('"
                + FIELD_MS_USER_USERNAME +"' TEXT, '"
                +FIELD_MS_USER_PASSWORD+"' TEXT)";
        db.execSQL(qCreate);

        String qInsert="INSERT INTO 'msUser' ('username', 'password') VALUES ('qqq', 'qqq');";
        db.execSQL(qInsert);

        String qInsert2="INSERT INTO 'msUser' ('username', 'password') VALUES ('www', 'www');";
        db.execSQL(qInsert2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
