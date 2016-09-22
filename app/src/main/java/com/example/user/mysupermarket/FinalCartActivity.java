package com.example.user.mysupermarket;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by User on 22.9.2016.
 */
public class FinalCartActivity extends MessageActivity {

    private ImageView mIconBack;

    private ListView mListView;

    private FinalCartAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_cart);

        initComponents();
        addListeners();
    }


    private void initComponents(){

        mIconBack=(ImageView)findViewById(R.id.finalcarticonback);

        mListView=(ListView)findViewById(R.id.finalcartlistview);

        mAdapter= new FinalCartAdapter(getApplicationContext());

        mListView.setAdapter(mAdapter);
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
