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
                        "mailto","it.services@metrostate.edu", null));
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

        // Adding general Inqurey data
        inquiries.add(new LinkableItem("Submit IT Request", "https://metrostateits.custhelp.com/app/ask"));
        inquiries.add(new LinkableItem("Multimedia Services", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/other-services/multimedia-services"));
        inquiries.add(new LinkableItem("Submit Web Request","https://metrostateits.custhelp.com/app/web-request"));
        inquiries.add(new LinkableItem("D2L, Email, Mobile and Password","http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-need-help/d2l-email-and-password-helps"));
        inquiries.add(new LinkableItem("Help Setting up Wireless", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-am-new-here/wireless-network-access"));
        inquiries.add(new LinkableItem("Check status of IT Request or Web Request", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/view-your-it-requests"));
        inquiries.add(new LinkableItem("University Projects", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/university-projects"));

        // Adding New Here data
        newHere.add(new LinkableItem("E-mail", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-am-new-here/student-faculty-and-staff-email"));
        newHere.add(new LinkableItem("Microsoft Office 365","http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-am-new-here/microsoft-office-365"));
        newHere.add(new LinkableItem("Wireless Network Access", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-am-new-here/wireless-network-access"));
        newHere.add(new LinkableItem("Technology Resources for Community Faculty(.pdf)","http://www.metrostate.edu/Documents/information-technology-services/cf-orientation-spring-2017-4DB5.pdf"));
        newHere.add(new LinkableItem("More...", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-am-new-here"));

        // Adding I Need Help data
        help.add(new LinkableItem("FAQs", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-need-help/faqs"));
        help.add(new LinkableItem("Understanding ID/Username", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-need-help/understanding-ids-and-usernames"));
        help.add(new LinkableItem("Reset Passwords/PINs", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-need-help/tech-id-student-id"));
        help.add(new LinkableItem("More...","http://www.metrostate.edu/student/university-info/university-info/information-technology-services/i-need-help"));

        // Adding Software and Safe Computing data
        software.add(new LinkableItem("Network Storage(Home Drive Access(H:))", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/software-and-safe-computing/network-storage"));
        software.add(new LinkableItem("Security Resource Links","http://www.metrostate.edu/student/university-info/university-info/information-technology-services/software-and-safe-computing/security-resource-links"));
        software.add(new LinkableItem("More...", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/software-and-safe-computing"));

        // Adding Other Services data
        other.add(new LinkableItem("Computer Labs","http://www.metrostate.edu/student/university-info/university-info/information-technology-services/other-services/computer-labs"));
        other.add(new LinkableItem("Lisserv", "http://www.metrostate.edu/student/university-info/university-info/information-technology-services/other-services/listserv"));
        other.add(new LinkableItem("More...","http://www.metrostate.edu/student/university-info/university-info/information-technology-services/other-services"));

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