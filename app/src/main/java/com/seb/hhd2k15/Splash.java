package com.seb.hhd2k15;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.seb.hhd2k15.Location.Locator;

import com.seb.hhd2k15.Database.ItemDatabase.TagDB;
import com.seb.hhd2k15.Database.sqlite;

/**
 * Created by Elie on 14/11/2015.
 */
public class Splash extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        /*

        sqlite db = new sqlite(this.getBaseContext());
        try{
            SQLiteDatabase database = db.getWritableDatabase();
            db.onCreate(database);
            TagDB t = new TagDB(1,"Test",1);
            Log.d(null, t.toString());
                //Cursor c = database.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

                //if (c.moveToFirst()) {
                //    while ( !c.isAfterLast() ) {
                //        Log.d(null, "Table Name=> " + c.getString(0));
                 //       c.moveToNext();
                //    }
                //
                }
                
            db.ListTagDB(database);
           db.updateUserTag(database,t);
            db.ListTagDB(database);
            Log.d(null, "Une connexion la DB c'est bien produite");
        }
        catch (Exception except){
            Log.d(null, "Une erreur s'est produite avec la BDD SQL");
            Log.d(null,"\n"+except.toString());
        }

    */
        int secondsDelayed = 1;
        new android.os.Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, UserCompteActivity.class));
                finish();
            }
        }, secondsDelayed * 2000);
    }


}
