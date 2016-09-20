package com.example.user.mysupermarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.user.mysupermarket.data.DataContainer;

/**
 * Created by User on 19.9.2016.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;


    public CartAdapter(Context mContext) {

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

        holder.mPrice.setText("Cena:");
        holder.mAmount.setText("Kolicina:1");

        holder.mCartIconPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int number=Character.getNumericValue(holder.mAmount.getText().charAt(9));
                int newnumber=number++;

                holder.mAmount.setText("Kolicina:"+ number);


            }
        });

        holder.mCartIconMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=Character.getNumericValue(holder.mAmount.getText().charAt(9));
                if(number>1) {
                    int newnumber = number--;

                    holder.mAmount.setText("Kolicina:" + number);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return DataContainer.cartProducts.size();
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


}
