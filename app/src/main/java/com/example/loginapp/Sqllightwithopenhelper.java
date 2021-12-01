package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sqllightwithopenhelper extends AppCompatActivity implements View.OnClickListener {
    EditText course,duration,tracks,discription;
    Button addcourse,readallcourse;
    DB_Handler db_handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqllightwithopenhelper);
        course= findViewById(R.id.idEdtCourseName);
        duration=findViewById(R.id.idEdtCourseDuration);
        tracks= findViewById(R.id.idEdtCourseTracks);
        discription= findViewById(R.id.idEdtCourseDescription);
        addcourse= findViewById(R.id.idBtnAddCourse);
        readallcourse= findViewById(R.id.idBtnReadCourse);
        db_handler= new DB_Handler(Sqllightwithopenhelper.this);
        addcourse.setOnClickListener(this);
        readallcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sqllightwithopenhelper.this,Viewcourse.class);
                startActivity(i);


            }
        });
    }


    @Override
    public void onClick(View view) {
        String corsename=course.getText().toString();
        String courseduration= duration.getText().toString();
        String coursetrack= tracks.getText().toString();
        String Coursediscription=discription.getText().toString();
        // validationcourseModalArrayList
        if(corsename.isEmpty()&&courseduration.isEmpty()&&coursetrack.isEmpty()&&Coursediscription.isEmpty()){
            Toast.makeText(getApplicationContext(), "please complete the all field", Toast.LENGTH_SHORT).show();
        }
        db_handler.addcourse(corsename,courseduration,coursetrack,Coursediscription);
        Toast.makeText(getApplicationContext(), "Course added successfully", Toast.LENGTH_SHORT).show();
        course.getText().clear();
         duration.getText().clear();
        tracks.getText().clear();
        discription.getText().clear();
        // validation



    }
}