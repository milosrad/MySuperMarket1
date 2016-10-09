package com.example.user.mysupermarket;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.Format;
import java.util.Map;

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

    public CartAdapter mAdapter;

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



        mTotalPrice=(TextViewFont)findViewById(R.id.textViewtotalprice);

        mIconBack=(ImageView)findViewById(R.id.carticonback);
        mIconSum=(ImageView)findViewById(R.id.carticonright);

        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_cart);

        mLayoutManager=new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);


      //  mAdapter=new CartAdapter(getApplicationContext());

        ActivityManager am = (ActivityManager)getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;




    //    mRecyclerView.setAdapter(mAdapter);

        mTotalPrice.setText("Ukupno:");

     /*   mAddress=(TextViewFont)findViewById(R.id.carttextviewaddress);

        mAddress.setText("Podaci o adresi:");

        mAddress.setTextColor(getResources().getColor(R.color.colorwhite)); */

        mTotalPrice.setTextColor(getResources().getColor(R.color.colorwhite));

        Intent intent = getIntent();
        Bundle extras =intent.getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

        mAdapter=new CartAdapter(intent,getApplicationContext());

        mRecyclerView.setAdapter(mAdapter);

       // CartAdapter.ViewHolder.mProImage.setImageBitmap(bmp);

        

    }

    private void addListeners(){


        mByuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(FragmentPrijava.isSignInSkipped==true){

                 startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));

                }

                else {

                    startActivity(new Intent(getApplicationContext(), ConfirmingAddressActivity.class));

                }

            }
        });

        mTotalSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

     /*   mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }); */

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

    public static Activity getActivity() {
        Class activityThreadClass = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object activityThread = null;
        try {
            activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Field activitiesField = null;
        try {
            activitiesField = activityThreadClass.getDeclaredField("mActivities");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        activitiesField.setAccessible(true);

        Map<Object, Object> activities = null;
        try {
            activities = (Map<Object, Object>) activitiesField.get(activityThread);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(activities == null)
            return null;

        for (Object activityRecord : activities.values()) {
            Class activityRecordClass = activityRecord.getClass();
            Field pausedField = null;
            try {
                pausedField = activityRecordClass.getDeclaredField("paused");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            pausedField.setAccessible(true);
            try {
                if (!pausedField.getBoolean(activityRecord)) {
                    Field activityField = null;
                    try {
                        activityField = activityRecordClass.getDeclaredField("activity");
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    activityField.setAccessible(true);
                    Activity activity = null;
                    try {
                        activity = (Activity) activityField.get(activityRecord);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return activity;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return  null;
    }
}
