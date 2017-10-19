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
import com.russwilkie.metrostatemobile.adapters.ListExpandableAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItservicesActivity extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    private static ExpandableListView expandableListView;
    private static ListExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
*/
        expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.activity_it_services,expandableListView,false);
        expandableListView.addHeaderView(header);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
        setListener();



       /* createGroupList();

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
        });*/
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
        List<String> child1 = new ArrayList<String>();
        List<String> child2 = new ArrayList<String>();
        List<String> child3 = new ArrayList<String>();
        List<String> child4 = new ArrayList<String>();

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding headers to list
        for (int i = 1; i < 5; i++) {
            header.add("Group " + i);

        }
        // Adding child data
        for (int i = 1; i < 5; i++) {
            child1.add("Group 1  - " + " : Child" + i);

        }
        // Adding child data
        for (int i = 1; i < 5; i++) {
            child2.add("Group 2  - " + " : Child" + i);

        }
        // Adding child data
        for (int i = 1; i < 6; i++) {
            child3.add("Group 3  - " + " : Child" + i);

        }
        // Adding child data
        for (int i = 1; i < 7; i++) {
            child4.add("Group 4  - " + " : Child" + i);

        }

        // Adding header and childs to hash map
        hashMap.put(header.get(0), child1);
        hashMap.put(header.get(1), child2);
        hashMap.put(header.get(2), child3);
        hashMap.put(header.get(3), child4);

        adapter = new ListExpandableAdapter(ItservicesActivity.this, header, hashMap);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }

    // Setting different listeners to expandablelistview
    void setListener() {

        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Toast.makeText(ItservicesActivity.this,
                        "You clicked : " + adapter.getGroup(group_pos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

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

/*
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
    }*/

}
