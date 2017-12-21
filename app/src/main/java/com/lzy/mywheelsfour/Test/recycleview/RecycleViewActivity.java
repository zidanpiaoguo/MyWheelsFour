package com.lzy.mywheelsfour.Test.recycleview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lzy.sdk.base.BaseActivity;
import com.example.lzy.sdk.utils.ToastUtils;
import com.lzy.mywheelsfour.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecycleViewActivity extends BaseActivity {


//    private RecyclerView rvMain;
    private Adapter adapter;
    private List<String> list = new ArrayList<>();
    private android.support.v4.view.ViewPager main;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_recycle_view;
    }

    @Override
    protected void initView() {


//        rvMain = (RecyclerView) findViewById(R.id.rv_main);


        main = (ViewPager) findViewById(R.id.main);
    }

    @Override
    protected void initData() {

       View view = LayoutInflater.from(this).inflate(R.layout.view_error,null);
//        //设置RelativeLayout布局的宽高
//        LinearLayout.LayoutParams relLayoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        main.addView(view,relLayoutParams);
//
//        TextView tv = new TextView(this);
//        tv.setText("翁山豆根士大夫士大夫");
//
//        main.addView(tv,relLayoutParams);


        List<View> views = new ArrayList<>();
        views.add(view);
        main.setAdapter(new ViewPageAdapter(views));


//        rvMain.setLayoutManager(new LinearLayoutManager(this));
//
//        View view = LayoutInflater.from(this).inflate(R.layout.view_empty,null);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtils.makeText("刷新界面");
//            }
//        });
//        adapter = new Adapter(R.layout.item_recycle_view,list);
//        adapter.setEmptyView(view);
//        rvMain.setAdapter(adapter);

    }

    @Override
    protected void setClickEvent() {

    }


}
