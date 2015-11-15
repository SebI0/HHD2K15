package com.seb.hhd2k15;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    ListView listDrawer;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        listDrawer = (ListView)findViewById(R.id.navList);


        listDrawer.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(MainActivity.this, TestMap.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

        CustomFont();
    }

    public void CustomFont(){
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/font.ttf");
        TextView t1 = (TextView) findViewById(R.id.Hello);
        TextView t2 = (TextView) findViewById(R.id.stats);
        t1.setTypeface(font);
        t2.setTypeface(font);

        t1.setText("Bonjour Nico385412");
        t2.setText("Vous avez decouvert 5 lieux");


    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<com.seb.hhd2k15.metier.MenuItem> list_t = com.seb.hhd2k15.metier.MenuItem.getItemMenuUserList(this);
        MenuItemAdaptator lieuAdaptator = new MenuItemAdaptator(this, list_t);
        listDrawer.setAdapter(lieuAdaptator);
    }
}
