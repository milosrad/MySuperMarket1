package com.example.user.mysupermarket;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by User on 6.10.2016.
 */
public class IntroPagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;





    public IntroPagerAdapter(FragmentManager fragmentManager, int numOfTabs) {
        super(fragmentManager);
        this.numOfTabs=numOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                FragmentAddToBasket tab1 = new FragmentAddToBasket();
                return tab1;
            case 1:
                FragmentRegistracija tab2 = new FragmentRegistracija();
                return tab2;

            case 2:
                FragmentPrijava tab3 = new FragmentPrijava();
                return tab3;
            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.96f;
    }
}
