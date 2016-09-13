package com.example.user.mysupermarket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by User on 13.9.2016.
 */
public class TermsOfUseActivity extends Activity {

    private ImageView mIconBack;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_use);

        initComponents();
        addListeners();
    }

    private void initComponents(){

        mIconBack=(ImageView)findViewById(R.id.iconbacktermsofuse);

        mWebView=(WebView)findViewById(R.id.termofusewebview);


    }

    private void addListeners(){

        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
