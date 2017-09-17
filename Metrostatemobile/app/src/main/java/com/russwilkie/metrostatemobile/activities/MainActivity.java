package com.russwilkie.metrostatemobile.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.SwipeAdapter;

public class MainActivity extends AppCompatActivity {
    //ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);

        TabLayout pageIndicator = (TabLayout) findViewById(R.id.tab_layout);
        pageIndicator.setupWithViewPager(viewPager);
        }

    public void openGatewayActivity(View view){
        Intent intent = new Intent(this, GatewayActivity.class);
        startActivity(intent);
    }

    public void openDirectoryActivity(View view){
        Intent intent = new Intent(this, DirectoryActivity.class);
        startActivity(intent);
    }
    public void openHelpdeskActivity(View view){
        Intent intent = new Intent(this, HelpdeskActivity.class);
        startActivity(intent);
    }
    public void openD2lActivity(View view){
        Intent intent = new Intent(this, D2lActivity.class);
        startActivity(intent);
    }
    public void openEservicesActivity(View view){
        Intent intent = new Intent(this, EservicesActivity.class);
        startActivity(intent);
    }
    public void openEventsActivity(View view){
        Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);
    }
    public void openLibraryActivity(View view){
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }
    public void openMapsActivity(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void openPortalActivity(View view){
        Intent intent = new Intent(this, PortalActivity.class);
        startActivity(intent);
    }

    public void openFacebookPage(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ChooseMetroState"));
        startActivity(intent);
    }

    public void openTwitterPage(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/choose_metro"));
        startActivity(intent);
    }

    public void openLinkedinPage(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/school/19685"));
        startActivity(intent);
    }
}
