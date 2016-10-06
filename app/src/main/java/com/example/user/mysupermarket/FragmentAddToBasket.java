package com.example.user.mysupermarket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.apache.tools.ant.types.Resource;
import org.apache.tools.ant.types.resources.Resources;

/**
 * Created by User on 6.10.2016.
 */
public class FragmentAddToBasket extends android.support.v4.app.Fragment  {


    View view;

    ImageView mShoppingBasket;

    TextViewFont mAddToBasket;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.intro_pager_item_basket, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponents();
        addListeners();
    }

    private void initComponents(){

        mShoppingBasket=(ImageView) view.findViewById(R.id.intro_pager_item_basket_image);



        android.content.res.Resources res = getResources();
        Bitmap src = BitmapFactory.decodeResource(res, R.drawable.whiteshoppingbag);
        RoundedBitmapDrawable rounded =
                RoundedBitmapDrawableFactory.create(res, src);
        rounded.setCircular(true);
        mShoppingBasket.setImageDrawable(rounded);



        mAddToBasket= (TextViewFont)view.findViewById(R.id.intro_pager_item_basket_addtobasket);




    }

    private void addListeners(){

        mShoppingBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mAddToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
