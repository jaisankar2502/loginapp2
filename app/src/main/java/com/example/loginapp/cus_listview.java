package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class cus_listview extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    String districts[] = {"Ernakulam","Kottayam","Idukki","TVM","Kollam","Pathanamthitta","Ernakulam","Kottayam","Idukki","TVM","Kollam","Pathanamthitta"};
    int icons[] = {R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4,R.drawable.img1,R.drawable.img2,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img4};
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_listview);
        listview= findViewById(R.id.list1);
        listview.setOnItemClickListener(this);
        CustomAdapter adapter= new CustomAdapter(getApplicationContext(),icons,districts);
        listview.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),districts[i],Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),districts[i],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onCheckboxClicked(View view) {
    }
}