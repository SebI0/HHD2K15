package com.seb.hhd2k15.metier;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seb.hhd2k15.R;

import java.util.List;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class CommentaireAdaptator extends ArrayAdapter<Commentaire>{
    private Context context;

    public CommentaireAdaptator(Context context, List<Commentaire> listCom) {
        super(context, -1, listCom);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View view;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.itemlist_commentaire, null);
        }
        else{
            view = convertView;
        }
        Commentaire commentaire = getItem(position);

        TextView Nom = (TextView)view.findViewById(R.id.Nom_commentaire);
        TextView Descritpion = (TextView)view.findViewById(R.id.Description_commentaire);
        ImageView Icon = (ImageView)view.findViewById(R.id.userIcon_commentaire);

        Nom.setText(commentaire.getNom());
        Descritpion.setText(commentaire.getCom());
        Icon.setImageDrawable(commentaire.getRefdrawableUserIcon());

        return view;
    }
}
