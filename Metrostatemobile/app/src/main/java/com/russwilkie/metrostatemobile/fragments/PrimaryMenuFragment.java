package com.russwilkie.metrostatemobile.fragments;

import android.content.Intent;
import android.net.Uri;
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
import com.russwilkie.metrostatemobile.activities.EventsActivity;
import com.russwilkie.metrostatemobile.activities.GatewayActivity;
import com.russwilkie.metrostatemobile.activities.ItservicesActivity;
import com.russwilkie.metrostatemobile.activities.LibraryActivity;
import com.russwilkie.metrostatemobile.activities.MainActivity;
import com.russwilkie.metrostatemobile.activities.MapsActivity;
import com.russwilkie.metrostatemobile.activities.NewsActivity;
import com.russwilkie.metrostatemobile.activities.WebViewerActivity;
import com.russwilkie.metrostatemobile.adapters.ImageGridViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaryMenuFragment extends Fragment {

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

        view = inflater.inflate(R.layout.fragment_primary_menu2, container, false);
        gridView = (GridView) view.findViewById(R.id.menugridview);
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

    private void selectAction(int position){
        switch (position){
            case 0:
                startActivity( new Intent(getContext(), GatewayActivity.class));
                break;

            case 1:
                startActivity(new Intent(getContext(), NewsActivity.class));
                break;

            case 2:
                startActivity(new Intent(getContext(), ItservicesActivity.class));
                break;

            case 3:
                startActivity(new Intent(getContext(), EventsActivity.class));
                break;

            case 4:
                startActivity(new Intent(getContext(), LibraryActivity.class));
                break;

            case 5:
                Intent intent = new Intent(getContext(), WebViewerActivity.class);
                intent.putExtra("header", "D2L");
                intent.putExtra("url", "https://metrostate.ims.mnscu.edu/");
                startActivity(intent);
                break;

            case 6:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://metronet.metrostate.edu/portal/default.aspx")));
                break;

            case 7:
                startActivity(new Intent(getContext(), MapsActivity.class));
                break;

            case 8:
                Intent intent1 = new Intent(getContext(), WebViewerActivity.class);
                intent1.putExtra("header", "eServices");
                intent1.putExtra("url", "https://webproc.mnscu.edu/esession/authentication.do?campusId=076&postAuthUrl=http%3A%2F%2Fwebproc.mnscu.edu%2Fregistration%2Fsecure%2Fsearch%2Fbasic.html%3Fcampusid%3D076&_ga=1.67796881.181785071.1407259054");
                startActivity(intent1);
                break;
        }
    }

}
