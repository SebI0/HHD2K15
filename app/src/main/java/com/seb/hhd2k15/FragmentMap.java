package com.seb.hhd2k15 ;  // change to your own package

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.seb.hhd2k15.metier.Api.getPoi;

/**
 * A fragment that launches other parts of the demo application.
 */
public class FragmentMap extends Fragment implements GoogleMap.OnMarkerClickListener {

    MapView mMapView;
    private GoogleMap googleMap;

    final String NAME_LIEU = "name_lieu";
    final String IMG_1 = "image_lieu";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate and return the layout
        View v = inflater.inflate(R.layout.testmap, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        // latitude and longitude
        double latitude = 50.519062;
        double longitude = 1.592887;

        double latitude2 = 50.433131;
        double longitude2 = 2.823999;

        googleMap.setOnMarkerClickListener(this);

        if (ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }


        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

            @Override
            public void onMyLocationChange(Location location) {
                LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
                MarkerOptions marker = new MarkerOptions().position(loc).title("Vous êtes ici");
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(loc.latitude, loc.longitude)).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
                googleMap.addMarker(marker);
            }
        });

        // create marker
        //MarkerOptions marker = new MarkerOptions().position(//

        //marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_v2));
        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(latitude2, longitude2)).title("Poudlard").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_v2));


        // Changing marker icon
     /*   marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));*/


        // adding marker
        //googleMap.addMarker(marker);
        googleMap.addMarker(marker2);


        showMarker();

        // Perform any camera updates here
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Intent lieuIntent;
        lieuIntent = new Intent(this.getContext(), LieuActivity.class);
        lieuIntent.putExtra(NAME_LIEU, marker.getTitle());
        Log.i("MAP", marker.getTitle());
        if (marker.getTitle().equals("Happy H#cking Days")) {
            lieuIntent.putExtra(IMG_1, R.drawable.background_sample);
        }
        else
            lieuIntent.putExtra(IMG_1, R.drawable.background_sample);

        startActivity(lieuIntent);

        Toast.makeText(this.getContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }


    public void showMarker()
    {
        poi p1 = new poi("Baie de la Canche", 50.549690, 1.617245);
        poi p2 = new poi("Maréis", 50.518582, 1.630492);
        poi p3 = new poi("Sentier près de la côte", 50.528537, 1.581504);
        poi p4 = new poi("Happy H#cking Days", 50.519062, 1.592887);


        ArrayList<poi> poiList = new ArrayList<poi>();
        poiList.add(p1);
        poiList.add(p2);
        poiList.add(p3);
        poiList.add(p4);

        UpdateMapWithRequest(poiList);
    }


    public void UpdateMapWithRequest(ArrayList<poi> liste){

        for(poi p : liste){
                MarkerOptions m = new MarkerOptions().position(
                    new LatLng(p.getLat(), p.getLng())).title(p.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_v2));
                googleMap.addMarker(m);
        }
    }
}