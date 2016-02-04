package com.outside.jchez.outside;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] weatherData= {
                    "Day1 - Sunny - 86/63","Day2 - Sunny - 86/63",
                    "Day3 - Sunny - 86/63","Day4 - Sunny - 86/63",
                    "Day5 - Sunny - 86/63","Day6 - Sunny - 86/63",
                    "Day7 - Sunny - 86/63","Day8 - Sunny - 86/63",
                    "Day9 - Sunny - 86/63","Day10 - Sunny - 86/63",
                    "Day11 - Sunny - 86/63","Day12 - Sunny - 86/63" };

            List<String> weekForcast = new ArrayList<String>(Arrays.asList(weatherData));
            ArrayAdapter<String> weather = new ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,R.id.list_item_forecast_textview,weekForcast);
            ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(weather);

            return rootView;
        }
    }
}
