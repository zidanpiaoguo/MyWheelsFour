/*
 * The author is bullet
 */

package com.lzy.mywheelsfour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.lzy.sdk.base.BaseActivity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.lzy.mywheelsfour.fragment.FindFragment;
import com.lzy.mywheelsfour.fragment.HomeFragment;
import com.lzy.mywheelsfour.fragment.MineFragment;
import com.lzy.mywheelsfour.fragment.VideoFragment;
import com.lzy.mywheelsfour.modle.TabEntity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {



    private CommonTabLayout clTabLayout;

    private String[] mTitles = {"首页", "视频", "购物", "我的"};

    private int[] mIconUnselectIds = {
            R.mipmap.icon_main_find, R.mipmap.icon_main_video,
            R.mipmap.icon_main_shop, R.mipmap.icon_main_mine};
    private int[] mIconSelectIds = {
            R.mipmap.icon_main_find_on, R.mipmap.icon_main_video_on,
            R.mipmap.icon_main_shop_on, R.mipmap.icon_main_mine_on};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {

        clTabLayout = (CommonTabLayout) findViewById(R.id.cl_tab_layout);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitles.length ; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));

        }
        mFragments.add(FindFragment.getInstance("发现"));
        mFragments.add(HomeFragment.getInstance("家里"));
        mFragments.add(MineFragment.getInstance("我的"));
        mFragments.add(VideoFragment.getInstance("视频"));
        clTabLayout.setTabData(mTabEntities, this, R.id.content_layout, mFragments);
        clTabLayout.setCurrentTab(0);
    }

    @Override
    protected void setClickEvent() {
        


    }


}
