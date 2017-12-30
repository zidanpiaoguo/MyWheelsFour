

/*
 * The author is bullet
 */

package com.lzy.mywheelsfour.test.switchButton;


import android.widget.CompoundButton;

import com.example.lzy.sdk.utils.ToastUtils;
import com.example.lzy.sdk.base.BaseActivity;
import com.kyleduo.switchbutton.SwitchButton;
import com.lzy.mywheelsfour.R;

/**
 * Created by 刘振远 on 2017/12/16.
 */

public class switchButton  extends BaseActivity {

    private SwitchButton mSbButton1;
    private SwitchButton mSbButton2;

    @Override
    protected int setLayoutId() {
        return R.layout.acitivity_switch_button;
    }

    @Override
    protected void initView() {

        mSbButton1 =  findViewById(R.id.sb_button1);
        mSbButton2 =  findViewById(R.id.sb_button2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setClickEvent() {
        mSbButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    ToastUtils.makeText("我点击了");
                }else {
                    ToastUtils.makeText("我没有点击");
                }
            }
        });
    }
}
