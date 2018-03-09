package com.lzy.mywheelsfour.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lzy.sdk.base.BaseFragment;
import com.lzy.mywheelsfour.R;

import java.util.List;

/**
 * Created by bullet on 2017/12/29.
 */

public class MineFragment extends BaseFragment {

    private String mTitle;

    private int[] listmap = {R.mipmap.ic_category_10,R.mipmap.ic_category_11,R.mipmap.ic_category_12,R.mipmap.ic_category_13,
            R.mipmap.ic_category_14,R.mipmap.ic_category_15, R.mipmap.ic_category_16,R.mipmap.ic_category_17,
            R.mipmap.ic_category_18, R.mipmap.ic_category_19};

    private String[] titlelist = {"快递","天气","纪实","工具",
            "画廊","新闻","聊天","笔记本",
            "唐诗","语音"};

    public static MineFragment getInstance(String title){
        MineFragment fragment = new  MineFragment();
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {



    }

    @Override
    protected void setClickEvent() {

    }


    private void setRound(){
        int page = (int) Math.ceil(titlelist.length*1.0/8);
        for (int i = 0; i < page; i++) {
            View view =  View.inflate(getActivity(),R.layout.view_round_carousal,null);

            RecyclerView recyclerView = view.findViewById(R.id.rc_view);
//            recyclerView.setLayoutManager(new GridLayoutManager());



        }
    }



    @Override
    protected void lazyLoadDate() {
        super.lazyLoadDate();
        Log.d("lazy", "lazyLoadDate:mine "+"进来了");
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("lazy", "lazyLoadDate:mine "+"显示了"+hidden);

    }






}
