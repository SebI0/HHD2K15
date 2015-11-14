package com.seb.hhd2k15.metier;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.seb.hhd2k15.NetworkSingleton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sébastien on 14/11/2015.
 */
public class Api {
    public static void createUser(String email, String login, String password, Context c) {
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
                            if (feedback == "success") {

                            } else {

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        NetworkSingleton.getInstance(c).addToRequestQueue(jsObjRequest);
    }

    public static void getPoi(Context c) {
        String url = "https://data.ozwillo-preprod.eu:443/dc/type/hackartisme:geoService_0?start=0&limit=10";
        String p = "&hackartisme:latitude=>50.510000&hackartisme:latitude=<50.519000&hackartisme:longitude=>1.592700&hackartisme:longitude<1.593200";

        url = url + p;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.e("RES", response.toString());


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("Authorization",  "Bearer eyJpZCI6ImJhNTExYzdiLTk5MDUtNDQwNy1iMjg4LTEwNTI2MDRjNjE4MC9SejJPTlFVTWhVY29tcFFCX2Q5bERRIiwiaWF0IjoxNDQ3MzQyODgxOTM5LCJleHAiOjE0NDc2NzE2MDAwMDB9Cg");
                return params;
            }
        };
        NetworkSingleton.getInstance(c).addToRequestQueue(jsObjRequest);
    }



}
