package com.russwilkie.metrostatemobile.activities;

//TO DO POST-BACK: Turn arrays into a key-value pair for headers and items.

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;

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

        //Handles touch events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(GatewayActivity.this, WebViewerActivity.class);
                switch((int) id){
                    //Call Number
                    case 1:
                        if (ContextCompat.checkSelfPermission(GatewayActivity.this,
                                Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.shouldShowRequestPermissionRationale(GatewayActivity.this,
                                    Manifest.permission.CALL_PHONE);
                        } else {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:6517931330"));
                            startActivity(callIntent);
                        }
                    //Go to AskUs Page
                    case 2:
                        intent.putExtra("header", "Gateway Services");
                        intent.putExtra("url", "http://metro-gateway.custhelp.com/");
                        startActivity(intent);
                    case 4:
                        //To-Do
                    case 5:
                        //To-Do
                    case 6:
                        //To-Do
                    case 7:
                        //To-Do
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
