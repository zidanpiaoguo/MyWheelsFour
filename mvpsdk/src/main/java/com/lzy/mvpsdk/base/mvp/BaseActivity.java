package com.lzy.mvpsdk.base.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lzy.mvpsdk.base.mvpi.IBasePresenter;

/**
 *
 * Created by bullet on 2018/2/26.
 */

public abstract class BaseActivity<P extends IBasePresenter> extends FragmentActivity {

    protected Activity mContent;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mContent = this;
        mPresenter = getPresenter();
        initView();
        initData();
        setClickEvent();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(mPresenter!=null){
            mPresenter.onViewStop();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.onViewDestroy();
        }
    }

    /**
     * 获取Presenter
     *
     * @return IPresenter的实现类
     * 例 ： new xxPresenter(mContext,this);
     * 由于不是每个Activity都必须为MVP，在需要使用的时候需要手动调用getPresent
     */
    protected P getPresenter() {
        return mPresenter;
    }


    /**
     * 初始化布局文件
     * @return
     */
    protected abstract int setLayoutId();


    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置监听事件
     */
    protected abstract void setClickEvent();

}
