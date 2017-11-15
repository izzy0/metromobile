package com.russwilkie.metrostatemobile.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import com.russwilkie.metrostatemobile.LinkableItem;
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
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.activity_it_services, expandableListView, false);
        expandableListView.addHeaderView(header);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
        setListener();

        ((ImageButton) findViewById(R.id.callButton)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(ItservicesActivity.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.shouldShowRequestPermissionRationale(ItservicesActivity.this,
                            Manifest.permission.CALL_PHONE);
                } else {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:6517931240"));
                    startActivity(callIntent);
                }

            }
        });

        ((ImageButton) findViewById(R.id.emailButton)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","email@email.com", null));
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            }
        });

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
        List<LinkableItem> inquiries = new ArrayList<LinkableItem>();
        List<LinkableItem> newHere = new ArrayList<LinkableItem>();
        List<LinkableItem> help = new ArrayList<LinkableItem>();
        List<LinkableItem> software = new ArrayList<LinkableItem>();
        List<LinkableItem> other = new ArrayList<LinkableItem>();

        // Hash map for both header and child
        HashMap<String, List<LinkableItem>> hashMap = new HashMap<String, List<LinkableItem>>();

        header.add("General Inquiries");
        header.add("I'm New Here");
        header.add("I Need Help!");
        header.add("Software and Safe Computing");
        header.add("Other Services");

        // Adding general inqurey data
        inquiries.add(new LinkableItem("Submit IT Request", "http://www.google.com"));
        inquiries.add(new LinkableItem("Multimedia Services", "http://www.yahoo.com"));
        inquiries.add(new LinkableItem("Submit Web Request","http://www.metrostate.edu"));
        inquiries.add(new LinkableItem("D2L, Email, Mobile and Password","http://www.cnn.com"));
        inquiries.add(new LinkableItem("Help Setting up Wireless", "http://www.msn.com"));
        inquiries.add(new LinkableItem("Check status of IT Request or Web Request", "http://www.codepen.io"));
        inquiries.add(new LinkableItem("University Projects", "http://www.Github.com"));

        // Adding New Here data
       /* newHere.add("E-mail");
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
        other.add("More...");*/

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
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPos, int childPos, long id) {
                //Will pass ChildItem Links via Intent
                String url = (String) adapter.getChildLink(groupPos, childPos);

                Intent intent = new Intent(ItservicesActivity.this, WebViewerActivity.class);
                intent.putExtra("header", "Information Technology");
                intent.putExtra("url", url);
                startActivity(intent);

                return false;
            }
        });
    }

}


