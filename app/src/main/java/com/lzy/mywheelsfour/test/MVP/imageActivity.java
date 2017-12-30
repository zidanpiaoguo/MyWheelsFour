package com.lzy.mywheelsfour.test.MVP;

import android.widget.ImageView;

import com.example.lzy.sdk.base.BaseActivity;
import com.example.lzy.sdk.utils.ImageUtils;
import com.lzy.mywheelsfour.R;

/**
 * Created by bullet on 2017/12/29.
 */

public class imageActivity extends BaseActivity {
    private ImageView iv1;
    private ImageView iv2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image_url;
    }

    @Override
    protected void initView() {

        iv1 = (ImageView) findViewById(R.id.iv_1);
        iv2 = (ImageView) findViewById(R.id.iv_2);
    }

    @Override
    protected void initData() {
        final String url = "http://video.emall.co.jp/vod/goods1.mp4";
        ImageUtils.loadBasicImg(this, url, iv1);


    }



    @Override
    protected void setClickEvent() {

    }



}
