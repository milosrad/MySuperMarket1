package com.example.user.mysupermarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mysupermarket.tools.BusProvider;
import com.example.user.mysupermarket.tools.MessageObject;
import com.squareup.otto.Subscribe;

/**
 * Created by User on 15.9.2016.
 */
public class MessageActivity extends AppCompatActivity {

    public View mMessage;

    private TextViewFont mTextViewMessage;

    private Object busEventListener;
    private LayoutInflater mInflater;

    private ViewGroup mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInflater=LayoutInflater.from(getApplicationContext());





        busEventListener= new Object(){

            @Subscribe
            public void onMessageShow(MessageObject messageObject){

//                Toast.makeText(getApplicationContext(),messageObject.stringResource,Toast.LENGTH_LONG).show();

                if (mMessage==null){

                    mMessage=mInflater.inflate(R.layout.activity_error,mRootView,false);

                    mTextViewMessage=(TextViewFont)mMessage.findViewById(R.id.errormessage);


                }

                mTextViewMessage.setText(messageObject.stringResource);


                mRootView.addView(mMessage);

                mRootView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mMessage.setVisibility(View.GONE);

                    }
                },messageObject.time);



            }



        };
        //   setContentView(R.layout.activity_error);

        //   initComponents();

        //   moveViewToScreenCenter(mMessage);
    }


   /* private void initComponents(){

        mMessage=(TextViewFont)findViewById(R.id.errormessage);
    } */


   /* private void moveViewToScreenCenter( View view )
    {
        LinearLayout root = (LinearLayout) findViewById( R.id.root );
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();

        int originalPos[] = new int[2];
        view.getLocationOnScreen( originalPos );

        int xDest = dm.widthPixels/2;
        xDest -= (view.getMeasuredWidth()/2);
        int yDest = dm.heightPixels/2 - (view.getMeasuredHeight()/2) - statusBarOffset;

        TranslateAnimation anim = new TranslateAnimation( 0, xDest - originalPos[0] , 0, yDest - originalPos[1] );
        anim.setDuration(1000);
        anim.setFillAfter( true );
        view.startAnimation(anim);
    }  */


    @Override
    protected void onResume() {
        super.onResume();

        mRootView=(ViewGroup)findViewById(R.id.root);

        BusProvider.getInstance().register(busEventListener);


    }


    @Override
    protected void onPause() {
        super.onPause();

        BusProvider.getInstance().unregister(busEventListener);
    }

}
