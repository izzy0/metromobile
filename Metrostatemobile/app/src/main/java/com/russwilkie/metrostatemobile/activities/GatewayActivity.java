package com.russwilkie.metrostatemobile.activities;

//TO DO POST-BACK: Turn arrays into a key-value pair for headers and items.

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;
import com.russwilkie.metrostatemobile.adapters.ListViewAdapter;

public class GatewayActivity extends AppCompatActivity {

    //Combine listItems and isHeader
    String[] listItems =
            {
                    "Gateway Main Office",
                    "651-793-1300",
                    "Ask Us",
                    "Location and Hours",
                    "Saint Paul Campus",
                    "Minneapolis: MEC",
                    "Midway: ETC Building",
                    "LECJEC"
            };
    String[] imageNames =
            {
                    null,
                    "phone",
                    "lightbulb",
                    null,
                    "arrow",
                    "arrow",
                    "arrow",
                    "arrow"
            };
    boolean[] isHeader =
            {
                    true,
                    false,
                    false,
                    true,
                    false,
                    false,
                    false,
                    false
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gateway);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ListView listView = (ListView) findViewById(R.id.gatewayList);
        ImageAdapter adapter = new ImageAdapter(this, R.layout.main, R.id.text1, R.id.image1, listItems, imageNames, isHeader);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
