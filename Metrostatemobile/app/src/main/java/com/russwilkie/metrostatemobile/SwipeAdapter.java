package com.russwilkie.metrostatemobile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.russwilkie.metrostatemobile.fragments.PrimaryMenuFragment;
import com.russwilkie.metrostatemobile.fragments.SecondaryMenuFragment;


public class SwipeAdapter extends FragmentPagerAdapter {
    public SwipeAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       switch(position){
           case 0:
               return new PrimaryMenuFragment();
           case 1:
               return new SecondaryMenuFragment();
       }
       return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
