package com.seb.hhd2k15;

import android.graphics.drawable.Drawable;

/**
 * Created by Nicolas on 13/11/2015.
 */
public class ItemMenuUser {
    private String Name;
    private String Description;
    private Drawable icon;

    public ItemMenuUser() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
