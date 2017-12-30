package com.lzy.mywheelsfour.test.Coordinator;


import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.lzy.sdk.base.BaseActivity;
import com.lzy.mywheelsfour.R;
import com.lzy.mywheelsfour.test.recycleview.Adapter;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorActivity extends BaseActivity {
    private static final String TAG = "CoordinatorActivity";


    private RecyclerView mRvCoordinator;
    private List<String> list = new ArrayList<>();
    private Adapter adapter;
    private Toolbar mToolbar;
    private AppBarLayout mAppBar;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_coordinator;
    }

    @Override
    protected void initView() {


        mRvCoordinator = (RecyclerView) findViewById(R.id.rv_coordinator);
        mToolbar =  findViewById(R.id.toolbar);
        mAppBar = findViewById(R.id.appBar);
    }

    @Override
    protected void initData() {

        mRvCoordinator.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 20; i++) {
            list.add("这个是第"+i);
        }
        adapter = new Adapter(R.layout.item_recycle_view,list);

        mRvCoordinator.setAdapter(adapter);
    }

    @Override
    protected void setClickEvent() {

//       mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//           @Override
//           public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//               Log.d(TAG, "verticalOffset="+verticalOffset);
//               int offset = Math.abs(verticalOffset);
//               int total = appBarLayout.getTotalScrollRange();
//               int alphaIn = offset;
//               int alphaOut = (200-offset)<0?0:200-offset;
//               int maskColorIn = Color.argb(alphaIn, Color.red(mMaskColor),
//                       Color.green(mMaskColor), Color.blue(mMaskColor));
//               int maskColorInDouble = Color.argb(alphaIn*2, Color.red(mMaskColor),
//                       Color.green(mMaskColor), Color.blue(mMaskColor));
//               int maskColorOut = Color.argb(alphaOut*2, Color.red(mMaskColor),
//                       Color.green(mMaskColor), Color.blue(mMaskColor));
//               if (offset <= total / 2) {
//                   tl_expand.setVisibility(View.VISIBLE);
//                   tl_collapse.setVisibility(View.GONE);
//                   v_expand_mask.setBackgroundColor(maskColorInDouble);
//               } else {
//                   tl_expand.setVisibility(View.GONE);
//                   tl_collapse.setVisibility(View.VISIBLE);
//                   v_collapse_mask.setBackgroundColor(maskColorOut);
//               }
//               v_pay_mask.setBackgroundColor(maskColorIn);
//           }
//       });


    }
}
