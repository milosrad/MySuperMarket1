package com.example.user.mysupermarket;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.user.mysupermarket.data.DataContainer;

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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextViewFont mTitle;
        public TextViewFont mPrice;
        public ImageView mProImage;
        public ImageView mProBuyImage;
        public ImageView mProBuyImagePlus;
        public RelativeLayout mBuyLayout;



        public ViewHolder(View v){

            super(v);

            mTitle = (TextViewFont) v.findViewById(R.id.producttitle);
            mPrice = (TextViewFont) v.findViewById(R.id.productprice2);
            mProImage=(ImageView)v.findViewById(R.id.productimage);
            mProBuyImage=(ImageView)v.findViewById(R.id.iconshop);
            mProBuyImagePlus=(ImageView)v.findViewById(R.id.blackplusimage);
            mBuyLayout=(RelativeLayout)v.findViewById(R.id.productbuylayout);

         /*   mProImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ProductActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    mContext.startActivity(intent);
                }
            }); */

        }
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_items2,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {

        holder.mTitle.setText(mContext.getString(R.string.Producttitle));
        holder.mTitle.setText(mContext.getString(R.string.Producttitle));
     //   holder.mTitle.setText("Product title");
        holder.mPrice.setText(mContext.getString(R.string.Price));

        holder.mPrice.setText(""+DataContainer.homeProducts.get(position).price);

        Glide.with(mContext).load(DataContainer.homeProducts.get(position).thumb330).thumbnail(0.5f).crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mProImage);


        holder.mProImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                holder.mProImage.buildDrawingCache();
                Bitmap image= holder.mProImage.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                intent.putExtras(extras);

             //   extras.putString("size",DataContainer.homeProducts.get(position).sizes);
             //   extras.putString("name",DataContainer.homeProducts.get(position).name);

                intent.putExtra("size",DataContainer.homeProducts.get(position).sizes);
                intent.putExtra("name",DataContainer.homeProducts.get(position).name);

                mContext.startActivity(intent);
            }
        });

        holder.mProBuyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(mContext,CartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                holder.mProImage.buildDrawingCache();
                Bitmap image= holder.mProImage.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                intent.putExtras(extras);

                mContext.startActivity(intent);
            }
        });

        holder.mProBuyImagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(mContext,CartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                mContext.startActivity(intent);
            }
        });

        holder.mBuyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(mContext,CartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                holder.mProImage.buildDrawingCache();
                Bitmap image= holder.mProImage.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putParcelable("imagebitmap", image);
                intent.putExtras(extras);

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return DataContainer.homeProducts.size();
    }
}
