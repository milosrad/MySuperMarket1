package com.example.user.mysupermarket;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by User on 18.9.2016.
 */
public class HomeActivity extends MessageActivity {

    private RecyclerView mRecyclerView;

    private RecyclerViewAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_home);

        mLayoutManager=new GridLayoutManager(getApplicationContext(),2);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter=new RecyclerViewAdapter(getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);
    }
}
