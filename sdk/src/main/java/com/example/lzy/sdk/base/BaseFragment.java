/*
 * The author is bullet
 */

package com.example.lzy.sdk.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * Created by bullet on 2017/12/16.
 */

public abstract class BaseFragment extends Fragment {

    protected View view;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(setLayoutId(), container, false);
            initView();
            initData();
            setClickEvent();
        } else {
            ViewGroup p = (ViewGroup) view.getParent();
            if (p != null)
                p.removeAllViewsInLayout();
        }
        return view;
    }


    protected abstract int setLayoutId();


    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setClickEvent();

}
