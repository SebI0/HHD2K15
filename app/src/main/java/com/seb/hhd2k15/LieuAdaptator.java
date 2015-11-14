package com.seb.hhd2k15;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class LieuAdaptator extends ArrayAdapter<Tag> {

    private Context context;

    public LieuAdaptator(Context context, List<Tag> listTag) {
        super(context, -1, listTag);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.itemlist_tags, null);
        }
        else{
            view = convertView;
        }

        Tag t = getItem(position);

        TextView titre = (TextView)view.findViewById(R.id.text_tag);

        titre.setText(t.getNom());

        return view;
    }
}
