package com.seb.hhd2k15;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.seb.hhd2k15.Location.Locator;

import com.seb.hhd2k15.Database.ItemDatabase.TagDB;
import com.seb.hhd2k15.Database.sqlite;

/**
 * Created by Elie on 14/11/2015.
 */
public class Splash extends Activity {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainActivity";

    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#a9764b"));
        }


        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {
                    Log.i(TAG, "Got token: ");
                } else {
                    Log.i(TAG, "Pas token: ");
                }
            }
        };

        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }


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
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 2000);
    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }



}
