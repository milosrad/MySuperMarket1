package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 13.9.2016.
 */
public class ResponseForgotPassword {

    public ResponseForgotPasswordPom data;

    public class ResponseForgotPasswordPom extends BaseResponse{

        public String message;

        public ArrayList <DataForgotPassword> results;

    }
}
