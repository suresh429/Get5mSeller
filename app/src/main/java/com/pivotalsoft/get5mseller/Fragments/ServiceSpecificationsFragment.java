package com.pivotalsoft.get5mseller.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pivotalsoft.get5mseller.ProductsActivities.AddProductSpecificationActivity;
import com.pivotalsoft.get5mseller.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceSpecificationsFragment extends Fragment implements View.OnClickListener {

    View rootView;
    FloatingActionButton floatingActionButton;
    public ServiceSpecificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_service_specifications, container, false);
        floatingActionButton =(FloatingActionButton)rootView.findViewById(R.id.fabAddSpecification);
        floatingActionButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.fabAddSpecification:

                Intent intent4 =new Intent(getContext(),AddProductSpecificationActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);

                break;

        }
    }
}

