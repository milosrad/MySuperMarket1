package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 12.9.2016.
 */
public class ResponseCity {

    public ResponseCityPom2 data;


    public class ResponseCityPom1{

        public ArrayList<DataCity>townships;
    }

    public class ResponseCityPom2 extends BaseResponse{

        public ResponseCityPom1 results;

    }
}
