package com.example.user.mysupermarket.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import com.example.user.mysupermarket.custom_component.LoginButton;
import com.example.user.mysupermarket.R;
import com.example.user.mysupermarket.custom_component.TextViewFont;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.DataHomeProducts;

/**
 * Created by User on 19.9.2016.
 */
public class ProductActivity extends MessageActivity {

    private TextViewFont mProductType;
    private TextViewFont mProductSize;
    private TextViewFont mProductColor;
    private TextViewFont mProductMaterial;

    private ImageView mIconBack;
    private ImageView mProductImage;
    private ImageView mProductAddToFavoritesImage;

    private LoginButton mAddtoBasketButton;

    private int position;
    DataHomeProducts product;

    private static boolean isInWishList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initComponents();

        addListeners();
    }



    private void initComponents(){

        mIconBack=(ImageView)findViewById(R.id.producticonback);
        mProductImage=(ImageView)findViewById(R.id.productlargeimage);
        mProductAddToFavoritesImage=(ImageView)findViewById(R.id.productaddtofavoritesicon);


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

        Bundle extras = getIntent().getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

        product= (DataHomeProducts)extras.getParcelable("product");

      //  String size=getIntent().getStringExtra("sizes");

        String size=extras.getString("size");

        String name=extras.getString("name");

        position= extras.getInt("position");

        mProductSize.setText("Velicina: "+size);

        mProductType.setText(name);

        mProductImage.setImageBitmap(bmp );

        if(isInWishList==true){

            mProductAddToFavoritesImage.setColorFilter(getResources().getColor(R.color.colorYellowLogin));



        }

        else {
            isInWishList = false;
            mProductAddToFavoritesImage.setColorFilter(getResources().getColor(R.color.colorwhite));
        }


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

                DataContainer.cartProducts.add(product);

                Intent intent = new Intent(getApplicationContext(),CartActivity.class);

                mProductImage.buildDrawingCache();
                Bitmap image= mProductImage.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                extras.putParcelable("product", (Parcelable) product);
                intent.putExtras(extras);

                startActivity(intent);
            }
        });

        mProductAddToFavoritesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isInWishList==true){


                    mProductAddToFavoritesImage.setColorFilter(getResources().getColor(R.color.favorite_product_shadow));

          //          DataContainer.wishlistProducts.remove(DataContainer.homeProducts.get(position));

                    isInWishList=false;

                    DataContainer.wishlistProducts.remove(product);

                   /* Intent intent = new Intent(getApplicationContext(),FavouriteProductsActivity.class);



                    startActivity(intent);  */

                }


                else{



                    mProductAddToFavoritesImage.setColorFilter(getResources().getColor(R.color.colorYellowLogin));

                //    DataContainer.wishlistProducts.add(DataContainer.homeProducts.get(position));

                    isInWishList= true;

                    DataContainer.wishlistProducts.add(product);

                    Intent intent = new Intent(getApplicationContext(),FavouriteProductsActivity.class);

                    mProductImage.buildDrawingCache();
                    Bitmap image= mProductImage.getDrawingCache();

                    Bundle extras = new Bundle();
                    extras.putParcelable("imagebitmap", image);
                    extras.putParcelable("product", (Parcelable) product);
                    intent.putExtras(extras);

                    startActivity(intent);

                }

              /*  mProductAddToFavoritesImage.setColorFilter(getResources().getColor(R.color.colorYellowLogin));


                DataContainer.wishlistProducts.add(DataContainer.homeProducts.get(position));


                isInWishList= true; */


            }
        });
    }
}
