package com.pivotalsoft.get5mseller.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pivotalsoft.get5mseller.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessInfoFragment extends Fragment {

     View rootView;
    public BusinessInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_business_info, container, false);
        return rootView;
    }

}
