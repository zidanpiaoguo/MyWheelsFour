package com.lzy.mywheelsfour.Test.recycleview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.mywheelsfour.R;

import java.util.List;

/**
 * Created by bullet on 2017/12/20.
 */

public class Adapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_item,item);
    }
}
