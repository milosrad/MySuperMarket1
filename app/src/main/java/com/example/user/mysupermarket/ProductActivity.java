package com.example.user.mysupermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 19.9.2016.
 */
public class ProductActivity extends MessageActivity {

    private TextViewFont mProductType;
    private TextViewFont mProductSize;
    private TextViewFont mProductColor;
    private TextViewFont mProductMaterial;

    private ImageView mIconBack;

    private LoginButton mAddtoBasketButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initComponents();

        addListeners();
    }



    private void initComponents(){

        mIconBack=(ImageView)findViewById(R.id.producticonback);


        mProductType=(TextViewFont)findViewById(R.id.producttype);
        mProductSize=(TextViewFont)findViewById(R.id.productsize);
        mProductColor=(TextViewFont)findViewById(R.id.productcolor);
        mProductMaterial=(TextViewFont)findViewById(R.id.productmaterial);
        mAddtoBasketButton=(LoginButton)findViewById(R.id.productaddtobasket);


        mProductType.setText(getResources().getString(R.string.Muskacipela));
        mProductSize.setText(getResources().getString(R.string.Velicina));
        mProductColor.setText(getResources().getString(R.string.Boja));
        mProductMaterial.setText(getResources().getString(R.string.Materijal));
        mAddtoBasketButton.setText(getResources().getString(R.string.Dodajukorpu));


        mProductType.setTextColor(getResources().getColor(R.color.colorwhite));
        mProductSize.setTextColor(getResources().getColor(R.color.colorwhite));
        mProductColor.setTextColor(getResources().getColor(R.color.colorwhite));
        mProductMaterial.setTextColor(getResources().getColor(R.color.colorwhite));


    }



    private void addListeners(){


        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAddtoBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CartActivity.class));
            }
        });
    }
}
