package com.example.user.mysupermarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.user.mysupermarket.data.Constant;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.ResponseSignUp;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;

import java.util.ArrayList;

/**
 * Created by User on 21.9.2016.
 */
public class RegistrationActivity extends MessageActivity {

    private EditTextFont mImePrezime;

    private GsonRequest<ResponseSignUp> mRequestSignUp;

    private Spinner mSpinnerCity;
    private Spinner mSpinnerDate;
    private Spinner mSpinnerMonth;
    private Spinner mSpinnerYear;

    private final String REQUEST_TAG="Fragment Registracija";

    EditTextFont mRegistrationName;
    EditTextFont mRegistrationSurname;
    EditTextFont mRegistrationEmail;
    EditTextFont mRegistrationPassword;
    EditTextFont mRegistrationPasswordRetype;
    EditTextFont mRegistrationCellNum;
    EditTextFont mRegistrationPhone;
    EditTextFont mRegistrationFax;
    EditTextFont mRegistrationStreet;
    EditTextFont mRegistrationStreetNum;
    EditTextFont mRegistrationAptNum;
    EditTextFont mRegistrationFloorNum;
    EditTextFont mRegistrationEntranceNum;
    TextViewFont mRegistrationCity;
    EditTextFont mRegistrationPostalCode;
    TextViewFont mRegistrationNewsletter;
    TextViewFont mRegistrationDate;
    TextViewFont mRegistrationMonth;
    TextViewFont mRegistrationYear;
    TextViewFont mRegistrationGender;
    TextViewFont mRegistrationGenderMale;
    TextViewFont mRegistrationGenderFemale;
    CheckBox mCheckBoxNewsletter;
    RadioButton mRadioButtonMale;
    RadioButton mRadioButtonFemale;
    LoginButton mTermsOfUseButton;
    LoginButton mSignUpButton;


