package com.lzy.mywheelsfour.fragment;

import android.util.Log;
import android.widget.TextView;

import com.example.lzy.sdk.base.BaseFragment;
import com.lzy.mywheelsfour.R;

/**
 * Created by bullet on 2017/12/29.
 */

public class VideoFragment extends BaseFragment {

    private String mTitle;
    private TextView tvFind;

    public static VideoFragment getInstance(String title){
        VideoFragment fragment =new  VideoFragment();
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_video;
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

    @Override
    protected void lazyLoadDate() {
        super.lazyLoadDate();
        Log.d("lazy", "lazyLoadDate:video "+"进来了");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("lazy", "lazyLoadDate:video "+"显示了"+hidden);

    }
}
