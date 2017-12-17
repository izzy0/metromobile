package com.russwilkie.metrostatemobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.ImageIcons;
import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.activities.MainActivity;
import com.russwilkie.metrostatemobile.adapters.ImageGridViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaryMenuFragment extends Fragment {
    TextView textView;


    Integer[] icons = {
            R.mipmap.ic_gateway, R.mipmap.ic_news, R.mipmap.ic_computer, R.mipmap.ic_calendar, R.mipmap.ic_book,
            R.mipmap.ic_d2l, R.mipmap.ic_portal, R.mipmap.ic_map, R.mipmap.ic_eservices
    };

    String[] names = {
            "Gateway", "News", "IT Services", "Events", "Library", "D2L", "Portal", "Maps", "EServices"
    };

    GridView gridView;
    Adapter adapter;
    View view;

    public PrimaryMenuFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        container.setContentView(R.layout.fragment_primary_menu2);
        //gridView.setAdapter(new ImageGridViewAdapter(this, ));

        view = inflater.inflate(R.layout.fragment_primary_menu2, container, false);
        gridView = (GridView) view.findViewById(R.id.menugridview);
        adapter = new ImageGridViewAdapter(getContext(), getImageIcons());

        gridView.setAdapter((ListAdapter) adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Toast.makeText(getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
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

}
