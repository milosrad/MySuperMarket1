package com.example.user.mysupermarket;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by User on 18.9.2016.
 */
public class NavigationActivity extends MessageActivity {

    private DrawerLayout mDlMenu;
    private ListView mLVNavigation;
    private ImageView mIconMenu;
    private NavigationAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initComponents();
        addListeners();
    }

    private void initComponents(){

        mDlMenu=(DrawerLayout)findViewById(R.id.drawer_layout);
     //   mLVNavigation=(ListView)findViewById(R.id.listViewNavigation);
        mIconMenu=(ImageView)findViewById(R.id.navigationiconmenu);

        mAdapter= new NavigationAdapter(getApplicationContext());
     //   mLVNavigation.setAdapter(mAdapter);
    }

    private void addListeners(){


        mIconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDlMenu.openDrawer(mLVNavigation);

            }
        });
    }
}
