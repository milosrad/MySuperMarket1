package com.example.user.mysupermarket.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.mysupermarket.R;
import com.example.user.mysupermarket.data.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 29.9.2016.
 */
public class NavigationActivityExp extends MessageActivity {

    private DrawerLayout mDlMenu;
    private ExpandableListView mLVNavigation;
    private ImageView mIconMenu;
    private ExpandableListAdapter mAdapter;

    private HashMap<String, List<String>> listDataChild;


    private List<String> listDataHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        prepareListData();

        initComponents();
        addListeners();
    }

    private void initComponents(){

        mDlMenu=(DrawerLayout)findViewById(R.id.drawer_layout);
        mLVNavigation=(ExpandableListView)findViewById(R.id.expListViewNavigation);
        mIconMenu=(ImageView)findViewById(R.id.navigationiconmenu);

        mAdapter= new com.example.user.mysupermarket.adapter.ExpandableListAdapter(getApplicationContext(),listDataChild,listDataHeader);
        mLVNavigation.setAdapter(mAdapter);
    }

    private void addListeners(){


        mIconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDlMenu.openDrawer(mLVNavigation);

            }
        });


        mLVNavigation.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });


        mLVNavigation.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        " Group Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });


        mLVNavigation.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                Toast.makeText(getApplicationContext(),
                        " Group Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        mLVNavigation.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(getApplicationContext(),
                        " Group Collapsed",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }



    private void prepareListData(){


      /*  listDataHeader= DataContainer.categories;


        listDataChild= new HashMap<String, ArrayList<DataCategory>>(); */


        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();


        for (int i = 0; i< DataContainer.categories.size(); i++) {


            listDataHeader.add(DataContainer.categories.get(i).name);

        }


        for (int j=0; j<DataContainer.categories.size();j++){


            List<String> pom=new ArrayList<String>();

            for (int k=0; k<DataContainer.categories.get(j).subcategories.size(); k++){

                pom.add(k,DataContainer.categories.get(j).subcategories.get(k).name);
            }

            listDataChild.put(DataContainer.categories.get(j).name,pom);


        }








    }
}
