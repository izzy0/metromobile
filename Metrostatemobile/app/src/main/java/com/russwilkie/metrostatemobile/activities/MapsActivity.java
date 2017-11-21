package com.russwilkie.metrostatemobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;
import com.russwilkie.metrostatemobile.fragments.LibraryContactFragment;

public class MapsActivity extends AppCompatActivity {

    String[] listItems =
            {
                    "St. Paul",
                    "Midway",
                    "Minneapolis(MEC)",
                    "Brooklyn Park(LecJec)"
            };
    String[] imageNames =
            {
                    "arrow",
                    "arrow",
                    "arrow",
                    "arrow"
            };
    boolean[] isHeader =
            {
                    false,
                    false,
                    false,
                    false
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ListView listView = (ListView) findViewById(R.id.mapsList);
        ImageAdapter adapter = new ImageAdapter(this, R.layout.main, R.id.text1, R.id.image1, listItems, imageNames, isHeader);
        listView.setAdapter(adapter);

        //Handles touch events
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(MapsActivity.this, ListViewLinkActivity.class);

                switch((int) id){
                    case 0:{
                        //Saint Paul;
                        String[] items = {"PDF", "Google Maps"};
                        String[] images = {"arrow", "arrow"};
                        String[] links = {"http://docs.google.com/gview?embedded=true&url=http://www.metrostate.edu/applications/drep/files/SAINT-PAUL-CAMPUS-MAP.pdf",
                               "http://maps.google.com/maps?q=700 7th Street East, , Saint Paul, MN 55106"
                        };
                        boolean[] isHeader = {false, false};

                        intent.putExtra("header", "St. Paul Map");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                    case 1:{
                        //Midway
                        String[] items = {"PDF", "Google Maps"};
                        String[] images = {"arrow", "arrow"};
                        String[] links = {"http://docs.google.com/gview?embedded=true&url=http://www.metrostate.edu/Documents/locations/20150901-midway-campus-map.pdf",
                                "http://maps.google.com/maps?q=1450 Energy Park Drive, , Saint Paul, MN 55108"};
                        boolean[] isHeader = {false, false};

                        intent.putExtra("header", "Midway Map");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                    case 2:{
                        //Minneapolis(MEC)
                        String[] items = {"Google Maps"};
                        String[] images = {"arrow"};
                        String[] links = {"http://maps.google.com/maps?q=Management Education Center , Thirteenth Street and Harmon Place, Minneapolis, MN 55403"};
                        boolean[] isHeader = {false};

                        intent.putExtra("header", "Minneapolis(MEC) Map");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                    case 3:{
                        //Brooklyn Park(LECJEC)
                        String[] items = {"Google Maps"};
                        String[] images = {"arrow"};
                        String[] links = {"http://maps.google.com/maps?q=Law Enforcement and Criminal Justice Education Center (LECJEC), 9110 Brooklyn Boulevard, Brooklyn Park, MN 55445"};
                        boolean[] isHeader = {false};

                        intent.putExtra("header", "Brooklyn Park(LECJEC) Map");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}