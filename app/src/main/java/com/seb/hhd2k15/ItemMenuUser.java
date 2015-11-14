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

    private static void creationDeToutLesItems(ArrayList<ItemMenuUser> LIST, Context c) {
        // Modifier Mon Compte
        ItemMenuUser ModifierMonCompte = new ItemMenuUser("Mon compte", "Visualisez et modifier les différentes informations lié a votre compte utilisateur.", c.getResources().getDrawable(R.drawable.modifier_compte_user_icon));
        LIST.add(ModifierMonCompte);
        ItemMenuUser ModifierMesPreferances = new ItemMenuUser("Préférences", "Selectionez vos préférences de notifications.", c.getResources().getDrawable(R.drawable.hearts));
        LIST.add(ModifierMesPreferances);
        ItemMenuUser Help = new ItemMenuUser("Aide et support", "FAQ, support technique et plus.", c.getResources().getDrawable(R.drawable.questions));
        LIST.add(Help);
        ItemMenuUser Feedback = new ItemMenuUser("Feedback", "Remontez nous vos retours d'expérience afin d'améliorer Instinct.", c.getResources().getDrawable(R.drawable.feedback));
        LIST.add(Feedback);
        ItemMenuUser Logout= new ItemMenuUser("Deconnexion", "Si vous souhaitez nous quitter quelques temps....", c.getResources().getDrawable(R.drawable.logout));
        LIST.add(Logout);
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

    public static ArrayList<ItemMenuUser> getItemMenuUserList(Context context) {
        ArrayList<ItemMenuUser> imu = new ArrayList<ItemMenuUser>();
        creationDeToutLesItems(imu, context);
        return imu;
    }
}
