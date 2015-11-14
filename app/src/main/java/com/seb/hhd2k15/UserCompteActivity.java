package com.seb.hhd2k15;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.seb.hhd2k15.metier.Api;

import java.util.ArrayList;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class UserCompteActivity extends Activity{

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_userprofile);
        list = (ListView)findViewById(R.id.listView);

        Button b = (Button)findViewById(R.id.curlTest);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //    Api.createUser("po", "po", "po", v.getContext());
                notif();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: //Modifier le compte
                        break;
                    case 1: //Modifier les pantalons
                        break;
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<ItemMenuUser> Item_Menu_User_List = ItemMenuUser.getItemMenuUserList(this);
        UserCompteAdaptator userCompteAdaptator = new UserCompteAdaptator(this, Item_Menu_User_List);
        list.setAdapter(userCompteAdaptator);
    }

    public void notif()
    {
        Intent intent = new Intent(this, NotificationReceiverActivity.class);
// use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.modifier_pref_user_icon)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.modifier_pref_user_icon, "Call", pIntent)
                .addAction(R.drawable.modifier_pref_user_icon, "More", pIntent)
                .addAction(R.drawable.modifier_pref_user_icon, "And more", pIntent).build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }


}
