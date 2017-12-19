/*
 * The author is bullet
 */

package com.example.lzy.sdk.base;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.lzy.sdk.utils.StatusBarUtil;
import com.example.lzy.sdk.app.ActivityCollector;

/**
 * Created by bullet on 2017/12/16.
 */

public abstract class BaseActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //上面两行代码要在setContentView 之前添加

        setContentView(setLayoutId());
        //设置顶部状态栏
        StatusBarUtil.StatusBarLightMode(this);


        initView();
        initData();
        setClickEvent();

        ActivityCollector.getAcitivityCollector().addActivty(this);
    }

    protected abstract int setLayoutId();


    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setClickEvent();


    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getAcitivityCollector().removeActivty(this);
    }
}
