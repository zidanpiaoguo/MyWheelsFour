package com.lzy.mvpsdk.base;

/**
 * Created by bullet on 2017/12/29.
 */

public interface BasePresenter {

    /**
     * 绑定数据
     */
    void subscribe();

    /**
     * 解除绑定
     */
    void unsubscribe();

}
