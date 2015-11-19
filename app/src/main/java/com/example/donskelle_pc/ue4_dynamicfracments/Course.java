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
public class Course extends Fragment {
    private static final String TAG = "fhfl-dynfracment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "Course: onCreateView()");

        View view = inflater.inflate(R.layout.course_main, container, false);
        TextView courseTextView = (TextView) view.findViewById(R.id.courseText);

        LocationsModel locationsClass = ((MainActivity) getActivity()).getLocationsClass();
        courseTextView.setText(Float.toString(locationsClass.getBearing()));

        return view;
    }
}