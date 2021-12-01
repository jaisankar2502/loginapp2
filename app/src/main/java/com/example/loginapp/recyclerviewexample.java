package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class recyclerviewexample extends AppCompatActivity {
    ArrayList<String> personName= new ArrayList<>(Arrays.asList("Jaisankar","Uvais","Arun","Mrudhul","Shibin","Sujin"));
    ArrayList<Integer>image=new ArrayList<>(Arrays.asList(R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewexample);
        RecyclerView recyclerView= findViewById(R.id.recyclerviewid);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CycleAdapter  adapter= new CycleAdapter(recyclerviewexample.this,personName,image);
        recyclerView.setAdapter(adapter);

    }
}