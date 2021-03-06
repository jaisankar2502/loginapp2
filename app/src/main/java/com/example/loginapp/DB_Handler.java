package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DB_Handler extends SQLiteOpenHelper {
    // creating database
    private static final String DB_NAME = "coursedb";
    // below int is our database version
    private static final int DB_VERSION = 1;
    //creating a table
    private  static  final String TABLE_NAME="mycourses";
    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String DURATION_COL = "duration";

    // below variable for our course description column.
    private static final String DESCRIPTION_COL = "description";

    // below variable is for our course tracks column.
    private static final String TRACKS_COL = "tracks";



    DB_Handler(Context applicationcontext){
        super(applicationcontext,DB_NAME,null,DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // we are creating the table in it
        String query= "CREATE TABLE "+ TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL+"TEXT, "
                + DURATION_COL+"TEXT,"
                + DESCRIPTION_COL+"TEXT,"
                + TRACKS_COL+"TEXT)";
        // call the execSql method
        db.execSQL(query);

    }
    public  void addcourse(String corsename,String courseduration, String coursetrack, String Coursediscription){
        // our sqlite database and calling writable method
        // as we are writing data in our database.
         SQLiteDatabase db=  this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values= new ContentValues();
        values.put(NAME_COL,corsename);
        values.put(DURATION_COL,courseduration);
        values.put(DESCRIPTION_COL,Coursediscription);
        values.put(TRACKS_COL,coursetrack);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public ArrayList<CourseModal> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(
                        cursorCourses.getString(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
