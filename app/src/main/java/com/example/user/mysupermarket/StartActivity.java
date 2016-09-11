package com.example.user.mysupermarket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class StartActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        }).start();
    }


}
