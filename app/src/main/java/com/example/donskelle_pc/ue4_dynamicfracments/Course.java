package com.example.donskelle_pc.ue4_dynamicfracments;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Donskelle-PC on 19.11.2015.
 */
public class Course extends Fragment {
    private static final String TAG = "fhfl-dynfracment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "Course: onCreateView()");

        return inflater.inflate(R.layout.course_main, container, false);
    }
}