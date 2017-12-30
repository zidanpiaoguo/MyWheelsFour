package com.lzy.mywheelsfour.test.Splash;

import android.support.v4.view.ViewPager;

import com.example.lzy.sdk.base.BaseActivity;
import com.example.lzy.sdk.views.CircleIndicator;
import com.lzy.mywheelsfour.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by bullet on 2017/12/22.
 */

public class GuideActivity extends BaseActivity{

    private ViewPager mVpGuide;
    private CircleIndicator mIndicatorGuide;

    guidePagerAdapter adapter;
    List<Integer> list = new ArrayList<>();
    @Override
    protected int setLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {

        mVpGuide =  findViewById(R.id.vp_guide);
        mIndicatorGuide =  findViewById(R.id.indicator_guide);
    }

    @Override
    protected void initData() {
        list.add(R.mipmap.install1);
        list.add(R.mipmap.install2);
        list.add(R.mipmap.install3);

        adapter = new guidePagerAdapter(this,list);
        mVpGuide.setAdapter(adapter);
        mIndicatorGuide.setViewPager(mVpGuide);


    }

    @Override
    protected void setClickEvent() {

    }
}
