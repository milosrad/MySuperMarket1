package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 15.9.2016.
 */
public class ResponseHomeProducts {

    public ResponseHomeProductsPom data;



    public class ResponseHomeProductsPom extends BaseResponse{

        public ArrayList<DataHomeProducts> results;



    }
}
