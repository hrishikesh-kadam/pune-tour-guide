package com.example.android.punetourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<LocationDetails> {

    public LocationAdapter(@NonNull Context context, @NonNull ArrayList<LocationDetails> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        LocationDetails locationDetails = getItem(position);
        ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(locationDetails.getLocationImageResourceId());
        ((TextView) convertView.findViewById(R.id.textViewLocationName)).setText(locationDetails.getLocationName());
        TextView textViewLocationArea = convertView.findViewById(R.id.textViewLocationArea);

        if( locationDetails.getLocationArea() == null ) {
            TextView textViewLocationName = convertView.findViewById(R.id.textViewLocationName);
            RelativeLayout relativeLayout = convertView.findViewById(R.id.cardView);
            textViewLocationArea.setVisibility(View.GONE);
            textViewLocationName.setGravity(Gravity.CENTER_VERTICAL);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)textViewLocationName.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            textViewLocationName.setLayoutParams(layoutParams);
            textViewLocationName.setPadding(0,0,0,0);
        }
        else
            textViewLocationArea.setText(locationDetails.getLocationArea());

        return convertView;
    }
}
