package com.russwilkie.metrostatemobile.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.activities.ItservicesActivity;
import com.russwilkie.metrostatemobile.activities.LibraryActivity;
import com.russwilkie.metrostatemobile.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryContactFragment extends Fragment {

    public LibraryContactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_contact, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        (getView().findViewById(R.id.callButton)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                askPermission();
                    try{
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:6517931616"));
                        startActivity(callIntent);

                    }catch (SecurityException e){
                        Toast.makeText(getContext(), "Need Permission to call", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        (getView().findViewById(R.id.emailButton)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "library.services@metrostate.edu", null));
                startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

            }
        });
    }

    private Boolean askPermission(){
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, MainActivity.REQUEST_CODE_PHONE_CALL );
            return true;

        } else {
            return false;
        }
    }

}
