package com.seb.hhd2k15.Database.ItemDatabase;

/**
 * Created by Elie on 14/11/2015.
 */
public class TagDB {
    public int id;
    public String label;
    public boolean active;

    public TagDB(int identifiant, String titre, int actif){
        this.id = identifiant;
        this.label = titre;
        if(actif!=0) {
            this.active = true;
        }
        else
            this.active =false;
    }

   @Override
    public String toString(){
       return "\nID: "+this.id+"\nNom: "+this.label+"\nActive: "+active;
   }


}
