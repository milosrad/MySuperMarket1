package com.example.user.mysupermarket;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 11.10.2016.
 */
public class FavouriteProductsActivity extends MessageActivity {

    private ImageView mIconBack;

    private RecyclerView mRecyclerView;

    public FavouriteProductsAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__favourite_products);

        initComponents();

        addListeners();
    }

    private void initComponents(){



        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_cart);

        mLayoutManager=new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        Intent intent = getIntent();
        Bundle extras =intent.getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

        mAdapter=new FavouriteProductsAdapter(intent,getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);

        mIconBack=(ImageView)findViewById(R.id.favoritesiconback);


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
