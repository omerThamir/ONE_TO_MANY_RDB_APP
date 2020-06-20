package com.omar.myapps.onetomanyrdbapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teachers(\n" +
                "                    id INTEGER PRIMARY KEY,\n" +
                "                    name TEXT );");

        db.execSQL("create table courses(\n" +
                "                    c_id INTEGER PRIMARY KEY,\n" +
                "                    name TEXT,\n" +
                "                    teacher_id INTEGER, FOREIGN KEY (teacher_id) REFERENCES teachers(id) on delete cascade);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists teachers;");
        db.execSQL("drop table if exists courses;");
        onCreate(db);
    }
}
