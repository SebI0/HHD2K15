package com.seb.hhd2k15;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by Nicolas on 13/11/2015.
 */
public class ItemMenuUser {
    private String Name;
    private String Description;
    private Drawable icon;
    private ArrayList<ItemMenuUser> list = null;
    private static Context context;

    public ItemMenuUser() {
    }

    public ItemMenuUser(Context context) {
        this.context = context;
    }

    private ItemMenuUser(String name, String description, Drawable icon) {
        Name = name;
        Description = description;
        this.icon = icon;
    }

    private static void creationDeToutLesItems(ArrayList<ItemMenuUser> LIST, Context c){
        // Modifier Mon Compte
            ItemMenuUser ModifierMonCompte = new ItemMenuUser("Modifier Mon Compte", "Ceci est la description du bouton", c.getResources().getDrawable(R.drawable.modifier_compte_user_icon));
            LIST.add(ModifierMonCompte);
            ItemMenuUser ModifierMesPreferances = new ItemMenuUser("Modifier Mes Pref", "Ceci est la description du bouton", c.getResources().getDrawable(R.drawable.modifier_pref_user_icon));
            LIST.add(ModifierMesPreferances);
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

    public static ArrayList<ItemMenuUser> getItemMenuUserList(Context context){
        ArrayList<ItemMenuUser> imu = new ArrayList<ItemMenuUser>();
        creationDeToutLesItems(imu, context);
        return imu;
    }
}
