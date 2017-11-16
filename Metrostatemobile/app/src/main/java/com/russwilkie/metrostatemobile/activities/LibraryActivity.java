package com.russwilkie.metrostatemobile.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;

public class LibraryActivity extends AppCompatActivity {

    String[] listItems =
            {
                    "Resources",
                    "Hours",
                    "Find Books",
                    "Reserve A Study Room",
                    "Ask A Librarian",
                    "Find Course Resources",
                    "Services",
                    "Research",
                    "Contact Us",
                    "About The Library"
            };
    String[] imageNames =
            {
                    null,
                    "arrow",
                    "arrow",
                    "arrow",
                    "arrow",
                    "arrow",
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
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ListView listView = (ListView) findViewById(R.id.libraryList);
        ImageAdapter adapter = new ImageAdapter(this, R.layout.main, R.id.text1, R.id.image1, listItems, imageNames, isHeader);
        listView.setAdapter(adapter);

        //Handles touch events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(LibraryActivity.this, WebViewerActivity.class);
                intent.putExtra("header", "Library");
                switch((int) id){
                    //Hours
                    case 1:
                        intent.putExtra("url", "http://metrostate.libcal.com/");
                        break;
                    //Find Books
                    case 2:
                        //Cannot use WebView as One Search breaks on web viewer
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://metrostate.summon.serialssolutions.com/"));
                        break;
                    //Reserve a Study Room
                    case 3:
                        intent.putExtra("url", "https://mplus.mnpals.net/booking/patron_MTR_005881814.html");
                        break;
                    //Ask a Librarian
                    case 4:
                        intent.putExtra("url", "https://www.questionpoint.org/crs/qwidgetV4/patronChatQwidget.jsp?langcode=1&instid=13879&ts=1507922258905&skin=blue&size=standard&referer=http%3A%2F%2Fwww.metrostate.edu%2Fstudent%2Flearning-resources%2Flearning-resources%2Flibrary-and-information-services");
                        break;
                    //Find Course Resources
                    case 5:
                        intent.putExtra("url", "https://libguides.metrostate.edu/er.php?");
                        break;
                    //Services
                    case 6:
                        //To-Do
                        //Research
                    case 7:
                        //To-Do
                    //Contact Us
                    case 8:
                        //To-Do
                    //About the Library
                    case 9:
                        //To-Do
                }
                startActivity(intent);
            }
        });

        TextView t2 = (TextView) findViewById(R.id.libraryLink);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}