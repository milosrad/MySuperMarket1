package com.example.user.mysupermarket.data.response;

import java.util.ArrayList;

/**
 * Created by User on 2.10.2016.
 */
public class ResponseProductSearch  {

    public ResponseProductSearchPom data;

    public class ResponseProductSearchPom extends BaseResponse {
        public ArrayList<DataHomeProducts> results;
    }

}
