package com.example.user.mysupermarket.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.mysupermarket.R;
import com.example.user.mysupermarket.custom_component.TextViewFont;
import com.example.user.mysupermarket.data.DataContainer;

/**
 * Created by User on 19.9.2016.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;

    private Activity context;

    private Intent intent;

    private static double totalPrice=0;


    public CartAdapter(Context mContext) {

        this.mContext = mContext;

        this.mInflater=LayoutInflater.from(mContext);


    }

    public CartAdapter(Intent intent,Context mContext){


        this.intent=intent;

        this.mContext = mContext;

        this.mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cart_recycler_view_items,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CartAdapter.ViewHolder holder, int position) {

        holder.mPrice.setText("Cena:$35.4");
        holder.mAmount.setText("Kolicina:1");

        final double onepieceprice= Double.parseDouble((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length()));

        //final BigDecimal onepiecepricedecimal= new BigDecimal((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length())).setScale(2);



        holder.mCartIconPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*  int number=Character.getNumericValue(holder.mAmount.getText().charAt(9));
                int newnumber=number++;

                holder.mAmount.setText("Kolicina:"+ number); */

                int number=Integer.parseInt((String) holder.mAmount.getText().subSequence(9,holder.mAmount.getText().length()));
                number++;

                holder.mAmount.setText("Kolicina:" + number);

               double price= Double.parseDouble((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length()));

                double newprice=price+onepieceprice;


              /*      BigDecimal price = new BigDecimal((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length())).setScale(2);


                BigDecimal newprice= onepiecepricedecimal.add(price); */

                CharSequence seq1= holder.mPrice.getText().subSequence(0,6);
                String string1= seq1.toString();
                holder.mPrice.setText(string1.concat(""+newprice));



            }
        });

        holder.mCartIconMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* int number=Character.getNumericValue(holder.mAmount.getText().charAt(9));
                if(number>1) {
                    int newnumber = number--;

                    holder.mAmount.setText("Kolicina:" + number);
                } */

                int number=Integer.parseInt((String) holder.mAmount.getText().subSequence(9,holder.mAmount.getText().length()));
                if(number>1) {
                     number--;

                    holder.mAmount.setText("Kolicina:" + number);

                    double price= Double.parseDouble((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length()));

                    double newprice=price-onepieceprice;

                /*    BigDecimal price = new BigDecimal((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length())).setScale(2);


                    BigDecimal newprice= price.subtract(onepiecepricedecimal); */





                    CharSequence seq1= holder.mPrice.getText().subSequence(0,6);
                    String string1= seq1.toString();
                    holder.mPrice.setText(string1.concat(""+newprice));


                }
                else if (number==1)
                {
                    CharSequence seq1= holder.mPrice.getText().subSequence(0,6);
                    String string1= seq1.toString();
                    holder.mPrice.setText(string1.concat(""+onepieceprice));

                }





            }
        });

     //   Intent intent = context.getIntent();

     //   Intent intent = ((Activity) mContext).getIntent();



        Bundle extras =intent.getExtras();
        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

        holder.mProImage.setImageBitmap(bmp);


        for (int i=0; i<getItemCount();i++){

            totalPrice+=Double.parseDouble((String) holder.mPrice.getText().subSequence(6,holder.mAmount.getText().length()));

        }





    }

    @Override
    public int getItemCount() {
        return DataContainer.cartProducts.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextViewFont mType;
        public TextViewFont mPrice;
        public TextViewFont mAmount;
        public static ImageView mProImage;
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

        public static ImageView getmProImage(){return mProImage;}
    }


}
