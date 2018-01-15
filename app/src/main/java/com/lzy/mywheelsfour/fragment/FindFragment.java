package com.lzy.mywheelsfour.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.lzy.sdk.adapter.TabAdapter;
import com.example.lzy.sdk.base.BaseFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lzy.mywheelsfour.R;
import com.lzy.mywheelsfour.test.Splash.guidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by bullet on 2017/12/29.
 */

public class FindFragment extends BaseFragment {

    private String mTitle;
    private SegmentTabLayout findTab;
    private ViewPager findViewpager;

    List<Fragment> listfragment = new ArrayList<>();
    private TabAdapter adapter;
    private List<String> titlelist =new ArrayList<>();

    private String[] mTitles_3 = {"首页", "消息", "联系人", "更多"};

    public static FindFragment getInstance(String title) {
        FindFragment sf = new FindFragment();
        sf.mTitle = title;
        return sf;
    }
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {

        findTab =  view.findViewById(R.id.find_tab);
        findViewpager = view.findViewById(R.id.find_viewpager);
    }

    @Override
    protected void initData() {

        for (int i = 0; i < 4; i++) {
            HomeFragment fragment = HomeFragment.getInstance("发现");
            listfragment.add(fragment);
        }

        titlelist.add("测试");
        titlelist.add("不是");
        titlelist.add("正式");
        titlelist.add("本身");

        adapter = new TabAdapter(getActivity().getSupportFragmentManager(),listfragment,titlelist);
        findViewpager.setAdapter(adapter);
        findTab.setTabData(mTitles_3);

        findTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                findViewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        findViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                findTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        findViewpager.setCurrentItem(1);

    }

    @Override
    protected void setClickEvent() {

    }
}
