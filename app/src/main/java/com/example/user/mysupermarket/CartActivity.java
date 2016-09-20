package com.example.user.mysupermarket;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 19.9.2016.
 */
public class CartActivity extends MessageActivity {

    private LoginButton mByuButton;

    private ImageView mTotalSum;

    private TextViewFont mAddress;

    private TextViewFont mTotalPrice;

    private ImageView mIconBack;
    private ImageView mIconSum;

    private RecyclerView mRecyclerView;

    private CartAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initComponents();
        addListeners();
    }

    private void initComponents(){


        mByuButton=(LoginButton)findViewById(R.id.cartbuy);

        mTotalSum=(ImageView)findViewById(R.id.carticonright);

        mAddress=(TextViewFont)findViewById(R.id.carttextviewaddress);

        mTotalPrice=(TextViewFont)findViewById(R.id.textViewtotalprice);

        mIconBack=(ImageView)findViewById(R.id.carticonback);
        mIconSum=(ImageView)findViewById(R.id.carticonright);

        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_cart);

        mLayoutManager=new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter=new CartAdapter(getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);

        mTotalPrice.setText("Ukupno:");

        mAddress.setText("Podaci o adresi:");



        mAddress.setTextColor(getResources().getColor(R.color.colorwhite));
        mTotalPrice.setTextColor(getResources().getColor(R.color.colorwhite));

    }

    private void addListeners(){


        mByuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mTotalSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mIconSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
