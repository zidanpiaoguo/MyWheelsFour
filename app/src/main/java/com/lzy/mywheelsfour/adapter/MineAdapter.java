package com.lzy.mywheelsfour.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lzy.mywheelsfour.R;

import java.util.List;

/**
 * Created by bullet on 2018/1/9.
 */

public class MineAdapter extends RecyclerView.Adapter{


    private Activity activity;
    private List<Integer> list;

    public MineAdapter(Activity activity, List<Integer> list) {
        this.activity = activity;
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){


        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
