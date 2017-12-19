package com.lzy.mywheelsfour.Test.ImageView;



import android.widget.ImageView;

import com.example.lzy.sdk.utils.ImageUtils;
import com.example.lzy.sdk.base.BaseActivity;
import com.lzy.mywheelsfour.R;

/**
 * Created by 刘振远 on 2017/12/18.
 */

public class ImageAcitivity  extends BaseActivity{


    private android.widget.ImageView mImage1;
    private android.widget.ImageView mImage2;
    private android.widget.ImageView mImage3;
    private android.widget.ImageView mImage4;
    private android.widget.ImageView mImage5;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    protected void initView() {

        mImage1 = (ImageView) findViewById(R.id.image1);
        mImage2 = (ImageView) findViewById(R.id.image2);
        mImage3 = (ImageView) findViewById(R.id.image3);
        mImage4 = (ImageView) findViewById(R.id.image4);
        mImage5 = (ImageView) findViewById(R.id.image5);
    }

    @Override
    protected void initData() {
        String url = "http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg";

        String gif = "http://img.mp.itc.cn/upload/20161116/fc10ee2abef545c7bbd6f46a09c20ed2_th.gif";

        ImageUtils.loadBasicImg(this,url,mImage1);

        ImageUtils.loadCircleImg(this,url,mImage2);

        ImageUtils.loadRoundedImg(this,url,mImage3,50);

        ImageUtils.loadGifImg(this,gif,mImage4);

        ImageUtils.loadFrameImg(this,url,mImage5,5,R.color.yellow);



    }

    @Override
    protected void setClickEvent() {



    }
}
