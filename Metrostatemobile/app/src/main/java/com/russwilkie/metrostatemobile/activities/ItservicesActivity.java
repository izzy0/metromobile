package com.russwilkie.metrostatemobile.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItservicesActivity extends AppCompatActivity {


    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explistview_it_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.activity_it_services,expandableListView,false);
        expandableListView.addHeaderView(header);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
        setListener();

}

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void setItems() {

        // Array list for header
        ArrayList<String> header = new ArrayList<String>();

        // Array list for child items
        List<String> inquiries = new ArrayList<String>();
        List<String> newHere = new ArrayList<String>();
        List<String> help = new ArrayList<String>();
        List<String> software = new ArrayList<String>();
        List<String> other = new ArrayList<String>();

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        header.add("General Inquiries");
        header.add("I'm New Here");
        header.add("I Need Help!");
        header.add("Software and Safe Computing");
        header.add("Other Services");

        // Adding general inqurey data
        inquiries.add("Submit IT Request");
        inquiries.add("Multimedia Services");
        inquiries.add("Submit Web Request");
        inquiries.add("D2L, Email, Mobile and Password");
        inquiries.add("Help Setting up Wireless");
        inquiries.add("Check status of IT Request or Web Request");
        inquiries.add("University Projects");

        // Adding New Here data
        newHere.add("E-mail");
        newHere.add("Microsoft Office 365");
        newHere.add("Wireless Network Access");
        newHere.add("Technology Resources for Community Faculty(.pdf)");
        newHere.add("More...");


        // Adding I Need Help data
        help.add("FAQs");
        help.add("Understanding ID/Username");
        help.add("Reset Passwords/PINs");
        help.add("More...");

        // Adding Software and Safe Computing data
        software.add("Network Storage(Home Drive Access(H:))");
        software.add("Security Resource Links");
        software.add("More...");

        // Adding Other Services data
        other.add("Computer Labs");
        other.add("Lisserv");
        other.add("More...");

        // Adding header and childs to hash map
        hashMap.put(header.get(0), inquiries);
        hashMap.put(header.get(1), newHere);
        hashMap.put(header.get(2), help);
        hashMap.put(header.get(3), software);
        hashMap.put(header.get(4), other);

        adapter = new ExpandableListAdapter(ItservicesActivity.this, header, hashMap);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }

    // Setting different listeners to expandablelistview
    void setListener() {


        // This listener will expand one group at one time
        // You can remove this listener for expanding all groups
        expandableListView
                .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    // Default position
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }

                });

        // This listener will show toast on child click
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPos, int childPos, long id) {
                Toast.makeText(
                        ItservicesActivity.this,
                        "You clicked : " + adapter.getChild(groupPos, childPos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
