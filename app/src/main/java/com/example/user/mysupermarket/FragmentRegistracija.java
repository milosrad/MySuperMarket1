package com.example.user.mysupermarket;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class FragmentRegistracija extends android.support.v4.app.Fragment {


    /*// Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FragmentRegistracija newInstance(int page, String title) {
        FragmentRegistracija fragmentFirst = new FragmentRegistracija();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    } */

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       /* View view = inflater.inflate(R.layout.activity_login, container, false);
        TextViewFont Label = (TextViewFont) view.findViewById(R.id.registracijasLogin);
        Label.setText(getResources().getString(R.string.registracijalogin));


        return view; */

        return inflater.inflate(R.layout.activity_login, container, false);
    }
}
