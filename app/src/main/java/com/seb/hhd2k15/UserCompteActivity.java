package com.seb.hhd2k15;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.seb.hhd2k15.metier.User;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

                createUser();
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

    public void createUser()
    {
        String url = "http://www.mycitizen-app.com/web/hhd/user";

        Map<String, String> params = new HashMap<String, String>();
        params.put("email", "elie.alawoe@outlook.com");
        params.put("login", "Elie");
        params.put("password", "ig2i");

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("RES", response.toString());
                            String feedback = response.getString("feedback");
                            if (feedback == "success")
                            {

                            }else{

                            }

                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }

                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/json");
                return params;
            }
        };
        NetworkSingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }
}
