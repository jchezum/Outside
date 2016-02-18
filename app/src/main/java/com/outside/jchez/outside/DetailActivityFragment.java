package com.outside.jchez.outside;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent caller = getActivity().getIntent();

        if (caller != null && caller.hasExtra(caller.EXTRA_TEXT)){
            String forecastText = caller.getStringExtra(caller.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.detail_text)).setText(forecastText);
        }

        return rootView;
    }
}
