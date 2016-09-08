package com.example.user.mysupermarket;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class LoginActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,TabLayout.OnClickListener{

  //  private PagerTabStrip mPageTabStrip;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    FragmentPagerAdapter mAdapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();

    //    mPageTabStrip.setTabIndicatorColor(getResources().getColor(R.color.colorYellowLogin));


    }



    private void initComponents(){


    //    mPageTabStrip=(PagerTabStrip)findViewById(R.id.pager_header);

        mTabLayout=(TabLayout)findViewById(R.id.tabLayout);
        mViewPager=(ViewPager) findViewById(R.id.viewPager);

        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.prijavalogin)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.registracijalogin)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorYellowLogin));
    //    mTabLayout.setTabTextColors(getColorStateList(Color.WHITE));


        mAdapter= new LoginFragmentAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);

        mTabLayout.setOnTabSelectedListener(this);

        mTabLayout.setOnClickListener(this);



    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View view) {

    }
}
