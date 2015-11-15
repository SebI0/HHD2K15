package com.seb.hhd2k15;

/**
 * Created by Sébastien on 14/11/2015.
 */
public class poi {

    private String title;
    private double lng;
    private double lat;

    public poi(String title, double lat, double lng) {
        this.title = title;
        this.lng = lng;
        this.lat = lat;
    }

    public String getTitle() {
        return title;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }
}
