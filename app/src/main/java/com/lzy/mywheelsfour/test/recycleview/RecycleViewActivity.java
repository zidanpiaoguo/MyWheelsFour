package com.lzy.mywheelsfour.test.recycleview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lzy.sdk.base.BaseActivity;
import com.example.lzy.sdk.utils.ToastUtils;
import com.lzy.mywheelsfour.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends BaseActivity {


    private RecyclerView rvMain;
    private Adapter adapter;
    private List<String> list = new ArrayList<>();
//    private android.support.v4.view.ViewPager main;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_recycle_view;
    }

    @Override
    protected void initView() {


        rvMain = (RecyclerView) findViewById(R.id.rv_main);

//
//        main = (ViewPager) findViewById(R.id.main);
    }

    @Override
    protected void initData() {

//       View view = LayoutInflater.from(this).inflate(R.layout.view_error,null);

//        List<View> views = new ArrayList<>();
//        views.add(view);
//        main.setAdapter(new ViewPageAdapter(views));


        rvMain.setLayoutManager(new LinearLayoutManager(this));

        View view = LayoutInflater.from(this).inflate(R.layout.view_empty,null);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.makeText("刷新界面");
            }
        });

        adapter = new Adapter(R.layout.item_recycle_view,list);
        adapter.setEmptyView(view);
        rvMain.setAdapter(adapter);

    }

    @Override
    protected void setClickEvent() {

    }


}
