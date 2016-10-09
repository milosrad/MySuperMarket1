package com.example.user.mysupermarket;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.user.mysupermarket.data.Constant;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.DataCategory;
import com.example.user.mysupermarket.data.response.DataHomeProducts;
import com.example.user.mysupermarket.data.response.ResponseEditProfile;
import com.example.user.mysupermarket.data.response.ResponseProductSearch;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;

import java.util.ArrayList;

/**
 * Created by User on 2.10.2016.
 */
public class ProfileActivity extends MessageActivity {

    private EditTextFont mUserName;
    private EditTextFont mEmail;
    private EditTextFont mPassword;
    private EditTextFont mBirthDate;

    private ImageView mProfileImage;

    private ImageView mIconMenu;
    private ImageView mIconCamera;



    private LoginButton mChangeProfileButton;


    private ImageView mImageViewUSerDrawer;
    private TextViewFont mTextViewUserNameDrawer;
    private TextViewFont mTextViewEmailDrawer;

    private static final String REQUEST_TAG ="Profiles_activity" ;
    //  private RecyclerView mRecyclerView;
    //  private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mDraverLayout;

    private GsonRequest<ResponseProductSearch> mResponseProduct2;
    private GsonRequest<ResponseProductSearch>mResponseProduct3;

    private GsonRequest<ResponseEditProfile>mRequestEditProfile;


    ArrayList<DataHomeProducts> mProductList=new ArrayList<>();
    ArrayList<DataCategory>mCategoryList=new ArrayList<>();

