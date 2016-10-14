package com.example.user.mysupermarket.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.example.user.mysupermarket.R;
import com.example.user.mysupermarket.custom_component.TextViewFont;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 29.9.2016.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {


    private Context mContext;

    private LayoutInflater mInflater;


  /*  private HashMap<String, ArrayList<DataCategory>> listDataChild;


    private ArrayList<DataCategory> listDataHeader; */

    private HashMap<String, List<String>> listDataChild;


    private List<String> listDataHeader;



    public ExpandableListAdapter(Context mContext,HashMap<String, List<String>> hashMap, List<String> arrayList) {
        this.mContext = mContext;


        this.listDataHeader=arrayList;

        this.listDataChild=hashMap;

        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item_navigation_text, null);
        }

        TextViewFont txtListChild = (TextViewFont) convertView
                .findViewById(R.id.textViewnavigationtext);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition).toString();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item_navigation_icon_text, null);
        }


        // if (groupPosition)

        TextViewFont lblListHeader = (TextViewFont) convertView
                .findViewById(R.id.textViewnavigationtexticon);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