    ArrayList<String> cityList;
    ArrayList<String> dateList;
    ArrayList<String> monthList;
    ArrayList<String> yearList;



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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);


        mRegistrationName = (EditTextFont) findViewById(R.id.registration_username);

        mRegistrationName.setHint(getResources().getString(R.string.Ime));
        mRegistrationName.setTextColor(getResources().getColor(R.color.colorwhite));
        mRegistrationName.setHintTextColor(getResources().getColor(R.color.colorwhite));
        //     Label.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        mRegistrationSurname = (EditTextFont) findViewById(R.id.registration_surname);

        mRegistrationSurname.setHint(getResources().getString(R.string.Prezime));
        mRegistrationSurname.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationEmail = (EditTextFont) findViewById(R.id.registration_email);

        mRegistrationEmail.setHint(getResources().getString(R.string.EMail));
        mRegistrationEmail.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationPassword = (EditTextFont) findViewById(R.id.registration_password);

        mRegistrationPassword.setHint(getResources().getString(R.string.Lozinka));
        mRegistrationPassword.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationPasswordRetype = (EditTextFont) findViewById(R.id.registration_passwordretype);

        mRegistrationPasswordRetype.setHint(getResources().getString(R.string.Potvrditelozinku));
        mRegistrationPasswordRetype.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationCellNum = (EditTextFont) findViewById(R.id.registration_mobile);

        mRegistrationCellNum.setHint(getResources().getString(R.string.Unesitebrojmobilnogtelefona));
        mRegistrationCellNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationPhone = (EditTextFont) findViewById(R.id.registration_phone);

        mRegistrationPhone.setHint(getResources().getString(R.string.Unesitebrojmobilnogtelefona));
        mRegistrationPhone.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationFax = (EditTextFont) findViewById(R.id.registration_fax);

        mRegistrationFax.setHint(getResources().getString(R.string.Unesitebrojmobilnogtelefona));
        mRegistrationFax.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationStreet = (EditTextFont) findViewById(R.id.registration_street);

        mRegistrationStreet.setHint(getResources().getString(R.string.Unesitenazivulice));
        mRegistrationStreet.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationStreetNum = (EditTextFont) findViewById(R.id.registration_streetnumber);

        mRegistrationStreetNum.setHint(getResources().getString(R.string.Unesitebrojulice));
        mRegistrationStreetNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationAptNum = (EditTextFont) findViewById(R.id.registration_aptnumber);

        mRegistrationAptNum.setHint(getResources().getString(R.string.Unesitebrojstana));
        mRegistrationAptNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationFloorNum = (EditTextFont) findViewById(R.id.registration_floornumber);

        mRegistrationFloorNum.setHint(getResources().getString(R.string.Unesitebrojsprata));
        mRegistrationFloorNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationEntranceNum = (EditTextFont) findViewById(R.id.registration_entrancenumber);

        mRegistrationEntranceNum.setHint(getResources().getString(R.string.Unesitebrojulaza));
        mRegistrationEntranceNum.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationCity = (TextViewFont) findViewById(R.id.registration_city);

        mRegistrationCity.setHint(getResources().getString(R.string.Unesiteimegrada));
        mRegistrationCity.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationPostalCode = (EditTextFont) findViewById(R.id.registration_postalcodenumber);

        mRegistrationPostalCode.setHint(getResources().getString(R.string.Unesitepostanskibroj));
        mRegistrationPostalCode.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationNewsletter = (TextViewFont) findViewById(R.id.registration_newsleter);

        mRegistrationNewsletter.setHint(getResources().getString(R.string.Newsletter));
        mRegistrationNewsletter.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationDate = (TextViewFont) findViewById(R.id.registration_day);

        mRegistrationDate.setHint(getResources().getString(R.string.Dan));
        mRegistrationDate.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationMonth = (TextViewFont) findViewById(R.id.registration_month);

        mRegistrationMonth.setHint(getResources().getString(R.string.Mesec));
        mRegistrationMonth.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationYear = (TextViewFont) findViewById(R.id.registration_year);

        mRegistrationYear.setHint(getResources().getString(R.string.Godina));
        mRegistrationYear.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationGender = (TextViewFont) findViewById(R.id.registration_gender);

        mRegistrationGender.setHint(getResources().getString(R.string.Pol));
        mRegistrationGender.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationGenderMale = (TextViewFont) findViewById(R.id.textviewregistrationgendermale);

        mRegistrationGenderMale.setHint(getResources().getString(R.string.PolMuski));
        mRegistrationGenderMale.setHintTextColor(getResources().getColor(R.color.colorwhite));

        mRegistrationGenderFemale = (TextViewFont) findViewById(R.id.textviewregistrationgenderfemale);

        mRegistrationGenderFemale.setHint(getResources().getString(R.string.PolZenski));
        mRegistrationGenderFemale.setHintTextColor(getResources().getColor(R.color.colorwhite));


        mSpinnerCity = (Spinner) findViewById(R.id.spinnercity);

        mSpinnerCity.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        mSpinnerDate = (Spinner) findViewById(R.id.spinnerday);

        mSpinnerDate.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        mSpinnerMonth = (Spinner) findViewById(R.id.spinnermonth);

        mSpinnerMonth.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        mSpinnerYear = (Spinner) findViewById(R.id.spinneryear);

        mSpinnerYear.setBackgroundColor(getResources().getColor(R.color.colorwhite));

        mCheckBoxNewsletter= (CheckBox) findViewById(R.id.checkboxnewsletter);

        mCheckBoxNewsletter.setTextColor(getResources().getColor(R.color.colorwhite));
        mCheckBoxNewsletter.setHighlightColor(getResources().getColor(R.color.colorwhite));

        mRadioButtonMale  = (RadioButton) findViewById(R.id.radiobuttongendermale);
        mRadioButtonFemale  = (RadioButton) findViewById(R.id.radiobuttongenderfemale);

        mRadioButtonFemale.setTextColor((getResources().getColor(R.color.colorwhite)));
        mRadioButtonMale.setTextColor((getResources().getColor(R.color.colorwhite)));

        mTermsOfUseButton=(LoginButton)findViewById(R.id.termsofusebutton);

        mTermsOfUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TermsOfUseActivity.class));
            }
        });


        mRequestSignUp=new GsonRequest<ResponseSignUp>(Constant.SIGNUP_URL + "?token=" + DataContainer.TOKEN, Request.Method.POST, ResponseSignUp.class, new Response.Listener<ResponseSignUp>() {
            @Override
            public void onResponse(ResponseSignUp response) {

                DataContainer.dataSignUps=response.data.results;

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mSignUpButton=(LoginButton)findViewById(R.id.registration_button);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"SIGN IN",Toast.LENGTH_LONG).show();

                DataLoader.addRequest(getApplicationContext(), mRequestSignUp, REQUEST_TAG);

                startActivity(new Intent(getApplicationContext(),NavigationActivity.class));
            }
        });

        onViewCreated();



        //    return inflater.inflate(R.layout.activity_registration, container, false);
    }



    public void onViewCreated() {



        //    DataLoader.addRequest(getActivity().getApplicationContext(), mRequestSignUp, REQUEST_TAG);
        cityList=new ArrayList<>();

        cityList.add("Izaberite grad");

        cityList.add("Beograd");
        cityList.add("Novi Sad");
        cityList.add("Nis");


        mSpinnerCity=(Spinner) findViewById(R.id.spinnercity);

        ArrayAdapter<String> spinnerCityAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.city_spinner_item,cityList);


        spinnerCityAdapter.setDropDownViewResource(R.layout.city_spinner_item);

        mSpinnerCity.setAdapter(spinnerCityAdapter);


        dateList=new ArrayList<>();

        dateList.add("Izaberite dan");

        dateList.add("1");
        dateList.add("2");
        dateList.add("3");
        dateList.add("4");
        dateList.add("5");
        dateList.add("6");
        dateList.add("7");
        dateList.add("8");
        dateList.add("9");
        dateList.add("10");
        dateList.add("11");
        dateList.add("12");
        dateList.add("13");
        dateList.add("14");
        dateList.add("15");
        dateList.add("16");


        mSpinnerDate=(Spinner) findViewById(R.id.spinnerday);

        ArrayAdapter<String> spinnerDateAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.date_spinner_item,dateList);


        spinnerDateAdapter.setDropDownViewResource(R.layout.date_spinner_item);

        mSpinnerDate.setAdapter(spinnerDateAdapter);


        monthList=new ArrayList<>();

        monthList.add("Izaberite mesec");

        monthList.add("1");
        monthList.add("2");
        monthList.add("3");
        monthList.add("4");
        monthList.add("5");
        monthList.add("6");
        monthList.add("7");
        monthList.add("8");
        monthList.add("9");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");



        mSpinnerMonth=(Spinner) findViewById(R.id.spinnermonth);

        ArrayAdapter<String> spinnerMonthAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.date_spinner_item,monthList);


        spinnerDateAdapter.setDropDownViewResource(R.layout.date_spinner_item);

        mSpinnerMonth.setAdapter(spinnerMonthAdapter);



        yearList=new ArrayList<>();

        yearList.add("Izaberite godinu");

        yearList.add("1983");
        yearList.add("1984");
        yearList.add("1985");
        yearList.add("1986");
        yearList.add("1987");
        yearList.add("1988");
        yearList.add("1989");
        yearList.add("1990");
        yearList.add("1991");
        yearList.add("1992");
        yearList.add("1993");
        yearList.add("1994");



        mSpinnerYear=(Spinner) findViewById(R.id.spinneryear);

        ArrayAdapter<String> spinnerYearAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.date_spinner_item,yearList);


        spinnerYearAdapter.setDropDownViewResource(R.layout.date_spinner_item);

        mSpinnerYear.setAdapter(spinnerYearAdapter);





    }



    /*  private Map<String,String> request() {
        Map<String, String> requestParams = new HashMap<String,String>();

      /*  if (layoutPravna.getVisibility() == View.VISIBLE) {
            requestParams.put("user_type", "company");
            requestParams.put("company_name",
                    editNazivFirme.getText().toString());
            requestParams.put("pib", editPib.getText()
                    .toString());
        } else {
            requestParams.put("user_type", "buyer");
            requestParams.put("company_name", "");
            requestParams.put("pib", "");
        } */

     /*   requestParams.put("first_name", mR.getText()
                .toString());
        requestParams.put("last_name", editPrezime
                .getText().toString());
        requestParams.put("email", editEmail.getText()
                .toString());
        requestParams.put("password", editPass.getText()
                .toString());
        requestParams.put("password_retype", editPassRep
                .getText().toString());

        requestParams.put("cell_phone", editMobilni
                .getText().toString());
        requestParams.put("phone", editTelefon.getText()
                .toString());
        requestParams.put("fax", editFax.getText()
                .toString());

        requestParams.put("street", editUlica.getText()
                .toString());
        requestParams.put("number", editBroj.getText()
                .toString());
        requestParams.put("appartement", editBrojStana
                .getText().toString());
        requestParams.put("floor", editSprat.getText()
                .toString());
        requestParams.put("entrance", editBrojUlaza
                .getText().toString());

        requestParams.put("city",
                (String) spinnerGrad.getSelectedItem());
        requestParams.put("postal_code", editPostanskiBroj
                .getText().toString());

        requestParams.put("newsletter",
                checkBox1.isChecked() ? "1" : "0");

        requestParams.put("day",
                (String) spinnerDan.getSelectedItem());
        requestParams.put("month",
                (String) spinnerMesec.getSelectedItem());
        requestParams.put("year",
                (String) spinnerGodina.getSelectedItem());

        requestParams.put("gender",
                radioButtonMuski.isChecked() ? "1" : "2");

        requestParams.put("token", AppController.getInstance()
                .appToken);

        return requestParams;

    }  */
}
