package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Viewcourse extends AppCompatActivity {
 private ArrayList<CourseModal> coursemodels;
 private DB_Handler db_handler;
private  RecyclerView recycler;
private  CourseAdaptersql adaptersql;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcourse);
         recycler= findViewById(R.id.recyclerView1);
        coursemodels= new ArrayList<>();
        db_handler= new DB_Handler(Viewcourse.this);
        coursemodels= db_handler.readCourses();
         adaptersql= new CourseAdaptersql(coursemodels,Viewcourse.this);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(Viewcourse.this,RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adaptersql);

    }
}