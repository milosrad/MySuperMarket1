package com.example.user.mysupermarket;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.user.mysupermarket.data.Constant;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.ResponseLogin;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class FragmentPrijava extends android.support.v4.app.Fragment {




    EditTextFont mUserName;
    EditTextFont mPassword;
    LoginButton mSignInButton;
    LoginButton mSignInForgottenPasswordButton;
    LoginButton mSkipButton;
    TextViewFont mRememberMe;
    CheckBox mRememberMeCheckBox;

    private GsonRequest<ResponseLogin> mRequestLogin;

    private final String REQUEST_TAG="Fragment Prijava";

    public static boolean isSignInSkipped=false;



    View view;


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_sign_in, container, false);
        mUserName = (EditTextFont) view.findViewById(R.id.sign_in_username);
        mUserName.setHint(getResources().getString(R.string.Korisnickoime));
        mUserName.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mPassword = (EditTextFont) view.findViewById(R.id.sign_in_password);
        mPassword.setHint(getResources().getString(R.string.Lozinka));
        mPassword.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRequestLogin= new GsonRequest<ResponseLogin>(Constant.LOGIN_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseLogin.class, new Response.Listener<ResponseLogin>() {
            @Override
            public void onResponse(ResponseLogin response) {

                DataContainer.dataLogins=response.data.results;

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity().getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mSignInButton=(LoginButton)view.findViewById(R.id.sign_in_button);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataLoader.addRequest(getActivity().getApplicationContext(),mRequestLogin,REQUEST_TAG);

                startActivity(new Intent(getActivity().getApplicationContext(),HomeActivity.class));

            }
        });

        mSignInForgottenPasswordButton=(LoginButton)view.findViewById(R.id.forgottenpasswordbutton);

        mSignInForgottenPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getContext(),ForgottenPasswordActivity.class));

            }
        });

        mRememberMe=(TextViewFont)view.findViewById(R.id.sign_in_remember_me);
        mRememberMe.setText(getResources().getString(R.string.Zapamtime));
        mRememberMe.setTextColor(getResources().getColor(R.color.colorwhite));


        mRememberMeCheckBox=(CheckBox)view.findViewById(R.id.remembermecheckbox);


        mUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    mUserName.setHint(getResources().getString(R.string.Korisnickoime));
                }
                else{

                    mUserName.setHint("");
                }


            }
        });

        mSkipButton=(LoginButton)view.findViewById(R.id.skipbutton);

        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSignInSkipped=true;
                startActivity(new Intent(getActivity().getApplicationContext(),HomeActivity.class));
            }
        });


        return view;

     //   return inflater.inflate(R.layout.activity_sign_in, container, false);
    }


}
