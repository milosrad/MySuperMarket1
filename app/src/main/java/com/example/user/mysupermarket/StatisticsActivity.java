package com.example.user.mysupermarket;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 8.10.2016.
 */
public class StatisticsActivity extends MessageActivity {


    private ImageView mIconBack;
    private ImageView mProfileImage;
    private ImageView mIconCheck;
    private ImageView mIconRecomendation;
    private ImageView mIconShopping;

    private TextViewFont mTotalAmount;
    private TextViewFont mShoppping;
    private TextViewFont mRecomendation;

    private TextViewFont mTotalAmountText;
    private TextViewFont mShopppingText;
    private TextViewFont mRecomendationText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_2);

        initComponents();
        addListeners();
    }


    private void initComponents(){


        mIconBack= (ImageView)findViewById(R.id.statisticsiconback);
        mIconCheck= (ImageView)findViewById(R.id.statisticsiconcheck);
        mIconRecomendation= (ImageView)findViewById(R.id.statisticsiconrecomendation);
        mIconShopping= (ImageView)findViewById(R.id.statisticsiconshoping);

        mTotalAmount=(TextViewFont)findViewById(R.id.textViewstatisticspriceamount);
        mRecomendation=(TextViewFont)findViewById(R.id.textViewstaticsrecomendationnumber);
        mShoppping=(TextViewFont)findViewById(R.id.textViewstatisticsshoppingnumber);

        mTotalAmountText=(TextViewFont)findViewById(R.id.totalamount);
        mRecomendationText=(TextViewFont)findViewById(R.id.recomendationnumber);
        mShopppingText=(TextViewFont)findViewById(R.id.shoppingnumber);


        mTotalAmount.setTextColor(getResources().getColor(R.color.colorwhite));
    //    mTotalAmount.setText(getResources().getString(R.string.TotalAmount));

        mRecomendation.setTextColor(getResources().getColor(R.color.colorwhite));
    //    mRecomendation.setText(getResources().getString(R.string.Recomendations));

        mShoppping.setTextColor(getResources().getColor(R.color.colorwhite));
    //    mShoppping.setText(getResources().getString(R.string.Shopping));

        mTotalAmountText.setTextColor(getResources().getColor(R.color.colorwhite));
        mTotalAmountText.setText(getResources().getString(R.string.TotalAmount));

        mRecomendationText.setTextColor(getResources().getColor(R.color.colorwhite));
        mRecomendationText.setText(getResources().getString(R.string.Recomendations));

        mShopppingText.setTextColor(getResources().getColor(R.color.colorwhite));
        mShopppingText.setText(getResources().getString(R.string.Shopping));






    }


    private void addListeners(){



        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
