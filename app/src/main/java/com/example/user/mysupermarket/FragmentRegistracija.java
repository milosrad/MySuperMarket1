package com.example.user.mysupermarket;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class FragmentRegistracija extends android.support.v4.app.Fragment {

    private EditTextFont mImePrezime;

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
        View view = inflater.inflate(R.layout.activity_registration, container, false);
        EditTextFont mRegistrationName = (EditTextFont) view.findViewById(R.id.registration_username);

        mRegistrationName.setText(getResources().getString(R.string.ImeiPrezime));
        mRegistrationName.setTextColor(getResources().getColor(R.color.colorwhite));
   //     Label.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationEmail = (EditTextFont) view.findViewById(R.id.registration_email);

        mRegistrationEmail.setText(getResources().getString(R.string.EMail));
        mRegistrationEmail.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationPassword = (EditTextFont) view.findViewById(R.id.registration_password);

        mRegistrationPassword.setText(getResources().getString(R.string.Lozinka));
        mRegistrationPassword.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationPasswordRetype = (EditTextFont) view.findViewById(R.id.registration_passwordretype);

        mRegistrationPasswordRetype.setText(getResources().getString(R.string.Potvrditelozinku));
        mRegistrationPasswordRetype.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationCellNum = (EditTextFont) view.findViewById(R.id.registration_mobile);

        mRegistrationCellNum.setText(getResources().getString(R.string.Unesitebrojmobilnogtelefona));
        mRegistrationCellNum.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationPhone = (EditTextFont) view.findViewById(R.id.registration_phone);

        mRegistrationPhone.setText(getResources().getString(R.string.Unesitebrojmobilnogtelefona));
        mRegistrationPhone.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationFax = (EditTextFont) view.findViewById(R.id.registration_fax);

        mRegistrationFax.setText(getResources().getString(R.string.Unesitebrojmobilnogtelefona));
        mRegistrationFax.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationStreet = (EditTextFont) view.findViewById(R.id.registration_street);

        mRegistrationStreet.setText(getResources().getString(R.string.Unesitenazivulice));
        mRegistrationStreet.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationStreetNum = (EditTextFont) view.findViewById(R.id.registration_streetnumber);

        mRegistrationStreetNum.setText(getResources().getString(R.string.Unesitebrojulice));
        mRegistrationStreetNum.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationAptNum = (EditTextFont) view.findViewById(R.id.registration_aptnumber);

        mRegistrationAptNum.setText(getResources().getString(R.string.Unesitebrojstana));
        mRegistrationAptNum.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationFloorNum = (EditTextFont) view.findViewById(R.id.registration_floornumber);

        mRegistrationFloorNum.setText(getResources().getString(R.string.Unesitebrojsprata));
        mRegistrationFloorNum.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationEntranceNum = (EditTextFont) view.findViewById(R.id.registration_entrancenumber);

        mRegistrationEntranceNum.setText(getResources().getString(R.string.Unesitebrojulaza));
        mRegistrationEntranceNum.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationCity = (TextViewFont) view.findViewById(R.id.registration_city);

        mRegistrationCity.setText(getResources().getString(R.string.Unesiteimegrada));
        mRegistrationCity.setTextColor(getResources().getColor(R.color.colorwhite));

        EditTextFont mRegistrationPostalCode = (EditTextFont) view.findViewById(R.id.registration_postalcodenumber);

        mRegistrationPostalCode.setText(getResources().getString(R.string.Unesitepostanskibroj));
        mRegistrationPostalCode.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationNewsletter = (TextViewFont) view.findViewById(R.id.registration_newsleter);

        mRegistrationNewsletter.setText(getResources().getString(R.string.Newsletter));
        mRegistrationNewsletter.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationDate = (TextViewFont) view.findViewById(R.id.registration_day);

        mRegistrationDate.setText(getResources().getString(R.string.Dan));
        mRegistrationDate.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationMonth = (TextViewFont) view.findViewById(R.id.registration_month);

        mRegistrationMonth.setText(getResources().getString(R.string.Mesec));
        mRegistrationMonth.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationYear = (TextViewFont) view.findViewById(R.id.registration_year);

        mRegistrationYear.setText(getResources().getString(R.string.Godina));
        mRegistrationYear.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationGender = (TextViewFont) view.findViewById(R.id.registration_gender);

        mRegistrationGender.setText(getResources().getString(R.string.Pol));
        mRegistrationGender.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationGenderMale = (TextViewFont) view.findViewById(R.id.textviewregistrationgendermale);

        mRegistrationGenderMale.setText(getResources().getString(R.string.PolMuski));
        mRegistrationGenderMale.setTextColor(getResources().getColor(R.color.colorwhite));

        TextViewFont mRegistrationGenderFemale = (TextViewFont) view.findViewById(R.id.textviewregistrationgenderfemale);

        mRegistrationGenderFemale.setText(getResources().getString(R.string.PolZenski));
        mRegistrationGenderFemale.setTextColor(getResources().getColor(R.color.colorwhite));


        Spinner mSpinnerCity = (Spinner) view.findViewById(R.id.spinnercity);

        mSpinnerCity.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        Spinner mSpinnerDay = (Spinner) view.findViewById(R.id.spinnerday);

        mSpinnerDay.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        Spinner mSpinnerMonth = (Spinner) view.findViewById(R.id.spinnermonth);

        mSpinnerMonth.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        Spinner mSpinnerYear = (Spinner) view.findViewById(R.id.spinneryear);

        mSpinnerYear.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        CheckBox mCheckBoxNewsletter= (CheckBox) view.findViewById(R.id.checkboxnewsletter);

        mCheckBoxNewsletter.setTextColor(getResources().getColor(R.color.colorwhite));
        mCheckBoxNewsletter.setHighlightColor(getResources().getColor(R.color.colorwhite));

        RadioButton mRadioButtonMale  = (RadioButton) view.findViewById(R.id.radiobuttongendermale);
        RadioButton mRadioButtonFemale  = (RadioButton) view.findViewById(R.id.radiobuttongenderfemale);

        mRadioButtonFemale.setTextColor((getResources().getColor(R.color.colorwhite)));
        mRadioButtonMale.setTextColor((getResources().getColor(R.color.colorwhite)));

        return view;




    //    return inflater.inflate(R.layout.activity_registration, container, false);
    }


}
