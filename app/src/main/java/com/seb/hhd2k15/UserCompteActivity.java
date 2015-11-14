package com.seb.hhd2k15;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<ItemMenuUser> Item_Menu_User_List = ItemMenuUser.getItemMenuUserList(this);
        UserCompteAdaptator userCompteAdaptator = new UserCompteAdaptator(this, Item_Menu_User_List);
        list.setAdapter(userCompteAdaptator);
    }
}
