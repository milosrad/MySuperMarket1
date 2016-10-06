package com.example.user.mysupermarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by User on 1.10.2016.
 */
public class IntroActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,View.OnClickListener {

    private ViewPager mViewPagerIntro;

    private LinearLayout mLinearLayoutPageIndicator;

    private LoginButton mCloseButton;

    private int dotsCount;
    private ImageView[] dots;

    private IntroPagerAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initComponents();

        addListeners();
    }


    private void initComponents(){

        mViewPagerIntro=(ViewPager)findViewById(R.id.pager_introduction);

        mViewPagerIntro.setClipToPadding(false);
        mViewPagerIntro.setPageMargin(12);

        mLinearLayoutPageIndicator=(LinearLayout)findViewById(R.id.viewPagerCountDots);

        mCloseButton=(LoginButton)findViewById(R.id.closeButton);

        mAdapter=new IntroPagerAdapter(getSupportFragmentManager(),3);

        mViewPagerIntro.setAdapter(mAdapter);

        setUiPageViewController();

        mViewPagerIntro.setOnPageChangeListener(this);
}

    private void addListeners(){

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot_intro));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            mLinearLayoutPageIndicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot_intro));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot_intro));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot_intro));



    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

    }
}
