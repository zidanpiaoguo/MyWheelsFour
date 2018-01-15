package com.lzy.mywheelsfour.fragment;

import android.widget.TextView;

import com.example.lzy.sdk.base.BaseFragment;
import com.lzy.mywheelsfour.R;

/**
 *
 * Created by bullet on 2017/12/29.
 */

public class HomeFragment  extends BaseFragment {


    private String mTitle;
    private TextView tvFind;

    public static HomeFragment getInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        fragment.mTitle = title;
        return fragment;
    }
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        tvFind = (TextView) view.findViewById(R.id.tv_find);
    }

    @Override
    protected void initData() {
        tvFind.setText(mTitle);

    }

    @Override
    protected void setClickEvent() {

    }
}
