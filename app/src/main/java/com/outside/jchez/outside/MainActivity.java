package com.outside.jchez.outside;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem item = menu.findItem(R.id.menu_item_share);
//        mShareActionProvider=(ShareActionProvider)item.getActionProvider();
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
            Intent settingsActivityIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsActivityIntent);
            return true;
        }
        if (id==R.id.action_view_location) {
            this.openPreferredLocationInMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openPreferredLocationInMap() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String location=pref.getString(getString(R.string.pref_location_key),
                getString(R.string.pref_location_default));
//            String encodedLocation = location.replaceAll("\\s+", "+");
//            String latitude="0";
//            String longitude="0";
        int zoom = 15;
        String baseUri = "geo:0,0";
        Uri uri = Uri.parse(baseUri+"?q="+Uri.encode(location)+"&z="+zoom);
        Log.v("BUILT_URI", uri.toString());
        Intent viewLocationIntent = new Intent(Intent.ACTION_VIEW,uri);
        viewLocationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//            viewLocationIntent.setData(uri);
        if (viewLocationIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(viewLocationIntent);
        }
        else {
            Log.e("Outside","Couldn't find a mapping app to find "+location);
        }
    }
}
