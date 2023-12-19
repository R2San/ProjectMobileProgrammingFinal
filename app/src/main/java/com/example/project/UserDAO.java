package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class UserDAO {
    //dao = data access object

    public ArrayList<User> getUsers(Context mCtx){
        ArrayList<User> results = new ArrayList<>();

        MySqliteHelper helper = new MySqliteHelper(mCtx);
        SQLiteDatabase db = helper.getReadableDatabase();

        String selectionString = null;
        String[] selectionArgs = null;

        Cursor resultCursor = db.query(
                helper.TABLE_MS_USER, null,
                selectionString, selectionArgs,
                null, null, null);

        while(resultCursor.moveToNext()){
            User tempUser = new User();
            tempUser.username = resultCursor.getString(0);
            tempUser.password = resultCursor.getString(1);
            results.add(tempUser);
        }

        return  results;
    }

    public void insertUser(Context mCtx, User user){
        MySqliteHelper helper = new MySqliteHelper(mCtx);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(helper.FIELD_MS_USER_USERNAME, user.username);
        cv.put(helper.FIELD_MS_USER_PASSWORD, user.password);
        db.insertWithOnConflict(helper.TABLE_MS_USER, null,
                cv, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
}
