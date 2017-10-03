package com.russwilkie.metrostatemobile.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItservicesActivity extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        createGroupList();

        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.services_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });
}

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("General Inquiries");
        groupList.add("I'm New Here");
        groupList.add("I Need Help!");
        groupList.add("Software and Safe Computing");
        groupList.add("Other Services");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] generalModels = { "Submit IT Request", "Multimedia Services", "Submit Web Request",
                "Web Style Guide", "D2L, Email, Mobile, and Password", "Help setting up Wireless",
                "Check status of IT Reuqest or Web Request" };
        String[] newModels = { "Email", "Microsoft Office 365", "Wireless Network Access",
                "Technology Resources for Community Faculty(.pdf)","More..." };
        String[] helpModels = { "FAQs", "Understanding ID/Username", "Reset Passwords/PINs", "More..." };
        String[] softwareModels = { "Network Storage(Home Drive Access(H:))", "Security Resource Links", "More..."};
        String[] otherModels = { "Computer Labs", "Listserv", "More..." };

        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("General Inquiries")) {
                loadChild(generalModels);
            } else if (laptop.equals("I'm New Here"))
                loadChild(newModels);
            else if (laptop.equals("I Need Help!"))
                loadChild(helpModels);
            else if (laptop.equals("Software and Safe Computing"))
                loadChild(softwareModels);
            else {
                loadChild(otherModels);
            }
            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

}