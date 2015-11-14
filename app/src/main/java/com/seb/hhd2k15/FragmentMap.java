package com.seb.hhd2k15 ;  // change to your own package

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import java.util.List;

/**
 * A fragment that launches other parts of the demo application.
 */
public class FragmentMap extends Fragment implements GoogleMap.OnMarkerClickListener{

    MapView mMapView;
    private GoogleMap googleMap;

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
        double longitude2= 2.823999;
        googleMap.setOnMarkerClickListener(this);

        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("MA BITE");
        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(latitude2,longitude2)).title("Poudlard");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_v2)); marker2.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_v2));

        //SetListener On a marker



        // adding marker
        googleMap.addMarker(marker);
        googleMap.addMarker(marker2);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
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
        Toast.makeText(this.getContext(), marker.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }

    public void UpdateMapWithRequest(List<poi> liste){

        for(poi p : liste){
                MarkerOptions m = new MarkerOptions().position(
                    new LatLng(p.getLat(), p.getLng())).title(p.getTitle()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_v2));
                googleMap.addMarker(m);
        }
    }
}