package com.example.user.mysupermarket.data.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by User on 15.9.2016.
 */
public class DataHomeProducts implements Parcelable {

    public String id;
    public double rate;
    public String name;
    public String description;

    public double first_price;
    public double price;

    public String image;
    public String thumb330;
    public String thumb126;
    public String thumb80;
    public String sizes;


    public ArrayList<DataHomeProducts> products;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(image);
        parcel.writeString(thumb80);
        parcel.writeString(thumb126);
        parcel.writeString(thumb330);
        parcel.writeString(sizes);

        parcel.writeDouble(rate);
        parcel.writeDouble(first_price);
        parcel.writeDouble(price);

    }

    DataHomeProducts(Parcel parcel){

        this.id=parcel.readString();
        this.name=parcel.readString();
        this.description=parcel.readString();
        this.image=parcel.readString();
        this.thumb80=parcel.readString();
        this.thumb126=parcel.readString();
        this.thumb330=parcel.readString();
        this.sizes=parcel.readString();

        this.rate=parcel.readDouble();
        this.first_price=parcel.readDouble();
        this.price=parcel.readDouble();



    }

    public static final Parcelable.Creator<DataHomeProducts> CREATOR = new Parcelable.Creator<DataHomeProducts>() {

        @Override
        public DataHomeProducts createFromParcel(Parcel source) {
            return new DataHomeProducts(source);
        }

        @Override
        public DataHomeProducts[] newArray(int size) {
            return new DataHomeProducts[size];
        }
    };
}
