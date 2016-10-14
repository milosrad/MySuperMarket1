package com.example.user.mysupermarket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.user.mysupermarket.adapter.ExpListAdapter;
import com.example.user.mysupermarket.R;
import com.example.user.mysupermarket.custom_component.TextViewFont;
import com.example.user.mysupermarket.data.Constant;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.DataCategory;
import com.example.user.mysupermarket.data.response.DataHomeProducts;
import com.example.user.mysupermarket.data.response.ResponseProductSearch;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;

import java.util.ArrayList;

/**
 * Created by User on 2.10.2016.
 */
public class SettingsActivity extends MessageActivity {


    private TextViewFont mNotifications;
    private TextViewFont mTermsOfUse;
    private TextViewFont mProfile;
    private TextViewFont mSignOut;
    private TextViewFont mNSupport;

    private ImageView mIconTermsOfUse;
    private ImageView mIconProfile;
    private ImageView mIconSignOut;
    private ImageView mIconSupport;



    private ImageView mIconMenu;

    private SwitchCompat mSwitchCompatNotifications;

    private ImageView mImageViewUSerDrawer;
    private TextViewFont mTextViewUserNameDrawer;
    private TextViewFont mTextViewEmailDrawer;

    private static final String REQUEST_TAG ="Settings_activity" ;
  //  private RecyclerView mRecyclerView;
  //  private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mDraverLayout;

    private GsonRequest<ResponseProductSearch> mResponseProduct2;
    private GsonRequest<ResponseProductSearch>mResponseProduct3;
    ArrayList<DataHomeProducts> mProductList=new ArrayList<>();
    ArrayList<DataCategory>mCategoryList=new ArrayList<>();

    //  ExtendableListAdapter listAdapter;
    ExpListAdapter listAdapter;
    ExpandableListView expListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initComponents();
        addListeners();
    }


    private void initComponents(){

        mNotifications=(TextViewFont)findViewById(R.id.settings_notifications);
        mTermsOfUse=(TextViewFont)findViewById(R.id.settings_termsofuse);
        mProfile=(TextViewFont)findViewById(R.id.settings_profile);
        mSignOut=(TextViewFont)findViewById(R.id.settings_sign_out);
        mNSupport=(TextViewFont)findViewById(R.id.settings_support);

        mSwitchCompatNotifications=(SwitchCompat)findViewById(R.id.settings_notifications_switch);

        mSwitchCompatNotifications.setTextColor(getResources().getColor(R.color.colorYellowLogin));

        mIconTermsOfUse=(ImageView)findViewById(R.id.settings_termsofuse_image);
        mIconProfile=(ImageView)findViewById(R.id.settings_profile_image);
        mIconSignOut=(ImageView)findViewById(R.id.settings_signout_image);
        mIconSupport=(ImageView)findViewById(R.id.settings_support_image);

        mIconMenu=(ImageView)findViewById(R.id.setingsiconmenu);


      //  mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mDraverLayout=(DrawerLayout)findViewById(R.id.my_drawer_layout);


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
            public void onClick(View view) {

                mDraverLayout.openDrawer(Gravity.LEFT);

            }
        });

        mIconTermsOfUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),TermsOfUseActivity.class));

            }
        });

        mIconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

            }
        });

        mIconSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mIconSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
}
