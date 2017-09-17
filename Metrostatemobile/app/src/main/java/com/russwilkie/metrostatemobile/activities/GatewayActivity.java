package com.russwilkie.metrostatemobile.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ListViewAdapter;

public class GatewayActivity extends AppCompatActivity {
    final ListViewAdapter mAdapter = new ListViewAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gateway);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ListView listView = (ListView) findViewById(R.id.gatewayList);


        mAdapter.addSectionHeaderItem("Gateway Main Office");
        mAdapter.addItem("651-793-1300");
        mAdapter.addItem("Ask Us");

        mAdapter.addSectionHeaderItem("Location and Hours");
        mAdapter.addItem("Saint Paul Campus");
        mAdapter.addItem("Minneapolis: MEC");
        mAdapter.addItem("Midway: ETC Building");
        mAdapter.addItem("LECJEC");

        listView.setAdapter(mAdapter);

/*
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items) {
            @Override
            public boolean isEnabled(int position) {
                switch(position){
                    case 0: case 3:
                        return false;
                }
                return true;
            }
        };

        listView.setAdapter(adapter);*/

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


  }
