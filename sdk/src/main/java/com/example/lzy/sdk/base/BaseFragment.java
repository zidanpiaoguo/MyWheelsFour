/*
 * The author is bullet
 */

package com.example.lzy.sdk.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 实现了懒加载
 * Created by bullet on 2017/12/16.
 */

public abstract class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";
    protected View view;

    private boolean isInit;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(setLayoutId(), container, false);

        } else {
            ViewGroup p = (ViewGroup) view.getParent();
            if (p != null)
                p.removeAllViewsInLayout();
        }

        isInit = true;
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        setClickEvent();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: "+222222);
        if(isInit){
            Log.d(TAG, "setUserVisibleHint: "+333333);

            if (getUserVisibleHint()){
                Log.d(TAG, "setUserVisibleHint: "+444444);
                lazyLoadDate();
            }
        }
    }

    protected  void lazyLoadDate(){

    }
    protected abstract int setLayoutId();


    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setClickEvent();




}
