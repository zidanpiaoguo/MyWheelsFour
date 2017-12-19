package com.example.lzy.sdk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * TabLayout 的adapter
 *
 * Created by bullet on 2017/12/18.
 */

public class TabAdapter extends FragmentPagerAdapter{

    private List<Fragment> listFragment;
    private List<String> listTitle;

    public TabAdapter(FragmentManager fm , List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.listFragment = fragments;
        this.listTitle = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }

}
