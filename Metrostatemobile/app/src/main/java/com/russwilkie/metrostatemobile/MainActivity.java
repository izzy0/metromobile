package com.russwilkie.metrostatemobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import com.russwilkie.metrostatemobile.activities.D2lActivity;
import com.russwilkie.metrostatemobile.activities.DirectoryActivity;
import com.russwilkie.metrostatemobile.activities.EservicesActivity;
import com.russwilkie.metrostatemobile.activities.EventsActivity;
import com.russwilkie.metrostatemobile.activities.GatewayActivity;
import com.russwilkie.metrostatemobile.activities.HelpdeskActivity;
import com.russwilkie.metrostatemobile.activities.LibraryActivity;
import com.russwilkie.metrostatemobile.activities.MapsActivity;
import com.russwilkie.metrostatemobile.activities.PortalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
