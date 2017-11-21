package com.russwilkie.metrostatemobile.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;


public class GatewayLocationFragment extends Fragment {

    public GatewayLocationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gateway_location, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String header = getArguments().getString("header");
        String location = getArguments().getString("location");
        String hours = getArguments().getString("hours");

        TextView headerView = (TextView) getView().findViewById(R.id.header);
        TextView locationView = (TextView) getView().findViewById(R.id.location);
        TextView hoursView = (TextView) getView().findViewById(R.id.hours);

        headerView.setText(header);
        locationView.setText(location);
        hoursView.setText(hours);
    }

}
