package com.seb.hhd2k15;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class ScreenSlidePageFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int RefTotheImage = getArguments().getInt("image");
            ViewGroup rootView = (ViewGroup) inflater.inflate( R.layout.fragment1_layout, container, false);
            ImageView iv = (ImageView)rootView.findViewById(R.id.imageSlider);
            iv.setImageResource(RefTotheImage);
            return rootView;
    }

    public static ScreenSlidePageFragment newInstance(int ReftotheDrawablefile){
        ScreenSlidePageFragment screenSlidePageFragment = new ScreenSlidePageFragment();

        Bundle args = new Bundle();
        args.putInt("image", ReftotheDrawablefile);
        screenSlidePageFragment.setArguments(args);

        return screenSlidePageFragment;
    }
}
