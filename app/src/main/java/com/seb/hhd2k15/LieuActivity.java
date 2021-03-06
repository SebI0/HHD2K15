package com.seb.hhd2k15;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seb.hhd2k15.R;
import com.seb.hhd2k15.ScreenSlidePageFragment;
import com.seb.hhd2k15.metier.Commentaire;
import com.seb.hhd2k15.metier.CommentaireAdaptator;

import java.util.ArrayList;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class LieuActivity extends FragmentActivity {


    private static final int NUM_PAGES = 3;
    final String NAME_LIEU = "name_lieu";
    final String IMG_1 = "image_lieu";
    final String IMG_2 = "image_lieu_2";
    final String IMG_3 = "image_lieu_3";

    private ViewPager mPager;

    private PagerAdapter mPagerAdapter;

    private LinearLayout carousel;
    private ListView list;
    private ListView listc;
    private RelativeLayout RL;

    private TextView lieu_name;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_lieu);
        list = (ListView) findViewById(R.id.List_Tag);
        listc = (ListView) findViewById(R.id.list_Item_Commentaires);
        RL = (RelativeLayout) findViewById(R.id.Layout_Tag);
        mPager = (ViewPager) findViewById(R.id.pagers);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        lieu_name = (TextView)findViewById(R.id.lieu_name);

         intent = getIntent();

        lieu_name.setText(intent.getStringExtra(NAME_LIEU));
        //listc.addHeaderView(RL);
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return ScreenSlidePageFragment.newInstance(intent.getIntExtra(IMG_1, 0));
            }
                if(position == 1)
                    return ScreenSlidePageFragment.newInstance(intent.getIntExtra(IMG_2, 0));
            else
                    return ScreenSlidePageFragment.newInstance(intent.getIntExtra(IMG_3, 0));
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Tag> list_t =Tag.getListTag();
        LieuAdaptator lieuAdaptator = new LieuAdaptator(this, list_t);
        list.setAdapter(lieuAdaptator);

        ArrayList<Commentaire> list_c = Commentaire.getListTag(this);
        CommentaireAdaptator commentaireAdaptator = new CommentaireAdaptator((this), list_c);
        listc.setAdapter(commentaireAdaptator);
    }
}
