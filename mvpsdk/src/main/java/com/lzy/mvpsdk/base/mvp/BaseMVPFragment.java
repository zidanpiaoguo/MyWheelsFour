package com.lzy.mvpsdk.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.mvpsdk.base.mvpi.IBasePresenter;

/**
 * Created by bullet on 2018/2/27.
 */

public abstract class BaseMVPFragment<P extends IBasePresenter> extends Fragment {

    protected View view;

    //是否已经加载完UI,
    private boolean isInit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setLayoutId(),container,false);

        isInit = true;

        return view;


    }

    protected abstract int setLayoutId();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isInit) {
            if (getUserVisibleHint()) {
                lazyLoadData();
            }
        }
    }

    /**
     * 懒加载数据
     * 如果只需加载一次，需自行增加判断
     */
    protected void lazyLoadData(){

    }
}
