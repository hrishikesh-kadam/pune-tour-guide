package com.example.android.punetourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<LocationDetails> restaurantList, templeList, parkList, otherAttractionList;
    private int noOfFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TourFragmentPagerAdapter fragmentPagerAdapter = new TourFragmentPagerAdapter(this, getSupportFragmentManager(),
                noOfFragments, restaurantList, templeList, parkList, otherAttractionList);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initData() {

        noOfFragments = 4;

        restaurantList = new ArrayList<>();
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_1), getString(R.string.area_restaurant_1), R.drawable.image_restaurant_1));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_2), getString(R.string.area_restaurant_2), R.drawable.image_restaurant_2));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_3), getString(R.string.area_restaurant_3), R.drawable.image_restaurant_3));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_4), getString(R.string.area_restaurant_4), R.drawable.image_restaurant_4));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_5), getString(R.string.area_restaurant_5), R.drawable.image_restaurant_5));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_6), getString(R.string.area_restaurant_6), R.drawable.image_restaurant_6));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_7), getString(R.string.area_restaurant_7), R.drawable.image_restaurant_7));
        restaurantList.add(new LocationDetails(getString(R.string.name_restaurant_8), getString(R.string.area_restaurant_8), R.drawable.image_restaurant_8));

        templeList = new ArrayList<>();
        templeList.add(new LocationDetails(getString(R.string.name_temple_1), getString(R.string.area_temple_1), R.drawable.image_temple_1));
        templeList.add(new LocationDetails(getString(R.string.name_temple_2), getString(R.string.area_temple_2), R.drawable.image_temple_2));
        templeList.add(new LocationDetails(getString(R.string.name_temple_3), getString(R.string.area_temple_3), R.drawable.image_temple_3));
        templeList.add(new LocationDetails(getString(R.string.name_temple_4), getString(R.string.area_temple_4), R.drawable.image_temple_4));
        templeList.add(new LocationDetails(getString(R.string.name_temple_5), getString(R.string.area_temple_5), R.drawable.image_temple_5));
        templeList.add(new LocationDetails(getString(R.string.name_temple_6), getString(R.string.area_temple_6), R.drawable.image_temple_6));
        templeList.add(new LocationDetails(getString(R.string.name_temple_7), getString(R.string.area_temple_7), R.drawable.image_temple_7));

        parkList = new ArrayList<>();
        parkList.add(new LocationDetails(getString(R.string.name_park_1), getString(R.string.area_park_1), R.drawable.image_park_1));
        parkList.add(new LocationDetails(getString(R.string.name_park_2), getString(R.string.area_park_2), R.drawable.image_park_2));
        parkList.add(new LocationDetails(getString(R.string.name_park_3), getString(R.string.area_park_3), R.drawable.image_park_3));
        parkList.add(new LocationDetails(getString(R.string.name_park_4), getString(R.string.area_park_4), R.drawable.image_park_4));
        parkList.add(new LocationDetails(getString(R.string.name_park_5), getString(R.string.area_park_5), R.drawable.image_park_5));
        parkList.add(new LocationDetails(getString(R.string.name_park_6), getString(R.string.area_park_6), R.drawable.image_park_6));
        parkList.add(new LocationDetails(getString(R.string.name_park_7), getString(R.string.area_park_7), R.drawable.image_park_7));
        parkList.add(new LocationDetails(getString(R.string.name_park_8), getString(R.string.area_park_8), R.drawable.image_park_8));

        otherAttractionList = new ArrayList<>();
        otherAttractionList.add(new LocationDetails(getString(R.string.name_otherAttraction_1), null, R.drawable.image_otherattractions_1));
        otherAttractionList.add(new LocationDetails(getString(R.string.name_otherAttraction_2), null, R.drawable.image_otherattractions_2));
        otherAttractionList.add(new LocationDetails(getString(R.string.name_otherAttraction_3), null, R.drawable.image_otherattractions_3));
        otherAttractionList.add(new LocationDetails(getString(R.string.name_otherAttraction_4), null, R.drawable.image_otherattractions_4));
        otherAttractionList.add(new LocationDetails(getString(R.string.name_otherAttraction_5), null, R.drawable.image_otherattractions_5));
        otherAttractionList.add(new LocationDetails(getString(R.string.name_otherAttraction_6), null, R.drawable.image_otherattractions_6));

    }
}
