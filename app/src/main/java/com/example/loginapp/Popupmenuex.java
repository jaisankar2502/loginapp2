package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Popupmenuex extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupmenu);
        Button btn= (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop= new PopupMenu(Popupmenuex.this,view);
                pop.setOnMenuItemClickListener(Popupmenuex.this);
                    pop.inflate(R.menu.optionmenu);
                    pop.show();

            }
        });


    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
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
                return false;
        }
    }

}