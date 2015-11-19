package com.example.donskelle_pc.ue4_dynamicfracments;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class Map extends Fragment {
    private static final String TAG = "fhfl-dynfracment";

    private MapView map;
    private GeoPoint myGeoPoint;
    private ArrayList<OverlayItem> overLayArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "Map: onCreateView()");

        View view = inflater.inflate(R.layout.map_main, container, false);

        map = (MapView) view.findViewById(R.id.mapview);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        // Online-Karten verwenden
        map.setUseDataConnection(true);
        // Zoom-Level einstellen
        MapController controllerMap = (MapController) map.getController();
        controllerMap.setZoom(15);

        Location currentLocation = (((MainActivity) getActivity()).getLocationsClass()).getCurrentLocation();

        myGeoPoint = new GeoPoint(currentLocation.getLatitude(), currentLocation.getLongitude());
        controllerMap.setCenter(myGeoPoint);

        return view;
    }
}
