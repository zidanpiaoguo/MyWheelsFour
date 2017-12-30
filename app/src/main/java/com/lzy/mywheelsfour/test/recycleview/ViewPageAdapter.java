package com.lzy.mywheelsfour.test.recycleview;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bullet on 2017/12/20.
 */

public class ViewPageAdapter extends PagerAdapter {
    private List<View> list_view;

    public ViewPageAdapter(List<View> list_view) {
        this.list_view = list_view;
    }
    @Override
    public int getCount() {
        return list_view.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list_view.get(position));
        return list_view.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list_view.get(position));
    }
}
