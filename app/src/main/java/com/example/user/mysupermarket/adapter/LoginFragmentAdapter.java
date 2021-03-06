package com.example.user.mysupermarket.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.mysupermarket.fragment.FragmentPrijava;
import com.example.user.mysupermarket.fragment.FragmentRegistracija;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class LoginFragmentAdapter extends FragmentPagerAdapter {

    private static int NUM_PAGES = 2;

    private int tabCount;


    public LoginFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public LoginFragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
            //    return FragmentPrijava.newInstance(0, "PRIJAVA");
            FragmentPrijava tab1 = new FragmentPrijava();
            return tab1;
            case 1: // Fragment # 0 - This will show FirstFragment different title
               // return FragmentRegistracija.newInstance(1, "REGISTRACIJA");
                FragmentRegistracija tab2 = new FragmentRegistracija();
                return tab2;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {


      //  return tabCount;
        return NUM_PAGES;
    }
}
