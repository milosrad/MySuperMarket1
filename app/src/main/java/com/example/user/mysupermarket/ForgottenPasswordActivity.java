package com.example.user.mysupermarket;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 13.9.2016.
 */
public class ForgottenPasswordActivity extends Activity {

    private ImageView mIconBackImageView;

    private EditTextFont mEmail;

    private LoginButton mEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        initComponents();

        addListeners();
    }

    private void initComponents(){

        mEmail=(EditTextFont)findViewById(R.id.forgottenpassword_email);

        mEmailButton=(LoginButton)findViewById(R.id.forgottenpassword_button);

        mIconBackImageView=(ImageView)findViewById(R.id.iconbackforgottenpassword);

        mEmail.setText(getResources().getString(R.string.Zaboravljenalozinka));

        mEmail.setTextColor(getResources().getColor(R.color.colorwhite));

    }

    private void addListeners(){

        mIconBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }
}
