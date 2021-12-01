package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Custom_spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String districts[] = {"Ernakulam","Kottayam","Idukki","TVM","Kollam","Pathanamthitta"};
    int icons[] = {R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);
        spinner= findViewById(R.id.spinner_1);
      spinner.setOnItemSelectedListener(this);

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),icons,districts);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),districts[i],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}