package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 12.9.2016.
 */
public class ResponseCategory {

    public ResponseCategoryPom data;

    public class ResponseCategoryPom extends BaseResponse{

        public ArrayList<DataCategory>results;


    }
}
