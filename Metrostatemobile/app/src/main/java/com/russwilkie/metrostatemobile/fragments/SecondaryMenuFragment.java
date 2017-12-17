package com.russwilkie.metrostatemobile.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.ImageIcons;
import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.activities.MainActivity;
import com.russwilkie.metrostatemobile.activities.WebViewerActivity;
import com.russwilkie.metrostatemobile.adapters.ImageGridViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondaryMenuFragment extends Fragment {


    Integer[] icons = {
            R.mipmap.ic_facebook, R.mipmap.ic_twitter, R.mipmap.ic_linkedin, R.mipmap.ic_search
    };

    String[] names = {
            "Facebook", "Twitter", "LinkedIn", "Directory"
    };

    GridView gridView;
    Adapter adapter;
    View view;

    public SecondaryMenuFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_secondary_menu, container, false);
        gridView = (GridView) view.findViewById(R.id.menugridview2);
        adapter = new ImageGridViewAdapter(getContext(), getImageIcons());

        gridView.setAdapter((ListAdapter) adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                selectAction(position);
//                Toast.makeText(getContext(), "" + position,
//                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private ArrayList<ImageIcons> getImageIcons(){
        ArrayList<ImageIcons> imageIcons = new ArrayList<>();

        for(int i = 0; i < icons.length; i++){
            imageIcons.add(new ImageIcons(names[i], icons[i]));
        }
        return imageIcons;
    }

    private void selectAction(int position) {
        switch (position) {
            //HINT ADD MORE ICONS TO LIST HERE
            case 0:
                Intent intent = new Intent(getContext(), WebViewerActivity.class);
                intent.putExtra("header", "Facebook");
                intent.putExtra("url", "https://www.facebook.com/ChooseMetroState");
                startActivity(intent);
                break;

            case 1:
                Intent intent1 = new Intent(getContext(), WebViewerActivity.class);
                intent1.putExtra("header", "Twitter");
                intent1.putExtra("url", "https://twitter.com/choose_metro");
                startActivity(intent1);
                break;

            case 2:
                Intent intent2 = new Intent(getContext(), WebViewerActivity.class);
                intent2.putExtra("header", "LinkedIn");
                intent2.putExtra("url", "https://www.linkedin.com/school/19685");
                startActivity(intent2);
                break;

            case 3:
                Intent intent3 = new Intent(getContext(), WebViewerActivity.class);
                intent3.putExtra("header", "Campus Directory");
                intent3.putExtra("url", "http://www.metrostate.edu/student/university-info/university-info/university-directory");
                startActivity(intent3);
                break;
        }
    }
}
