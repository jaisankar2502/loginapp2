package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Webview_example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_example);
        WebView webview= (WebView)findViewById(R.id.My_webView);
        EditText textView= (EditText) findViewById(R.id.link_web);
        Button button= (Button)findViewById(R.id.submit_web);
        webview.setWebViewClient(new WebViewClient());
        button.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String url= textView.getText().toString();
                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.loadUrl("https://www."+url+".com");


            }
        });
    }
}