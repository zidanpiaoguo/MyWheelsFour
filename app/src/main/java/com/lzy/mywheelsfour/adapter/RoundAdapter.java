package com.lzy.mywheelsfour.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.mywheelsfour.modle.RoundText;

import java.util.List;

/**
 * Created by bullet on 2018/1/10.
 */

public class RoundAdapter extends BaseQuickAdapter<RoundText,BaseViewHolder> {

    public RoundAdapter(int layoutResId, @Nullable List<RoundText> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoundText item) {


    }
}
