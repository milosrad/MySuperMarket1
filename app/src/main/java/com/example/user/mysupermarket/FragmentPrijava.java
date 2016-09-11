package com.example.user.mysupermarket;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class FragmentPrijava extends android.support.v4.app.Fragment {


    private EditTextFont mUsername;
    /*private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FragmentPrijava newInstance(int page, String title) {
        FragmentPrijava fragmentFirst = new FragmentPrijava();
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
    }  */

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sign_in, container, false);
        EditTextFont mUserName = (EditTextFont) view.findViewById(R.id.sign_in_username);
        mUserName.setText(getResources().getString(R.string.Korisnickoime));
        mUserName.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mPassword = (EditTextFont) view.findViewById(R.id.sign_in_password);
        mPassword.setText(getResources().getString(R.string.Lozinka));
        mPassword.setTextColor(getResources().getColor(R.color.colorwhite));

     //   mUserName.setBackgroundColor(getResources().getColor(R.color.colorwhite));



        return view;

     //   return inflater.inflate(R.layout.activity_sign_in, container, false);
    }


}
