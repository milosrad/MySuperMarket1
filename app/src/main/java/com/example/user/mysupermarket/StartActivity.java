package com.example.user.mysupermarket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.user.mysupermarket.data.Constant;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.ResponseCategory;
import com.example.user.mysupermarket.data.response.ResponseCity;
import com.example.user.mysupermarket.data.response.ResponseReservation;
import com.example.user.mysupermarket.data.response.ResponseToken;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class StartActivity extends Activity {


    private GsonRequest<ResponseToken>mRequestToken;
    private GsonRequest<ResponseCategory>mRequestCategory;
    private GsonRequest<ResponseCity>mRequestCity;
    private GsonRequest<ResponseReservation>mRequestReservation;

    private int serviceCounter;




    private final String REQUEST_TAG="Start_activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        serviceCounter=0;



        mRequestToken=new GsonRequest<ResponseToken>(Constant.GET_TOKEN_URL + "?username=" + Constant.APPLICATIN_USERNAME + "&password=" + Constant.APPLICATION_PASSWORD, Request.Method.GET, ResponseToken.class, new Response.Listener<ResponseToken>() {
            @Override
            public void onResponse(ResponseToken response) {

                DataContainer.TOKEN=response.data.results.token;

            //    Toast.makeText(getApplicationContext(),response.data.results.token,Toast.LENGTH_LONG).show();
                incrementServiceCounter();

                DataLoader.addRequest(getApplicationContext(),mRequestCategory,REQUEST_TAG);
            //    incrementServiceCounter();

                DataLoader.addRequest(getApplicationContext(),mRequestCity,REQUEST_TAG);
            //    incrementServiceCounter();

                DataLoader.addRequest(getApplicationContext(),mRequestReservation,REQUEST_TAG);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });


        mRequestCategory= new GsonRequest<ResponseCategory>(Constant.CATEGORY_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseCategory.class, new Response.Listener<ResponseCategory>() {
            @Override
            public void onResponse(ResponseCategory response) {

                DataContainer.categories=response.data.results;

                incrementServiceCounter();

           //     Toast.makeText(getApplicationContext(),DataContainer.categories.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mRequestCity= new GsonRequest<ResponseCity>(Constant.CITY_URL + "?token=" + DataContainer.TOKEN, Request.Method.GET, ResponseCity.class, new Response.Listener<ResponseCity>() {
            @Override
            public void onResponse(ResponseCity response) {

                DataContainer.cities=response.data.results.townships;

                incrementServiceCounter();

                Toast.makeText(getApplicationContext(),DataContainer.cities.toString(),Toast.LENGTH_LONG).show();




            //    Toast.makeText(getApplicationContext(),DataContainer.cities.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

        mRequestReservation=new GsonRequest<ResponseReservation>(Constant.RESERVATION_URL + "?token" + DataContainer.TOKEN, Request.Method.GET, ResponseReservation.class, new Response.Listener<ResponseReservation>() {
            @Override
            public void onResponse(ResponseReservation response) {

             /*   DataContainer.reservations=response.data.results;

                Toast.makeText(getApplicationContext(),DataContainer.reservations.toString(),Toast.LENGTH_LONG).show();

                incrementServiceCounter(); */

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

             //   Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });


        DataLoader.addRequest(getApplicationContext(),mRequestToken,REQUEST_TAG);
    //    DataLoader.addRequest(getApplicationContext(),mRequestCategory,REQUEST_TAG);
    //    DataLoader.addRequest(getApplicationContext(),mRequestCity,REQUEST_TAG);











      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        }).start(); */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        DataLoader.cancelRequest(getApplicationContext(),REQUEST_TAG);
    }

    private void incrementServiceCounter(){

        serviceCounter++;

        if (serviceCounter>=3){

            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();

        }

    }

}
