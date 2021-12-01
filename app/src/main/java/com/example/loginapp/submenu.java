package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class submenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.submenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action:
                Toast.makeText(getApplicationContext(), "action is selected", Toast.LENGTH_SHORT).show();
            return true;
            case R.id.search:
                Toast.makeText(getApplicationContext(), "search is selected", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.copy:
                Toast.makeText(getApplicationContext(), "copy  is selected", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.paste:
                Toast.makeText(getApplicationContext(), "paste is selected", Toast.LENGTH_SHORT).show();
                return  true;
            default:
            return super.onOptionsItemSelected(item);
        }

    }
}