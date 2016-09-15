package com.example.user.mysupermarket.tools;

import com.squareup.otto.Bus;

/**
 * Created by User on 15.9.2016.
 */
public class BusProvider {

    private static Bus bus;

    public BusProvider(){



    }


    public static Bus getInstance(){

        if (bus==null){

            bus= new Bus();



        }

        return bus;

    }
}
