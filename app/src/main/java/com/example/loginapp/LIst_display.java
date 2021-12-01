package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class LIst_display extends AppCompatActivity {
    TextView listdata;
    ImageView listimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);
         listdata =findViewById(R.id.textdis);
         listimage= findViewById(R.id.imageicon);
        Intent intent=getIntent();
        String ReceiveName=intent.getStringExtra("name");
        int ReceiveImage= intent.getIntExtra("image",0);
        listdata.setText(ReceiveName);
        listimage.setImageResource(ReceiveImage);
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
          onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
}