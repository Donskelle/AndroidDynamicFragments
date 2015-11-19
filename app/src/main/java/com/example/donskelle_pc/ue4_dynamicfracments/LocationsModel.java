package com.example.donskelle_pc.ue4_dynamicfracments;

import android.location.Location;
import android.util.Log;

/**
 * Created by Donskelle-PC on 19.11.2015.
 */
public class LocationsModel {
    private static final String TAG = "fhfl-dynfracment";

    private Location location;

    public LocationsModel() {
        Log.d(TAG, "LocationsModel: onCreate()");
        location = new Location("provider");
        location.setLatitude(0.0);
        location.setLongitude(0.0);
    }

    public void setCurrentLocation(Location loc) {
        Log.d(TAG, "LocationsModel: setCurrentLocation()");
        Log.d(TAG, loc.toString());
        location = loc;
    }

    public Location getCurrentLocation() {
        Log.d(TAG, "LocationsModel: getCurrentLocation();");
        Log.d(TAG, location.toString());
        return location;
    }

    public float getSpeed() {
        Log.d(TAG, "LocationsModel: getSpeed();");
        return location.getSpeed();
    }
}
