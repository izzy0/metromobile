package com.russwilkie.metrostatemobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;
import com.russwilkie.metrostatemobile.fragments.LibraryContactFragment;

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
                    case 1: {
                        //Hours
                        intent.putExtra("url", "http://metrostate.libcal.com/");
                        break;
                    }
                    case 2: {
                        //Find Books
                        //Cannot use WebView as One Search breaks on web viewer
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://metrostate.summon.serialssolutions.com/"));
                        break;
                    }
                    case 3: {
                        //Reserve a Study Room
                        intent.putExtra("url", "https://mplus.mnpals.net/booking/patron_MTR_005881814.html");
                        break;
                    }
                    case 4: {
                        //Ask a Librarian
                        intent.putExtra("url", "https://www.questionpoint.org/crs/qwidgetV4/patronChatQwidget.jsp?langcode=1&instid=13879&ts=1507922258905&skin=blue&size=standard&referer=http%3A%2F%2Fwww.metrostate.edu%2Fstudent%2Flearning-resources%2Flearning-resources%2Flibrary-and-information-services");
                        break;
                    }
                    case 5: {
                        //Find Course Resources
                        intent.putExtra("url", "https://libguides.metrostate.edu/er.php?");
                        break;
                    }
                    case 6: {
                        //Services
                        String[] items = {"Checkouts and Renewals", "Alumni and Community", "Faculty Resources",
                                "Physical Spaces", "Library Classes", "Events and Programs",
                                "Computers and Printing", "Suggest a Purchase"};
                        String[] images = {"arrow", "arrow", "arrow", "arrow", "arrow", "arrow",
                                "arrow", "arrow"};
                        String[] links = {
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/checkouts-and-renewals",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/alumni-and-community",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/library-faculty-resources",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/physical-spaces",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/library-classes-and-instruction",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/events-and-programs",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/computers-and-printing",
                                "https://libguides.metrostate.edu/purchase"
                        };
                        boolean[] isHeader = {false, false, false, false, false, false, false,
                                false};

                        intent = new Intent(LibraryActivity.this, ListViewLinkActivity.class);
                        intent.putExtra("header", "Services");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                    case 7: {
                        //Research
                        String[] items = {"Get Help", "Research Guides", "Database A-Z",
                                "List of Journals", "Library Catalog / MnPALS", "Cite Your Sources",
                                "Interlibrary Loan", "View Your Library Account"};
                        String[] images = {"arrow", "arrow", "arrow", "arrow", "arrow", "arrow",
                                "arrow", "arrow"};
                        String[] links = {
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/get-library-help",
                                "https://libguides.metrostate.edu/",
                                "https://libguides.metrostate.edu/az.php",
                                "https://browzine.com/libraries/456/subjects",
                                "https://metrostate.mplus.mnpals.net/vufind/?mylocn=MTR",
                                "https://libguides.metrostate.edu/cite-sources",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/interlibrary-loan",
                                "https://metrostate.mplus.mnpals.net/vufind/MyResearch/Home?mylocn=MTR"
                        };
                        boolean[] isHeader = {false, false, false, false, false, false, false,
                                false};

                        intent = new Intent(LibraryActivity.this, ListViewLinkActivity.class);
                        intent.putExtra("header", "Research");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                    case 8: {
                        //Contact Us
                        LibraryContactFragment fragment = new LibraryContactFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.libraryContainer, fragment);
                        transaction.commit();
                        break;
                    }
                    case 9: {
                        //About the Library
                        String[] items = {"Policies", "History and Mission", "Archives",
                                "Staff Directory", "FAQ", "Giving to the Library", "Hours",
                                "Library Location", "Get an ID"};
                        String[] images = {"arrow", "arrow", "arrow", "arrow", "arrow", "arrow",
                                "arrow", "arrow", "arrow"};
                        String[] links = {
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/library-policies",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/history-and-mission",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/archives",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/staff-directory",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/faq",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/giving-to-the-library",
                                "http://metrostate.libcal.com/",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/library-location",
                                "http://www.metrostate.edu/student/learning-resources/learning-resources/library-and-information-services/get-an-id"
                        };
                        boolean[] isHeader = {false, false, false, false, false, false, false,
                                false, false};

                        intent = new Intent(LibraryActivity.this, ListViewLinkActivity.class);
                        intent.putExtra("header", "About The Library");
                        intent.putExtra("items", items);
                        intent.putExtra("images", images);
                        intent.putExtra("links", links);
                        intent.putExtra("isHeader", isHeader);
                        break;
                    }
                }
                if((int) id != 8) {
                    startActivity(intent);
                }
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