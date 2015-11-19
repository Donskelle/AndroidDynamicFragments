package com.example.donskelle_pc.ue4_dynamicfracments;

import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;

/**
 * Created by Donskelle-PC on 19.11.2015.
 */
public class LocationsModel {
    private static final String TAG = "fhfl-dynfracment";

    private static final String SHARED_PREFERENCES_LONG = "location_long";
    private static final String SHARED_PREFERENCES_LAT = "location_lat";
    private static final String SHARED_PREFERENCES_SP = "location_speed";
    private static final String SHARED_PREFERENCES_BE = "location_bearing";

    private Location location;

    public LocationsModel(SharedPreferences sp) {
        Log.d(TAG, "LocationsModel: onCreate()");

        double longitude = Double.parseDouble( sp.getString(SHARED_PREFERENCES_LONG, "0.0") );
        double latitude = Double.parseDouble(sp.getString(SHARED_PREFERENCES_LAT, "0.0"));
        float speed = sp.getFloat(SHARED_PREFERENCES_SP, 0);
        float bearing = sp.getFloat(SHARED_PREFERENCES_BE, 0);

        location = new Location("provider");
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setSpeed(speed);
        location.setBearing(bearing);
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

    public float getBearing() {
        Log.d(TAG, "LocationsModel: getSpeed();");
        return location.getBearing();
    }

    public void safe(SharedPreferences sp) {
        Log.d(TAG, "LocationsModel: safe();");
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(SHARED_PREFERENCES_LONG, String.valueOf((location.getLongitude())));
        ed.putString(SHARED_PREFERENCES_LAT, String.valueOf((location.getLatitude())));
        ed.putFloat(SHARED_PREFERENCES_SP, location.getSpeed());
        ed.putFloat(SHARED_PREFERENCES_BE, location.getBearing());
        ed.commit();
    }
}
