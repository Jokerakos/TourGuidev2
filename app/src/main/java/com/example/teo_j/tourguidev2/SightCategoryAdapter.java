package com.example.teo_j.tourguidev2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SightCategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;


    public SightCategoryAdapter(Context context, FragmentManager fm){

        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position){

        if(position == 0){
            return new LandmarksFragment();
        }else if(position == 1){
            return new MuseumsFragment();
        }else if(position == 2){
            return new RestaurantFragment();
        }else{
            return new BarsFragment();
        }
    }


    public int getCount(){return 4;}

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.cat_landmark);
        } else if (position == 1) {
            return mContext.getString(R.string.cat_museum);
        } else if (position == 2) {
            return mContext.getString(R.string.cat_restaurants);
        } else {
            return mContext.getString(R.string.cat_bars);
        }
    }



}
