package com.lzy.mywheelsfour.fragment;

import com.example.lzy.sdk.base.BaseFragment;

/**
 * Created by bullet on 2017/12/29.
 */

public class VideoFragment extends BaseFragment {

    private String mTitle;

    public static VideoFragment getInstance(String title){
        VideoFragment fragment =new  VideoFragment();
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected int setLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setClickEvent() {

    }
}
