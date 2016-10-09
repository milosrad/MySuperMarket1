package com.example.user.mysupermarket.data;

import com.example.user.mysupermarket.data.response.DataCategory;
import com.example.user.mysupermarket.data.response.DataCity;
import com.example.user.mysupermarket.data.response.DataEditProfile;
import com.example.user.mysupermarket.data.response.DataForgotPassword;
import com.example.user.mysupermarket.data.response.DataHomeProducts;
import com.example.user.mysupermarket.data.response.DataLogin;
import com.example.user.mysupermarket.data.response.DataReservation;
import com.example.user.mysupermarket.data.response.DataSignUp;

import java.util.ArrayList;

/**
 * Created by User on 12.9.2016.
 */
public class DataContainer {

    public static String TOKEN;
    public static String LOGIN_TOKEN;

    public static ArrayList<DataCategory>categories;
    public static ArrayList<DataCity>cities;
    public static ArrayList<DataReservation>reservations;
    public static ArrayList<DataSignUp>dataSignUps;
    public static ArrayList<DataLogin>dataLogin;

  //  public static DataLogin dataLogin;
    public static ArrayList<DataForgotPassword> forgottenPasswordEmail;
    public static ArrayList<DataHomeProducts> homeProducts;



    public static ArrayList<DataHomeProducts> cartProducts;

    public static ArrayList<DataEditProfile> profiledata;

    public static ArrayList<DataHomeProducts> wishlistProducts=new ArrayList<>();




}
