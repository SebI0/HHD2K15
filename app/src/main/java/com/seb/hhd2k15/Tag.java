package com.seb.hhd2k15;

import java.util.ArrayList;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class Tag {
    private String Nom;

    public Tag() {
    }

    public Tag(String nom) {
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public static ArrayList<Tag> getListTag(){
        ArrayList<Tag> list = new ArrayList<Tag>();
        // C'est ici que les tag peuvent être ajouté
        list.add(new Tag("#Point de vue"));
        list.add(new Tag("#Romantique"));
        list.add(new Tag("#Photographique"));
        list.add(new Tag("#Culturel"));
        list.add(new Tag("#Insolite"));
        list.add(new Tag("#Marchants locaux"));
        list.add(new Tag("#Événément"));


        return list;
    }
}
