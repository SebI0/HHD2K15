package com.seb.hhd2k15.metier;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.seb.hhd2k15.R;

import java.util.ArrayList;

/**
 * Created by Nicolas on 15/11/2015.
 */
public class MenuItem {
    private Drawable icon;
    private String name;

    public MenuItem() {
    }

    public MenuItem(Drawable icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<MenuItem> getItemMenuUserList(Context context) {
        ArrayList<MenuItem> imu = new ArrayList<MenuItem>();
        creationDeToutLesItems(imu, context);
        return imu;
    }

    private static void creationDeToutLesItems(ArrayList<MenuItem> imu, Context context) {
        imu.add(new MenuItem(context.getResources().getDrawable(R.drawable.world), "Carte"));
    }
}
