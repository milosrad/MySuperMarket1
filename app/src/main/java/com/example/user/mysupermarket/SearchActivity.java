package com.example.user.mysupermarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.user.mysupermarket.data.Constant;
import com.example.user.mysupermarket.data.DataContainer;
import com.example.user.mysupermarket.data.response.DataCategory;
import com.example.user.mysupermarket.data.response.DataHomeProducts;
import com.example.user.mysupermarket.data.response.ResponseProductSearch;
import com.example.user.mysupermarket.networking.DataLoader;
import com.example.user.mysupermarket.networking.GsonRequest;

import java.util.ArrayList;

/**
 * Created by User on 11.10.2016.
 */
public class SearchActivity extends MessageActivity {

    private final String REQUEST_TAG="Search_Activity";


    private RecyclerView mRecyclerViewSearch;

    private RecyclerViewAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    private RelativeLayout mSearchLayout;

    private ImageView mSearchStatus;

    private ImageView mSearchBackSpace;

    private ImageView mIconMenu;

    private ProgressBar spinner;

    private EditTextFont mSearchParam;

    BaseInputConnection textFieldInputConnection;

    private GsonRequest<ResponseProductSearch> mResponseProducts;


    private ArrayList<DataHomeProducts> productsList= new ArrayList<>();


    private ImageView mImageViewUSerDrawer;
    private TextViewFont mTextViewUserNameDrawer;
    private TextViewFont mTextViewEmailDrawer;


  //  private RecyclerView.LayoutManager mLayoutManager;
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
        setContentView(R.layout.activity_search);

        initComponents();

        addListeners();


    }


    private void initComponents(){

        mSearchLayout=(RelativeLayout)findViewById(R.id.search_relativelayout);

        mSearchStatus=(ImageView)findViewById(R.id.searchstatusimageView);

        mSearchBackSpace=(ImageView)findViewById(R.id.searchbackspaceimageView);

        mIconMenu=(ImageView)findViewById(R.id.searchhomeiconmenu);

        spinner=(ProgressBar)findViewById(R.id.searchprogressbar);

        mSearchParam=(EditTextFont)findViewById(R.id.editTextSearchParam);


        mRecyclerViewSearch=(RecyclerView)findViewById(R.id.search_recycler_view_home);

        mLayoutManager=new GridLayoutManager(getApplicationContext(),2);

        mRecyclerViewSearch.setLayoutManager(mLayoutManager);

        mAdapter=new RecyclerViewAdapter(getApplicationContext());

        mRecyclerViewSearch.setAdapter(mAdapter);

        textFieldInputConnection = new BaseInputConnection(mSearchParam, true);


        mDraverLayout=(DrawerLayout)findViewById(R.id.my_drawer_layout);

        mImageViewUSerDrawer=(ImageView)findViewById(R.id.imageViewUserPicture);
        mTextViewEmailDrawer=(TextViewFont) findViewById(R.id.userEmail);
        mTextViewEmailDrawer.setText("milos.radonjic@yahoo.com");
        mTextViewUserNameDrawer=(TextViewFont) findViewById(R.id.textViewUserName);
        mTextViewUserNameDrawer.setText("Milos Radonjic");


        mProductList.addAll(DataContainer.homeProducts);

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


        mSearchStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


     /*   mSearchParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    search();






            }
        });  */


        mSearchParam.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() >= 3 ) {

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    mSearchStatus.setVisibility(View.GONE);

                    spinner.setVisibility(View.VISIBLE);


                    mResponseProducts = new GsonRequest<ResponseProductSearch>(Constant.HOME_PAGE_PRODUCT_URL + "?token="
                            + DataContainer.TOKEN + "&search=1&mlimit=100&start=0&term=" + s.toString(),
                            Request.Method.GET, ResponseProductSearch.class,
                            new Response.Listener<ResponseProductSearch>() {

                                @Override
                                public void onResponse(ResponseProductSearch response) {
                                    productsList.addAll(response.data.results);
                                    spinner.setVisibility(View.GONE);
                                    mSearchParam.setVisibility(View.VISIBLE);
                                    mAdapter.notifyDataSetChanged();
                                    if (productsList.size() == 0) {
                                        mSearchLayout.setVisibility(View.GONE);
                                    } else {
                                        mSearchLayout.setVisibility(View.VISIBLE);

                                    }
                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    DataLoader.addRequest(getApplicationContext(), mResponseProducts, REQUEST_TAG);






                }

                else if (s.length()<3){

                    mSearchLayout.setVisibility(View.GONE);
                    spinner.setVisibility(View.GONE);
                    mSearchStatus.setVisibility(View.VISIBLE);

                }

                else if (s.length()==0 )
                {

                    mSearchStatus.setVisibility(View.VISIBLE);

                    spinner.setVisibility(View.GONE);

                    mSearchLayout.setVisibility(View.GONE);
                }





            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });


        mSearchBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
            }
        });


        mIconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDraverLayout.openDrawer(Gravity.LEFT);
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


    public void search() {



        if (mSearchParam.getText().length() >= 3 ) {


            mSearchStatus.setVisibility(View.GONE);

            spinner.setVisibility(View.VISIBLE);


            mResponseProducts = new GsonRequest<ResponseProductSearch>(Constant.HOME_PAGE_PRODUCT_URL + "?token="
                    + DataContainer.TOKEN + "&search=1&mlimit=100&start=0&term=" + mSearchParam.toString(),
                    Request.Method.GET, ResponseProductSearch.class,
                    new Response.Listener<ResponseProductSearch>() {


                        @Override
                        public void onResponse(ResponseProductSearch response) {
                            productsList.addAll(response.data.results);
                            spinner.setVisibility(View.GONE);
                            mSearchParam.setVisibility(View.VISIBLE);
                            mAdapter.notifyDataSetChanged();
                            if (productsList.size() == 0) {
                                mSearchLayout.setVisibility(View.GONE);
                            } else {
                                mSearchLayout.setVisibility(View.VISIBLE);

                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            DataLoader.addRequest(getApplicationContext(), mResponseProducts, REQUEST_TAG);






        }

        else if (mSearchParam.length()<3){

            mSearchLayout.setVisibility(View.GONE);
            spinner.setVisibility(View.GONE);
            mSearchStatus.setVisibility(View.VISIBLE);

        }

        else if (mSearchParam.length()==0 )
        {

            mSearchStatus.setVisibility(View.VISIBLE);

            spinner.setVisibility(View.GONE);

            mSearchLayout.setVisibility(View.GONE);
        }




















    }
}
