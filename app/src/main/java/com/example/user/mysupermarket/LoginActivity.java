package com.example.user.mysupermarket;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cubesschool5 on 9/7/16.
 */
public class LoginActivity extends MessageActivity implements TabLayout.OnTabSelectedListener {

  //  private PagerTabStrip mPageTabStrip;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    FragmentPagerAdapter mAdapter;

    private ImageView mIconBack,mIconAddPhoto;
    private ImageView mLogo,mPhoto;

    private LinearLayout mRegistrationIcons;

    private SharedPreferences sharedPreferences;

    private LinearLayout mLinearAnimLayout;


    private Uri outputFileUri;

    private static int SELECT_PICTURE_REQUEST_CODE=100;

    private TabLayout.OnTabSelectedListener mTabLayout1;

    private Animation animation, ViewPagerAnimation, fadeInAnimation, fadeOutAnimmation, fadeInLogoAnimation;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();

        addListeners();



    //    mPageTabStrip.setTabIndicatorColor(getResources().getColor(R.color.colorYellowLogin));


    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        mViewPager.setCurrentItem(tab.getPosition(),true);

        int position= tab.getPosition();

        if (position==1){
          /*  mPhoto.setVisibility(View.VISIBLE);
            mIconAddPhoto.setVisibility(View.VISIBLE);
            mLogo.setVisibility(View.GONE);
            mIconBack.setVisibility(View.VISIBLE); */

            mRegistrationIcons.setVisibility(View.VISIBLE);
            mLogo.setVisibility(View.GONE);
        }

        else{
         /*   mPhoto.setVisibility(View.GONE);
            mIconAddPhoto.setVisibility(View.GONE);
            mLogo.setVisibility(View.VISIBLE);
            mIconBack.setVisibility(View.GONE); */

            mRegistrationIcons.setVisibility(View.INVISIBLE);
            mLogo.setVisibility(View.VISIBLE);



        }

     //   mViewPager.setCurrentItem(tab.getPosition(),true);



    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }





    private void initComponents(){


    //    mPageTabStrip=(PagerTabStrip)findViewById(R.id.pager_header);

        mIconAddPhoto=(ImageView)findViewById(R.id.iconaddphoto);
        mIconBack=(ImageView)findViewById(R.id.iconbacklogin);

        mLogo=(ImageView)findViewById(R.id.imageViewlogo);
        mPhoto=(ImageView)findViewById(R.id.registrationphotoimage);

        mTabLayout=(TabLayout)findViewById(R.id.tabLayout);
        mViewPager=(ViewPager) findViewById(R.id.viewPager);


        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.prijavalogin)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.registracijalogin)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorYellowLogin));
        mTabLayout.setTabTextColors(getResources().getColorStateList(R.color.m_text_selector));




   //     mAdapter= new LoginFragmentAdapter(getSupportFragmentManager());

       mAdapter=new LoginFragmentAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());

        mViewPager.setAdapter(mAdapter);

        mTabLayout.setOnTabSelectedListener(this);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

     //   mTabLayout.setOnClickListener(this);

        mRegistrationIcons=(LinearLayout)findViewById(R.id.registrationicons);



    }

    private void addListeners(){


        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mIconAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent takepicture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takepicture,0);

                Intent pickphoto=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickphoto,1);

                //openImageIntent();

            }
        });




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                   /* Uri selectedImage = imageReturnedIntent.getData();
                    mPhoto.setImageURI(selectedImage); */
                    Uri selectedImage=imageReturnedIntent.getData();
                    Glide.with(getApplicationContext()).load(selectedImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(mPhoto){

                        @Override
                        protected void setResource(Bitmap resource) {

                            RoundedBitmapDrawable circularBitmapDrawable= RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(),resource);
                            circularBitmapDrawable.setCircular(true);
                            mPhoto.setImageDrawable(circularBitmapDrawable);
                        }
                    });
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                  /*  Uri selectedImage = imageReturnedIntent.getData();
                    mPhoto.setImageURI(selectedImage); */

                    Uri selectedImage=imageReturnedIntent.getData();
                    Glide.with(getApplicationContext()).load(selectedImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(mPhoto){

                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable= RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(),resource);
                            circularBitmapDrawable.setCircular(true);
                            mPhoto.setImageDrawable(circularBitmapDrawable);
                        }
                    });


                }
                break;
        }
    }


    /*private void openImageIntent() {

// Determine Uri of camera image to save.
        final File root = new File(Environment.getExternalStorageDirectory() + File.separator + "MyDir" + File.separator);
        root.mkdirs();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        final String fname = df.format(today);//Utils.getUniqueImageFilename();
        final File sdImageMainDirectory = new File(root, fname);
        outputFileUri = Uri.fromFile(sdImageMainDirectory);

        // Camera.
        final List<Intent> cameraIntents = new ArrayList<>();
        final Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        final PackageManager packageManager = getPackageManager();
        final List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for(ResolveInfo res : listCam) {
            final String packageName = res.activityInfo.packageName;
            final Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(packageName);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            cameraIntents.add(intent);
        }

        // Filesystem.
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        // Chooser of filesystem options.
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Select Source");

        // Add the camera options.
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toArray(new Parcelable[cameraIntents.size()]));

        startActivityForResult(chooserIntent, SELECT_PICTURE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE_REQUEST_CODE) {
                final boolean isCamera;
                if (data == null) {
                    isCamera = true;
                } else {
                    final String action = data.getAction();
                    if (action == null) {
                        isCamera = false;
                    } else {
                        isCamera = action.equals(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    }
                }

                Uri selectedImageUri;
                if (isCamera) {
                    selectedImageUri = outputFileUri;
                } else {
                    selectedImageUri = data == null ? null : data.getData();
                }
            }
            mPhoto.setImageURI(selectedImageUri);
        }

    } */

    private void logoAnimation() {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_top);
        animation.setFillAfter(true);
        mLogo.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ViewPagerAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.viewpager_up);
                mLinearAnimLayout.setVisibility(View.VISIBLE);
                ViewPagerAnimation.setFillAfter(true);
                mLinearAnimLayout.setAnimation(ViewPagerAnimation);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    @Override
    public void onBackPressed() {
     //   super.onBackPressed();

     //   mViewPager.setCurrentItem(0,true);

        int position= mViewPager.getCurrentItem();

        if (position==1){
            mViewPager.setCurrentItem(0,true);
        }

        else {

            super.onBackPressed();
        }
    }
}
