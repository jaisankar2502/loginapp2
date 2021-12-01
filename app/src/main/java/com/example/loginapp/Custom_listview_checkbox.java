package com.example.loginapp;

import static android.widget.AdapterView.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

public class Custom_listview_checkbox extends AppCompatActivity {
    String name[] = {"Ernakulam", "Kottayam", "Idukki", "TVM", "Kollam", "Pathanamthitta"};
    int icons[] = {R.drawable.img1, R.drawable.img2, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img4, R.drawable.img1, R.drawable.img2, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img4};
    ListView list;

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview_checkbox);
        list = findViewById(R.id.list_view);
        LIstAdapter adapter = new LIstAdapter(getApplicationContext(), icons, name);
        list.setAdapter(adapter);
        list.setClickable(true);

//        list.setOnItemClickListener( new  AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(Custom_listview_checkbox.this, LIst_display.class);
//                intent.putExtra("name", name[i]);
//                intent.putExtra("image", icons[i]);
//                startActivity(intent);
//            }
//        });


    }
}
