package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 8.10.2016.
 */
public class ResponseEditProfile {

    public ResponseEditProfilePom data;



    public class ResponseEditProfilePom extends BaseResponse{

        public String message;

        public ArrayList<DataEditProfile> results;

    }
}
