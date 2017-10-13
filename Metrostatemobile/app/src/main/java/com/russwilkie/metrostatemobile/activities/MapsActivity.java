package com.russwilkie.metrostatemobile.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;

public class MapsActivity extends AppCompatActivity {

    String[] listItems =
            {
                    "St. Paul",
                    "Midway",
                    "MEC",
                    "LecJec"};
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
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}