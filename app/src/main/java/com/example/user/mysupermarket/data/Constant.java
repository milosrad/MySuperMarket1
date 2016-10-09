package com.example.user.mysupermarket.data;

/**
 * Created by User on 12.9.2016.
 */
public class Constant {


    public static String APPLICATION_PASSWORD="VRf68vuFNAXWXjTg@!";
    public static String APPLICATIN_USERNAME="phone";

    private static String BASE_URL = "http://shop.cubes.rs/";




    public static String GET_TOKEN_URL = BASE_URL + "phone-home-gettoken";
    public static String LOGIN_URL = BASE_URL + "phone-user";
    public static String SIGNUP_URL = BASE_URL + "phone-signup";
    public static String FORGOT_PASSWORD_URL = BASE_URL + "phone-user-forgotpassword";
    public static String CITY_URL = BASE_URL + "phone-helper-places";
    public static String RESERVATION_URL = BASE_URL + "phone-helper-reservation";
    public static String CATEGORY_URL = BASE_URL + "phone-categories";
    public static String HOME_PAGE_PRODUCT_URL = BASE_URL + "phone-products";

    public static String EDIT_PROFILE_URL= BASE_URL + "phone-myprofile-changedata";


    public static String CHANGE_PASSWORD_URL= BASE_URL + "phone-myprofile-changepassword";

    public static final String URL_FAVOURITES_LIST = BASE_URL + "phone-wishlist";
    public static final String URL_FAVOURITES_ADD = BASE_URL + "phone-wishlist-add";

    //POSTMAN za proveru post metoda
}
