package com.russwilkie.metrostatemobile.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.SwipeAdapter;

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
}
