package com.seb.hhd2k15;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seb.hhd2k15.metier.MenuItem;

import java.util.List;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class MenuItemAdaptator extends ArrayAdapter<MenuItem> {
    private Context context;

    public MenuItemAdaptator(Context context, List<MenuItem> listMenu) {
        super(context, -1, listMenu);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.menu1_layout, null);
        }
        else{
            view = convertView;
        }

        MenuItem t = getItem(position);

        TextView titre = (TextView)view.findViewById(R.id.MenuName);
        ImageView iv = (ImageView)view.findViewById(R.id.MenuIcon);

        iv.setImageDrawable(t.getIcon());

        titre.setText(t.getName());


        return view;
    }
}
