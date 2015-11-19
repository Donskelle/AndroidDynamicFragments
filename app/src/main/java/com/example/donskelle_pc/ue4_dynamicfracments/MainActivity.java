package com.example.donskelle_pc.ue4_dynamicfracments;

import android.app.FragmentTransaction;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "fhfl-dynfracment";

    private LocationsModel locationClass;

    private Map mapFrag;
    private Course courseFrag;
    private Speed speedFrag;


    private LocationManager locationManager;
    private LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity: onCreate():");

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapFrag = new Map();
        courseFrag = new Course();
        speedFrag = new Speed();

        locationClass = new LocationsModel();

        getFragmentManager().beginTransaction().add(R.id.fragment, mapFrag).commit();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        createLocListener();

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d(TAG, "onOptionsItemSelected( " + item.toString() + " )");


        if (id == R.id.map) {
            FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
            fragTransaction.replace(R.id.fragment, mapFrag);
            fragTransaction.addToBackStack(null);
            fragTransaction.commit();

            return true;
        }
        else if (id == R.id.speed) {
            FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
            fragTransaction.replace(R.id.fragment, speedFrag);
            fragTransaction.addToBackStack(null);
            fragTransaction.commit();

            return true;
        }
        else if (id == R.id.course) {
            FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
            fragTransaction.replace(R.id.fragment, courseFrag);
            fragTransaction.addToBackStack(null);
            fragTransaction.commit();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void createLocListener(){
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(TAG, "MainActivity: LocationListener->onLocationChanged()");
                locationClass.setCurrentLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d(TAG, "MainActivity: LocationListener->onStatusChanged()");
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d(TAG, "MainActivity: LocationListener->onProviderEnabled()");
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(TAG, "MainActivity: LocationListener->onProviderDisabled()");
            }
        };
    }

    public LocationsModel getLocationsClass() {
        return locationClass;
    }
}
