package com.example.user.mysupermarket.networking;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by User on 12.9.2016.
 */
public class GsonRequest<T> extends Request<T> {

    private Gson mGson= new Gson();

    private Class<T> mClass;

    private Response.Listener<T> mListener;
    private Response.ErrorListener mErrorListener;

    private final int TIME_OUT=10000;

    public GsonRequest(String url,Response.ErrorListener listener){

        super(url,listener);

    }

    public GsonRequest(String url,int type,Class<T>myClass,Response.Listener<T> listener,Response.ErrorListener errorListener){


        super(type,url,errorListener);

        this.mClass=myClass;
        this.mListener=listener;
        this.mErrorListener=errorListener;


        setRetryPolicy(new DefaultRetryPolicy(TIME_OUT,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {

            String json=new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            return Response.success(mGson.fromJson(json,mClass),HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(T response) {

        mListener.onResponse(response);

    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }
}
