package com.russwilkie.metrostatemobile.activities;

//TO DO POST-BACK: Turn arrays into a key-value pair for headers and items.

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;
import com.russwilkie.metrostatemobile.fragments.GatewayLocationFragment;
import com.russwilkie.metrostatemobile.fragments.LibraryContactFragment;

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

                GatewayLocationFragment fragment = new GatewayLocationFragment();
                Bundle bundle  = new Bundle();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

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
                        break;
                    //Go to AskUs Page
                    case 2:
                        intent.putExtra("header", "Ask Us");
                        intent.putExtra("url", "http://metro-gateway.custhelp.com/");
                        startActivity(intent);
                        break;
                    case 4:
                        bundle.putString("header", "Regular Hours");
                        bundle.putString("location", "Saint Paul: Founders Hall, 1st Floor");
                        bundle.putString("hours", "•Monday - Thursday: 8 a.m. - 6 p.m.\n•Friday: 8 a.m. - 5 p.m.");
                        transaction.addToBackStack(null);
                        break;
                    case 5:
                        bundle.putString("header", "Regular Hours");
                        bundle.putString("location", "Minneapolis: MEC Building");
                        bundle.putString("hours", "•Monday, Tuesday, and Thursday: 10 a.m. - 6:30 p.m.\n•Wednesday and Friday: 8:30 a.m. - 5 p.m.");
                        transaction.addToBackStack(null);
                        break;
                    case 6:
                        bundle.putString("header", "Regular Hours");
                        bundle.putString("location", "Midway: ETC Building");
                        bundle.putString("hours", "•Monday and Thursday: 9 a.m. - 6 p.m.\n•Tuesday: 9 a.m. - 5:30 p.m.\n•Wednesday and Friday: 9 a.m. - 5 p.m.");
                        transaction.addToBackStack(null);
                        break;
                    case 7:
                        bundle.putString("header", "Regular Hours");
                        bundle.putString("location", "LECJEC: Brooklyn Park");
                        bundle.putString("hours", "•Monday - Thursday: 10 a.m. - 6:30 p.m\n•Friday: 9 a.m. - 5 p.m");
                        transaction.addToBackStack(null);
                        break;
                }
                if((int) id > 2) {
                    transaction.replace(R.id.gatewayContainer, fragment);
                    transaction.commit();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0 ) {
            getSupportFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }
}
