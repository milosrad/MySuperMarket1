package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 15.9.2016.
 */
public class ResponseLogin {

    public ResponseLoginPom data;



    public class ResponseLoginPom extends BaseResponse{

        public ArrayList<DataLogin> results;

     //   public DataLogin results;

        public String token;
        public String login_token;
        public String incorrect__logins;

    }
}
