package com.example.tabswipedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArrivalFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, 
    		ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView =
        	inflater.inflate(R.layout.fragment_arrival, container, false);
         
        return rootView;
    }
}
