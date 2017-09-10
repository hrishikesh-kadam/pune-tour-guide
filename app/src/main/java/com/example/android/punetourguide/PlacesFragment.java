package com.example.android.punetourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    ArrayList<LocationDetails> arrayList;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("arrayList", arrayList);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null)
            arrayList = (ArrayList<LocationDetails>) savedInstanceState.getSerializable("arrayList");
        else {
            arrayList = (ArrayList<LocationDetails>) getArguments().getSerializable("arrayList");
            getArguments().remove("arrayList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view_layout, container, false);

        if (savedInstanceState != null) {
            Log.e("PlacesFragment", "onCreateView -> If");
            arrayList = (ArrayList<LocationDetails>) savedInstanceState.getSerializable("arrayList");
        }

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), arrayList);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(locationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String locationName = ((TextView)view.findViewById(R.id.textViewLocationName)).getText().toString();
                String locationArea = ((TextView)view.findViewById(R.id.textViewLocationArea)).getText().toString();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + locationName + "+" + locationArea + "+Pune" );
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return rootView;
    }
}
