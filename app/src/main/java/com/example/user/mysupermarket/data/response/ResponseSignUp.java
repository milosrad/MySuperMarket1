package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by User on 15.9.2016.
 */
public class ResponseSignUp {

    public ResponseSignUpPom data;



    public class ResponseSignUpPom extends BaseResponse{

        public String message;

        public ArrayList<DataSignUp> results;

    }
}
