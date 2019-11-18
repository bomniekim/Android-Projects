package com.bomnie.ex045fragmentpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Page3ListAdapter extends BaseAdapter {

    ArrayList<String> data;
    Context context;

    public Page3ListAdapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //LayoutInflater 를 소환하기
        LayoutInflater inflater= LayoutInflater.from(context);

        //1. new view
        if(view==null){
            view= inflater.inflate(R.layout.page3_listview_item, viewGroup, false);
        }

        //2. bind view
        TextView tv= view.findViewById(R.id.tv);
        tv.setText( data.get(position) );

        return view;
    }
}
