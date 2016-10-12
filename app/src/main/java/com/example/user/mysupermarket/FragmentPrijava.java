package com.example.user.mysupermarket;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.user.mysupermarket.data.response.ResponseForgotPassword;
import com.example.user.mysupermarket.data.response.ResponseLogin;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;
import com.example.user.mysupermarket.tools.BusProvider;
import com.example.user.mysupermarket.tools.MessageObject;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

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
    private Dialog mDialog;

    private GsonRequest<ResponseLogin> mRequestLogin;


    private GsonRequest<ResponseForgotPassword> mRequestForgotPassword;

    private final String REQUEST_TAG="Fragment Prijava";

    public static boolean isSignInSkipped=false;
    public static boolean isFirstTimeEntry=false;



    View view;


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_sign_in, container, false);
    /*    mUserName = (EditTextFont) view.findViewById(R.id.sign_in_username);
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
        }); */


        return view;

     //   return inflater.inflate(R.layout.activity_sign_in, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        isSignInSkipped=false;
        isFirstTimeEntry=true;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponents();
        addListeners();
    }


    public void initComponents(){

        mUserName = (EditTextFont) view.findViewById(R.id.sign_in_username);
        mUserName.setHint(getResources().getString(R.string.EmailAdresa));
        mUserName.setHint(getResources().getString(R.string.EMail));

        mUserName.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mPassword = (EditTextFont) view.findViewById(R.id.sign_in_password);
        mPassword.setHint(getResources().getString(R.string.Lozinka));
        mPassword.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mPassword.setTypeface(mUserName.getTypeface());

        mSignInButton=(LoginButton)view.findViewById(R.id.sign_in_button);

        mSignInForgottenPasswordButton=(LoginButton)view.findViewById(R.id.forgottenpasswordbutton);

        mRememberMe=(TextViewFont)view.findViewById(R.id.sign_in_remember_me);
        mRememberMe.setText(getResources().getString(R.string.Zapamtime));
        mRememberMe.setTextColor(getResources().getColor(R.color.colorwhite));


        mRememberMeCheckBox=(CheckBox)view.findViewById(R.id.remembermecheckbox);

        mSkipButton=(LoginButton)view.findViewById(R.id.skipbutton);

    }


    private void addListeners(){

        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSignInSkipped=true;

                if (isFirstTimeEntry=true){

                    startActivity(new Intent(getActivity().getApplicationContext(),IntroActivity.class));
                    isFirstTimeEntry=false;
                }
                else {

                    startActivity(new Intent(getActivity().getApplicationContext(),MainActivity.class));
                }
             //   startActivity(new Intent(getActivity().getApplicationContext(),HomeActivity.class));
             //   startActivity(new Intent(getActivity().getApplicationContext(),IntroActivity.class));
            }
        });


        mUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    mUserName.setHint(getResources().getString(R.string.EmailAdresa));
                }
                else{

                    mUserName.setHint("");
                }


            }
        });

        mSignInForgottenPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDialog= new Dialog(getContext());
                mDialog.setTitle("Zaboravljena lozinka");
                 mDialog.setContentView(R.layout.sign_in_dialog);
              //  mDialog.show();

                EditTextFont mEditTextEmail=(EditTextFont)mDialog.findViewById(R.id.dialog_info);

                LoginButton mCancel=(LoginButton) mDialog.findViewById(R.id.dialog_cancel);
                LoginButton mSend=(LoginButton) mDialog.findViewById(R.id.dialog_ok);




                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                    }
                });

                mSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditTextFont mEditTextEmail=(EditTextFont)mDialog.findViewById(R.id.dialog_info);
                        mEditTextEmail.setHint(getResources().getString(R.string.Zaboravljenalozinka));
                        mEditTextEmail.setHintTextColor(getResources().getColor(R.color.colorwhite));


                        mRequestForgotPassword= new GsonRequest<ResponseForgotPassword>(Constant.FORGOT_PASSWORD_URL + "?token=" + DataContainer.TOKEN + "?email=" + mEditTextEmail.getText().toString(), Request.Method.GET, ResponseForgotPassword.class, new Response.Listener<ResponseForgotPassword>() {
                            @Override
                            public void onResponse(ResponseForgotPassword response) {

                                DataContainer.forgottenPasswordEmail = response.data.results;
                                Toast.makeText(getContext(), "Error" + response.data.error, Toast.LENGTH_SHORT).show();
                                BusProvider.getInstance().post(new MessageObject());

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });

                        DataLoader.addRequest(getContext(),mRequestForgotPassword,REQUEST_TAG);

                    }
                });

                mDialog.show();


             //   startActivity(new Intent(getContext(),ForgottenPasswordActivity.class));

            }
        });

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mUserName.getText().toString().equalsIgnoreCase("") || mPassword.getText().toString().equalsIgnoreCase("")){

                    Toast.makeText(getContext(),R.string.Popunitepolja,Toast.LENGTH_SHORT).show();
                    BusProvider.getInstance().post(new MessageObject());
                }

                else {

                    mRequestLogin= new GsonRequest<ResponseLogin>(Constant.LOGIN_URL + "?token=" + DataContainer.TOKEN + "?email="+ mUserName.getText().toString()+ "?password="+ mPassword.getText().toString(), Request.Method.GET, ResponseLogin.class, new Response.Listener<ResponseLogin>() {
                        @Override
                        public void onResponse(ResponseLogin response) {

                            DataContainer.dataLogin=response.data.results;

                            if (response.data.error!=""){

                                Toast.makeText(getContext(), R.string.LoginIncorrect, Toast.LENGTH_SHORT).show();
                                BusProvider.getInstance().post(new MessageObject());

                            }

                            else {
                                if(mRememberMeCheckBox.isChecked()) {

                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

                                    SharedPreferences.Editor editor = preferences.edit();

                                    editor.putBoolean("checked", true);
                                    editor.putString("username", mUserName.getText().toString());
                                    editor.putString("password", mPassword.getText().toString());

                                    editor.commit();

                                    startActivity(new Intent(getActivity().getApplicationContext(), HomeActivity.class));
                                }
                                else {
                                    startActivity(new Intent(getActivity().getApplicationContext(), HomeActivity.class));
                                }

                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getActivity().getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                            BusProvider.getInstance().post(new MessageObject());
                        }
                    });




                }

             //   DataLoader.addRequest(getActivity().getApplicationContext(),mRequestLogin,REQUEST_TAG);

            //    startActivity(new Intent(getActivity().getApplicationContext(),HomeActivity.class));

            }
        });

    }

    public static String encryptIt(String value) throws NoSuchAlgorithmException {

        return value;
    };
}
