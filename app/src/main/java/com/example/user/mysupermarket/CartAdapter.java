package com.example.user.mysupermarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by User on 19.9.2016.
 */
public class CartAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;


    public CartAdapter(LayoutInflater mInflater, Context mContext) {

        this.mContext = mContext;

        this.mInflater=LayoutInflater.from(mContext);
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextViewFont mType;
        public TextViewFont mPrice;
        public TextViewFont mAmount;
        public ImageView mProImage;
        public ImageView mCartIconMinus;
        public ImageView mCartIconPlus;



        public ViewHolder(View v){

            super(v);

            mType = (TextViewFont) v.findViewById(R.id.carttypeproduct);
            mPrice = (TextViewFont) v.findViewById(R.id.cartpriceproduct);
            mAmount = (TextViewFont) v.findViewById(R.id.cartamountproduct);
            mProImage=(ImageView)v.findViewById(R.id.cartimageproduct);
            mCartIconMinus=(ImageView)v.findViewById(R.id.carticonminus);
            mCartIconPlus=(ImageView)v.findViewById(R.id.carticonplus);



        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
