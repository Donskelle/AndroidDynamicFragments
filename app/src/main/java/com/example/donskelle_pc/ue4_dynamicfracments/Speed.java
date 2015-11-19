package com.example.donskelle_pc.ue4_dynamicfracments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Donskelle-PC on 19.11.2015.
 */
public class Speed extends Fragment {
    private static final String TAG = "fhfl-dynfracment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "Speed: onCreateView()");

        View view = inflater.inflate(R.layout.speed_main, container, false);
        TextView speedTextView = (TextView) view.findViewById(R.id.speedText);

        LocationsModel locationsClass = ((MainActivity) getActivity()).getLocationsClass();
        speedTextView.setText(Float.toString(locationsClass.getSpeed()));
        return view;
    }
}