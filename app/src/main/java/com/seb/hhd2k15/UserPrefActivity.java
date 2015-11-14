package com.seb.hhd2k15;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Nicolas on 14/11/2015.
 */
public class UserPrefActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

    }



    public void close(View v){
        this.finish();
    }


}
