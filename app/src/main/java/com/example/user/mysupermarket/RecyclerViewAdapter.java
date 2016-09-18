package com.example.user.mysupermarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 18.9.2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Context mContext;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
        mInflater=LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextViewFont mTitle;
        public TextViewFont mPrice;
        public ImageView mProImage;
        public ImageView mProByuImage;



        public ViewHolder(View v){

            super(v);

            mTitle = (TextViewFont) v.findViewById(R.id.producttitle);
            mPrice = (TextViewFont) v.findViewById(R.id.productprice2);
            mProImage=(ImageView)v.findViewById(R.id.productimage);

        }
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_items2,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.mTitle.setText(mContext.getString(R.string.Producttitle));
     //   holder.mTitle.setText("Product title");
        holder.mPrice.setText(mContext.getString(R.string.Price));

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
