package com.example.android.punetourguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TourFragmentPagerAdapter extends FragmentPagerAdapter {

    private int fragmentCount;
    private Context context;
    private ArrayList<LocationDetails> restaurantList, templeList, parkList, otherAttractionList;

    public TourFragmentPagerAdapter(Context context, FragmentManager fm,
                                    int fragmentCount,
                                    ArrayList<LocationDetails> restaurantList,
                                    ArrayList<LocationDetails> templeList,
                                    ArrayList<LocationDetails> parkList,
                                    ArrayList<LocationDetails> otherAttractionList) {
        super(fm);
        this.context = context;
        this.fragmentCount = fragmentCount;
        this.restaurantList = restaurantList;
        this.templeList = templeList;
        this.parkList = parkList;
        this.otherAttractionList = otherAttractionList;
    }

    @Override
    public Fragment getItem(int position) {

        PlacesFragment restaurantFragment = new PlacesFragment();
        Bundle bundle = new Bundle();

        if (position == 0) {
            bundle.putSerializable("arrayList", restaurantList);
            restaurantFragment.setArguments(bundle);
            return restaurantFragment;
        }
        else if( position == 1) {
            bundle.putSerializable("arrayList", templeList);
            restaurantFragment.setArguments(bundle);
            return restaurantFragment;
        }
        else if( position == 2) {
            bundle.putSerializable("arrayList", parkList);
            restaurantFragment.setArguments(bundle);
            return restaurantFragment;
        }
        else if( position == 3) {
            bundle.putSerializable("arrayList", otherAttractionList);
            restaurantFragment.setArguments(bundle);
            return restaurantFragment;
        }

        return null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return context.getString(R.string.fragment_restaurants);
        else if (position == 1) return context.getString(R.string.fragment_temples);
        else if (position == 2) return context.getString(R.string.fragment_parks);
        else return context.getString(R.string.fragment_otherAttractions);
    }

    @Override
    public int getCount() {
        return fragmentCount;
    }
}
