package com.russwilkie.metrostatemobile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaryMenuFragment extends Fragment {
TextView textView;

    public PrimaryMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       /* View view =
        textView = (TextView)view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        textView.setText("Page number: " + message);*/
        return inflater.inflate(R.layout.fragment_primary_menu, container, false);
    }


}