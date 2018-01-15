package com.lzy.mywheelsfour.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by bullet on 2018/1/8.
 */

public class FindAdapter extends PagerAdapter {




    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }
}
