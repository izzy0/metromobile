package com.russwilkie.metrostatemobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.adapters.ImageAdapter;

import java.util.HashMap;
import java.util.Map;

public class ListViewLinkActivity extends AppCompatActivity {

    private Intent intent;

    String[] items;
    String[] images;
    String[] links;
    String header;
    boolean[] isHeader;


    Map<String, String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setListViewValues();

        final TextView setHeader = (TextView) findViewById(R.id.directoryHeader);
        setHeader.setText(header);

        ListView listView = (ListView) findViewById(R.id.listview);
        ImageAdapter adapter = new ImageAdapter(this, R.layout.main, R.id.text1, R.id.image1, items, images, isHeader);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(links[position] != null) {
                    Intent webViewerIntent = new Intent(ListViewLinkActivity.this, WebViewerActivity.class);
                    webViewerIntent.putExtra("header", items[position]);
                    webViewerIntent.putExtra("url", links[position]);
                    startActivity(webViewerIntent);
                }
            }
        });

        removeListViewValues();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void setListViewValues(){
        intent = getIntent();

        items = (intent.getStringArrayExtra("items")).clone();
        images = (intent.getStringArrayExtra("images")).clone();
        links = (intent.getStringArrayExtra("links")).clone();
        header = (intent.getStringExtra("header"));
        isHeader = (intent.getBooleanArrayExtra("isHeader")).clone();

    }
    public void removeListViewValues(){
        intent.removeExtra("header");
        intent.removeExtra("items");
        intent.removeExtra("images");
        intent.removeExtra("links");
        intent.removeExtra("isHeader");;
    }

}
