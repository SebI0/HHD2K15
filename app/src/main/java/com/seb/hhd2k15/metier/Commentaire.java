package com.seb.hhd2k15.metier;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.seb.hhd2k15.R;

import java.util.ArrayList;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class Commentaire {
    private Drawable RefdrawableUserIcon;
    private String Nom ;
    private String Com;


    public Commentaire() {
    }

    public Commentaire(Drawable refdrawableUserIcon, String nom, String com) {
        RefdrawableUserIcon = refdrawableUserIcon;
        Nom = nom;
        Com = com;
    }

    public Drawable getRefdrawableUserIcon() {
        return RefdrawableUserIcon;
    }

    public void setRefdrawableUserIcon(Drawable refdrawableUserIcon) {
        RefdrawableUserIcon = refdrawableUserIcon;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCom() {
        return Com;
    }

    public void setCom(String com) {
        Com = com;
    }

    public static ArrayList<Commentaire> getListTag(Context c){
        ArrayList<Commentaire> list = new ArrayList<Commentaire>();
        // C'est ici que les commentaires peuvent être ajouté
        list.add(new Commentaire(c.getResources().getDrawable(R.drawable.anonymous_user_icon), "JUST AMAZING", "j'adore !!! a refaire !"));
        list.add(new Commentaire(c.getResources().getDrawable(R.drawable.anonymous_user_icon), "JUST AMAZING", "j'adore !!! a refaire !"));
        list.add(new Commentaire(c.getResources().getDrawable(R.drawable.anonymous_user_icon), "JUST AMAZING", "j'adore !!! a refaire !"));
        list.add(new Commentaire(c.getResources().getDrawable(R.drawable.anonymous_user_icon), "JUST AMAZING", "j'adore !!! a refaire !"));

        return list;
    }


}
