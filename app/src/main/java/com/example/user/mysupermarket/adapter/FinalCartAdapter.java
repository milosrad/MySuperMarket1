package com.example.user.mysupermarket.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.user.mysupermarket.custom_component.LoginButton;
import com.example.user.mysupermarket.R;
import com.example.user.mysupermarket.custom_component.TextViewFont;

/**
 * Created by User on 22.9.2016.
 */
public class FinalCartAdapter extends BaseAdapter {

    private Context mContext;

    private LayoutInflater mInflater;


    public FinalCartAdapter(Context context){

        mContext=context;

        mInflater=LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row;

        if(getItemViewType(position)==0){

            row=mInflater.inflate(R.layout.list_item_finalcart_item,parent,false);

            RecyclerView recyclerView=(RecyclerView) row.findViewById(R.id.recycler_view_finalcart);


            CartAdapter cartAdapter= new CartAdapter(mContext);

            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(mContext);
            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(cartAdapter);




            //    textView.setText(getItem(position).toString());

        }

       else if(getItemViewType(position)==1){

            row= mInflater.inflate(R.layout.list_item_finalcart_address_item,parent,false);

            TextViewFont textView=(TextViewFont) row.findViewById(R.id.finalcarttextviewaddress);

            textView.setText("Podaci o adresi:");

            ImageView imageView=(ImageView)row.findViewById(R.id.finalcarticonright);
        }
        else if(getItemViewType(position)==2){

            row=mInflater.inflate(R.layout.list_item_finalcart_finalprice,parent,false);

            TextViewFont textView=(TextViewFont) row.findViewById(R.id.textViewfinalcarttotalprice);

            textView.setText("Ukupno:");


        }
        else{

            row=mInflater.inflate(R.layout.list_item_finalcart_buybutton,parent,false);


            LoginButton loginButton= (LoginButton) row.findViewById(R.id.finalcartbuy);
            /*    TextViewFont textView=(TextViewFont) row.findViewById(R.id.textViewnavigationtexticon);

                ImageView imageView=(ImageView)row.findViewById(R.id.imageViewnavigationtexticon);

                textView.setText(getItem(position-1).toString());

                switch (position){

                    case 1: imageView.setImageResource(R.drawable.username);
                        break;
                case 2: imageView.setImageResource(R.drawable.username);
                    break;

                case 10: imageView.setImageResource(R.drawable.username);
                    break;

                case 11: imageView.setImageResource(R.drawable.username);
                    break;

                case 12: imageView.setImageResource(R.drawable.username);
                    break;

            } */

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }



        return row;
    }


    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 0;

        }
        else if(position==1){
            return 1;
        }
        else if (position==2){
            return 2;
        }
        else {
            return 3;
        }

    }
}
