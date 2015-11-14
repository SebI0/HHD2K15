package com.seb.hhd2k15;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Nicolas on 13/11/2015.
 */
public class UserCompteAdaptator extends ArrayAdapter<ItemMenuUser> {


    Context context;

    public UserCompteAdaptator(Context context, List<ItemMenuUser> objects) {
        super(context, -1, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View view = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.itemlist_userprofile, null);
        } else
            view = convertView;

        ItemMenuUser imu = getItem(position);

        TextView Titre = (TextView) view.findViewById(R.id.Name_Item);
        TextView Description = (TextView) view.findViewById(R.id.Description_Item);
        ImageView Icon = (ImageView) view.findViewById(R.id.userIcon);

        Titre.setText(imu.getName());
        Description.setText(imu.getDescription());
        Icon.setImageDrawable(imu.getIcon());

        return view;
    }
}
