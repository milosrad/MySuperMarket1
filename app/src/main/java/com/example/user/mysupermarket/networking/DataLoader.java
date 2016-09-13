package com.example.user.mysupermarket.networking;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

/**
 * Created by User on 12.9.2016.
 */
public class DataLoader {

    private static DataLoader instance;
    private static RequestQueue mQueue;


    private DataLoader(Context context){

        mQueue= Volley.newRequestQueue(context);

    }

    public static DataLoader getInstance(Context context){

         if (instance==null){

             instance=new DataLoader(context);
         }
        return instance;

    }


    public static void addRequest(Context context, Request request,String TAG){

        request.setTag(TAG);

        getInstance(context).mQueue.add(request);

    }

    public static void cancelRequest(Context context,String TAG){

        getInstance(context).mQueue.cancelAll(TAG);
    }
}
