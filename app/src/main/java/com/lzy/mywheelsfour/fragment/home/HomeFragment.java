package com.lzy.mywheelsfour.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lzy.sdk.base.BaseFragment;
import com.lzy.mywheelsfour.R;
import com.lzy.mywheelsfour.view.ProgressLayout;

/**
 *
 * Created by bullet on 2017/12/29.
 */

public class HomeFragment  extends BaseFragment {

    private static final String TAG = "HomeFragment";

    private String mTitle;
    private TextView tvFind;


    //是否是第一次加载
    private boolean isFirst;
    private ProgressLayout llProgress;

    public static HomeFragment getInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        fragment.mTitle = title;
        return fragment;
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: ");
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    
    
    @Override
    protected void initView() {
        Log.d(TAG, "onCreateView: ");
        tvFind = (TextView) view.findViewById(R.id.tv_find);
        llProgress = (ProgressLayout) view.findViewById(R.id.ll_progress);
    }
    
    @Override
    protected void initData() {
//        tvFind.setText(mTitle);

    }

    @Override
    protected void setClickEvent() {


    }





    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        Log.d("lazy", "lazyLoadDate:home "+"显示了"+hidden);

    }
}
