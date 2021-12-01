package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SqlLightWithoutOpenHelper extends AppCompatActivity {
     EditText des,con,area,city;
     AutoCompleteTextView name;
     Button add,delete,update,reset,show;
    SQLiteDatabase db;
    private static final String DB_NAME = "myDB.db";
    private static final String TABLE_NAME = "emp_details";
    List<String> item = new ArrayList<>();
    ArrayAdapter<String> adapter;
    // String s;
    Cursor cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sql_light_without_open_helper);
        name = (AutoCompleteTextView) findViewById(R.id.edit1);
        des = (EditText) findViewById(R.id.edit2);
        con = (EditText) findViewById(R.id.edit3);
        area = (EditText) findViewById(R.id.edit4);
        city = (EditText) findViewById(R.id.edit5);
        add = (Button) findViewById(R.id.button1);
        show = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);
        reset = (Button) findViewById(R.id.button5);
        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, " +
                "DESIGNATION TEXT, CONTACT NUMBER, AREA TEXT, CITY TEXT);");

        db.close();
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.clear();
                db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
                cur = db.rawQuery("SELECT NAME FROM " + TABLE_NAME, null);
                cur.moveToFirst();

                while (!cur.isAfterLast()) {
                    String logic = name.getText().toString();
                    item.add(logic);
                    cur.moveToNext();
                }

                adapter = new ArrayAdapter<>(getBaseContext(),
                        android.R.layout.simple_list_item_1, item);
                name.setThreshold(1);// Suggestion for one letter use Threshold
                name.setAdapter(adapter);
                db.close();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.getText().clear();
                des.getText().clear();
                con.getText().clear();
                area.getText().clear();
                city.getText().clear();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db= openOrCreateDatabase(DB_NAME,Context.MODE_PRIVATE,null);
                db.execSQL("INSERT INTO " + TABLE_NAME +  "(NAME, DESIGNATION, CONTACT, AREA, CITY) "+
                        "VALUES('" + name.getText().toString() +"','" + des.getText().toString() +"', '" + con.getText().toString() +"', '" + area.getText().toString() +"','" + city.getText().toString() +"')");
                db.close();
                name.getText().clear();
                des.getText().clear();
                con.getText().clear();
                area.getText().clear();
                city.getText().clear();
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db= openOrCreateDatabase(DB_NAME,Context.MODE_PRIVATE,null);
                db.execSQL("UPDATE " + TABLE_NAME + " SET DESIGNATION= '"+ des.getText().toString()+"' WHERE NAME='" + name.getText().toString()+"'");
                db.close();
                name.getText().clear();
                des.getText().clear();
            }

        });
show.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String employeename= name.getText().toString();
        Intent i = new Intent(SqlLightWithoutOpenHelper.this,SqliteView.class);
        i.putExtra("hello",employeename);
        startActivity(i);
        name.getText().clear();

    }
});

    }

}