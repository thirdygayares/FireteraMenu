package com.example.fireteramenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String JAVATABLE = "JAVATABLE";
    public static final String ID = "ID";
    public static final String TITLE = "TITLE";
    public static final String LINK = "LINK";

    public DatabaseHelper(@Nullable Context context) { super(context, "java.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String java = "CREATE TABLE " + JAVATABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " STRING,  " + LINK + " STRING)";
        db.execSQL(java);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + JAVATABLE);
        onCreate(db);
    }


    public boolean save(TutorialModel tutorialModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITLE, tutorialModel.getTitle());
        cv.put(LINK, tutorialModel.getLink());


        long insert = db.insert(JAVATABLE, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }


    public Cursor getTutorial(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor tutsData = db.rawQuery("SELECT * FROM " + JAVATABLE + " ORDER BY " + ID , null);
        return tutsData;
    }

}
