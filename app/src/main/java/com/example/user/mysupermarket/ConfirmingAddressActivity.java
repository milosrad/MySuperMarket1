package com.example.user.mysupermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by User on 22.9.2016.
 */
public class ConfirmingAddressActivity extends MessageActivity {

    EditTextFont mRegistrationStreet;
    EditTextFont mRegistrationStreetNum;
    EditTextFont mRegistrationAptNum;
    EditTextFont mRegistrationFloorNum;
    EditTextFont mRegistrationEntranceNum;
    TextViewFont mRegistrationCity;
    TextViewFont mRegistrationPaymentOptions;
    EditTextFont mRegistrationPostalCode;

    private ImageView mIconBack;

    private LoginButton mConfirmButton;


    ArrayList<String> cityList;

    ArrayList<String>  paymentoptionsList;

    private Spinner mSpinnerCity;
    private Spinner mSpinnerPaymentOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirming_address);
        initComponents();

        addSpinners();
        addListeners();
    }


    private void initComponents(){


        mRegistrationStreet = (EditTextFont) findViewById(R.id.confirmingaddress_street);

        mRegistrationStreet.setHint(getResources().getString(R.string.Unesitenazivulice));
        mRegistrationStreet.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationStreetNum = (EditTextFont) findViewById(R.id.confirmingaddress_streetnumber);

        mRegistrationStreetNum.setHint(getResources().getString(R.string.Unesitebrojulice));
        mRegistrationStreetNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationAptNum = (EditTextFont) findViewById(R.id.confirmingaddress_aptnumber);

        mRegistrationAptNum.setHint(getResources().getString(R.string.Unesitebrojstana));
        mRegistrationAptNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationFloorNum = (EditTextFont) findViewById(R.id.confirmingaddress_floornumber);

        mRegistrationFloorNum.setHint(getResources().getString(R.string.Unesitebrojsprata));
        mRegistrationFloorNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationEntranceNum = (EditTextFont) findViewById(R.id.confirmingaddress_entrancenumber);

        mRegistrationEntranceNum.setHint(getResources().getString(R.string.Unesitebrojulaza));
        mRegistrationEntranceNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationCity = (TextViewFont) findViewById(R.id.confirmingaddress_city);

        mRegistrationCity.setHint(getResources().getString(R.string.Unesiteimegrada));
        mRegistrationCity.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationPostalCode = (EditTextFont) findViewById(R.id.confirmingaddress_postalcodenumber);

        mRegistrationPostalCode.setHint(getResources().getString(R.string.Unesitepostanskibroj));
        mRegistrationPostalCode.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mIconBack=(ImageView)findViewById(R.id.confirmingaddressiconback);

        mConfirmButton=(LoginButton)findViewById(R.id.confirmingaddress_button);

        mRegistrationPaymentOptions=(TextViewFont)findViewById(R.id.confirmingaddress_paymentoptions);



        mRegistrationPaymentOptions.setHintTextColor(getResources().getColor(R.color.colorwhite));



      /*  mSpinnerCity = (Spinner) findViewById(R.id.spinnercity);

        mSpinnerCity.setBackgroundColor(getResources().getColor(R.color.colorwhite)); */
    }

    public void addListeners(){

        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),FinalCartActivity.class));



            }
        });
    }


    public void addSpinners(){


        cityList=new ArrayList<>();

        cityList.add("Izaberite grad");

        cityList.add("Beograd");
        cityList.add("Novi Sad");
        cityList.add("Nis");


        mSpinnerCity=(Spinner) findViewById(R.id.spinnercityconfirmingaddress);

        mSpinnerCity.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        ArrayAdapter<String> spinnerCityAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.city_spinner_item,cityList);


        spinnerCityAdapter.setDropDownViewResource(R.layout.city_spinner_item);

        mSpinnerCity.setAdapter(spinnerCityAdapter);

        mSpinnerPaymentOptions=(Spinner)findViewById(R.id.spinnerpaymentoptionsconfirmingaddress);


        mSpinnerPaymentOptions.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        ArrayAdapter<String> paymentOptionsAdapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.city_spinner_item,getResources().getStringArray(R.array.payment_options));

        paymentOptionsAdapter.setDropDownViewResource(R.layout.city_spinner_item);

        mSpinnerPaymentOptions.setAdapter(paymentOptionsAdapter);
    }
}