    //  ExtendableListAdapter listAdapter;
    ExpListAdapter listAdapter;
    ExpandableListView expListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initComponents();
        addListeners();
    }



    private void initComponents(){


        mUserName=(EditTextFont)findViewById(R.id.profile_username);
        mEmail=(EditTextFont)findViewById(R.id.profile_email);
        mPassword=(EditTextFont)findViewById(R.id.profile_password);
        mBirthDate=(EditTextFont)findViewById(R.id.profile_birthday);

        mProfileImage=(ImageView)findViewById(R.id.profileimage);
        mIconMenu=(ImageView)findViewById(R.id.profileiconmenu);
        mIconCamera=(ImageView)findViewById(R.id.profileiconcamera);


        mChangeProfileButton=(LoginButton)findViewById(R.id.changeprofilebutton);


        mDraverLayout=(DrawerLayout)findViewById(R.id.profile_drawer_layout);


        mImageViewUSerDrawer=(ImageView)findViewById(R.id.imageViewUserPicture);
        mTextViewEmailDrawer=(TextViewFont) findViewById(R.id.userEmail);
        mTextViewEmailDrawer.setText("milos.radonjic@yahoo.com");
        mTextViewUserNameDrawer=(TextViewFont) findViewById(R.id.textViewUserName);
        mTextViewUserNameDrawer.setText("Milos Radonjic");


        mProductList.addAll(DataContainer.homeProducts);
        if(mProductList.size()==0){
            //   mRelLayWarning.setVisibility(View.VISIBLE);
        }
        else{
            //   mRelLayWarning.setVisibility(View.GONE);
        }


        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
       /* mAdapter = new RecyclerViewAdapter(getApplicationContext(), mProductList, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(DataHomeProducts item) {
            }
        }); */

        //  mAdapter= new RecyclerViewAdapter(getApplicationContext());

        expListView = (ExpandableListView) findViewById(R.id.extendibleListView);

        // preparing list data
        DataCategory home=new DataCategory();
        home.name="Home";
        mCategoryList.add(home);
        home.subcategories=new ArrayList<>();

        mCategoryList.addAll(DataContainer.categories);

        DataCategory settings=new DataCategory();
        settings.name="Settings";
        settings.subcategories=new ArrayList<>();
        mCategoryList.add(settings);
        DataCategory profil=new DataCategory();
        profil.name="Profile";
        profil.subcategories=new ArrayList<>();
        mCategoryList.add(profil);
        DataCategory signout=new DataCategory();
        signout.name="Sign Out";
        signout.subcategories=new ArrayList<>();
        mCategoryList.add(signout);

        //    listAdapter = new ExtendableListAdapter(this, mCategoryList);
        listAdapter = new ExpListAdapter(this, mCategoryList);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        //   mRecyclerView.setLayoutManager(mLayoutManager);
        //   mRecyclerView.setAdapter(mAdapter);



    }


    private void addListeners(){


        mIconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDraverLayout.openDrawer(Gravity.LEFT);

            }
        });


        mIconCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takepicture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takepicture,0);

                Intent pickphoto=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickphoto,1);

            }
        });


        mChangeProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRequestEditProfile= new GsonRequest<ResponseEditProfile>(Constant.EDIT_PROFILE_URL + "?token=" + DataContainer.TOKEN + "?login_token=" + DataContainer.LOGIN_TOKEN + "?username=" + mUserName.getText().toString() + "?email=" + mEmail.getText().toString() + "?birthday=" + mBirthDate.getText().toString(), Request.Method.GET, ResponseEditProfile.class, new Response.Listener<ResponseEditProfile>() {
                    @Override
                    public void onResponse(ResponseEditProfile response) {

                        DataContainer.profiledata=response.data.results;

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                    }
                });

                DataLoader.addRequest(getApplicationContext(),mRequestEditProfile,REQUEST_TAG);

            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            // Listview on child click listener
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        final int groupPosition, int childPosition, long id) {
                mDraverLayout.closeDrawer(GravityCompat.START);
                mProductList.clear();
                //      mAdapter.notifyDataSetChanged();
                //   mPbLoading.setVisibility(View.VISIBLE);
                mResponseProduct3 = new GsonRequest<ResponseProductSearch>(Constant.HOME_PAGE_PRODUCT_URL + "?token="
                        + DataContainer.TOKEN + "&search=1&mlimit=100&category=" + mCategoryList.get(groupPosition).subcategories.get(childPosition).id,
                        Request.Method.GET, ResponseProductSearch.class,
                        new Response.Listener<ResponseProductSearch>() {

                            @Override
                            public void onResponse(ResponseProductSearch response) {
                                mProductList.addAll(response.data.results);
                                //       mPbLoading.setVisibility(View.GONE);
                                //        mAdapter.notifyDataSetChanged();
                                if (mProductList.size() == 0) {
                                    //           mRelLayWarning.setVisibility(View.VISIBLE);
                                } else {
                                    //          mRelLayWarning.setVisibility(View.GONE);
                                }
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "greska", Toast.LENGTH_SHORT).show();
                    }
                });
                DataLoader.addRequest(getApplicationContext(), mResponseProduct3, REQUEST_TAG);

                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                if (i == 0) {
                    mDraverLayout.closeDrawer(GravityCompat.START);
                } else if (i == mCategoryList.size() - 2) {

                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                } else if (i == mCategoryList.size() - 3) {

                    startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                } else {
                    if (mCategoryList.get(i).subcategories.size() == 0) {
                        mDraverLayout.closeDrawer(GravityCompat.START);
                        mProductList.clear();
                        //    mAdapter.notifyDataSetChanged();
                        //    mPbLoading.setVisibility(View.VISIBLE);
                        mResponseProduct2 = new GsonRequest<ResponseProductSearch>(Constant.HOME_PAGE_PRODUCT_URL + "?token="
                                + DataContainer.TOKEN + "&search=1&mlimit=100&category=" + mCategoryList.get(i).id, Request.Method.GET, ResponseProductSearch.class,
                                new Response.Listener<ResponseProductSearch>() {
                                    @Override
                                    public void onResponse(ResponseProductSearch response) {
                                        mProductList.addAll(response.data.results);
                                        //           mPbLoading.setVisibility(View.GONE);
                                        //       mAdapter.notifyDataSetChanged();
                                        if (mProductList.size() == 0) {
                                            //            mRelLayWarning.setVisibility(View.VISIBLE);
                                        } else {
                                            //           mRelLayWarning.setVisibility(View.GONE);
                                        }
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "greska", Toast.LENGTH_SHORT).show();
                            }
                        });

                        DataLoader.addRequest(getApplicationContext(), mResponseProduct2, REQUEST_TAG);
                    }
                }


                return false;
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
                    Glide.with(getApplicationContext()).load(selectedImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(mProfileImage){

                        @Override
                        protected void setResource(Bitmap resource) {

                            RoundedBitmapDrawable circularBitmapDrawable= RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(),resource);
                            circularBitmapDrawable.setCircular(true);
                            mProfileImage.setImageDrawable(circularBitmapDrawable);
                        }
                    });
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                  /*  Uri selectedImage = imageReturnedIntent.getData();
                    mPhoto.setImageURI(selectedImage); */

                    Uri selectedImage=imageReturnedIntent.getData();
                    Glide.with(getApplicationContext()).load(selectedImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(mProfileImage){

                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable= RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(),resource);
                            circularBitmapDrawable.setCircular(true);
                            mProfileImage.setImageDrawable(circularBitmapDrawable);
                        }
                    });


                }
                break;
        }
    }
}
