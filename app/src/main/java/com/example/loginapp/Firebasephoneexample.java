package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Firebasephoneexample extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebasephoneexample);
        Button logout= findViewById(R.id.logoutbtn);
        firebaseAuth= FirebaseAuth.getInstance();
        checkuserStatus();

logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        firebaseAuth.signOut();
        checkuserStatus();
    }
});


    }

    private void checkuserStatus() {
        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            // user is loged
            String phone= firebaseUser.getPhoneNumber();
            textView=findViewById(R.id.phonetv);
            textView.setText(phone);
        }
        else
        {
            finish();
        }
    }
}