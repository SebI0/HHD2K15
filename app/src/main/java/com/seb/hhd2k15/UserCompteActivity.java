package com.seb.hhd2k15;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Nicolas on 13/11/2015.
 */
public class UserCompteActivity extends ArrayAdapter<ItemMenuUser>{

    public UserCompteActivity(Context context, List<ItemMenuUser> objects) {
        super(context, -1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View view;
        if(convertView != null){
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

    }
}
