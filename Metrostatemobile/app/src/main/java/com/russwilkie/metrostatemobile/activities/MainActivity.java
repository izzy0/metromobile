package com.russwilkie.metrostatemobile.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.russwilkie.metrostatemobile.ImageIcons;
import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;
import com.russwilkie.metrostatemobile.adapters.ImageGridViewAdapter;
import com.russwilkie.metrostatemobile.adapters.SwipeAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

    public void openGatewayActivity(View view) {
        Intent intent = new Intent(this, GatewayActivity.class);
        startActivity(intent);
    }

    public void openHelpdeskActivity(View view) {
        Intent intent = new Intent(this, ItservicesActivity.class);
        startActivity(intent);
    }

    public void openNewsActivity(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }

    public void openEventsActivity(View view) {
        Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);
    }

    public void openLibraryActivity(View view) {
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }

    public void openMapsActivity(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void openDirectoryActivity(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewerActivity.class);
        intent.putExtra("header", "Campus Directory");
        intent.putExtra("url", "http://www.metrostate.edu/student/university-info/university-info/university-directory");
        startActivity(intent);
    }

    public void openD2lActivity(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewerActivity.class);
        intent.putExtra("header", "D2L");
        intent.putExtra("url", "https://metrostate.ims.mnscu.edu/");
        startActivity(intent);
    }

    public void openEservicesActivity(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewerActivity.class);
        intent.putExtra("header", "eServices");
        intent.putExtra("url", "https://webproc.mnscu.edu/esession/authentication.do?campusId=076&postAuthUrl=http%3A%2F%2Fwebproc.mnscu.edu%2Fregistration%2Fsecure%2Fsearch%2Fbasic.html%3Fcampusid%3D076&_ga=1.67796881.181785071.1407259054");
        startActivity(intent);
    }

    public void openPortalActivity(View view) {
        //Cannot call WebViewerActivity as WebView conflicts with ASPX script
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://metronet.metrostate.edu/portal/default.aspx"));
        startActivity(intent);
    }

    public void openFacebookPage(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewerActivity.class);
        intent.putExtra("header", "Facebook");
        intent.putExtra("url", "https://www.facebook.com/ChooseMetroState");
        startActivity(intent);
    }

    public void openTwitterPage(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewerActivity.class);
        intent.putExtra("header", "Twitter");
        intent.putExtra("url", "https://twitter.com/choose_metro");
        startActivity(intent);
    }

    public void openLinkedinPage(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewerActivity.class);
        intent.putExtra("header", "LinkedIn");
        intent.putExtra("url", "https://www.linkedin.com/school/19685");
        startActivity(intent);

    }
}
