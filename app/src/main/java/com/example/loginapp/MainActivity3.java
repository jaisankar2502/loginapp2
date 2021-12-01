package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity3 extends AppCompatActivity {
    String name[]={"JOhn","Mike","Maria","Miguel",};
    int image[]={R.drawable.contact1,R.drawable.contact2,R.drawable.contact3,R.drawable.contact3,};
    String number[]={"9072278138","8592085053","9526300442","9072278138"};
 ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView= findViewById(R.id.list3);
        ContactAdapter adapter= new ContactAdapter(getApplicationContext(),name,image,number);
        listView.setAdapter(adapter);
        listView.setClickable(true);

    }



}