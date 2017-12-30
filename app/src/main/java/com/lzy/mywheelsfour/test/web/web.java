package com.lzy.mywheelsfour.test.web;

import android.webkit.WebView;
import android.widget.LinearLayout;

import com.example.lzy.sdk.base.BaseActivity;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.ChromeClientCallbackManager.ReceivedTitleCallback;
import com.lzy.mywheelsfour.R;

/**
 * Created by bullet on 2017/12/28.
 */

public class web extends BaseActivity{
    private LinearLayout mLlWebView;

    private AgentWeb agentWeb;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {

        mLlWebView = (LinearLayout) findViewById(R.id.ll_web_view);

    }

    @Override
    protected void initData() {
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLlWebView,new LinearLayout.LayoutParams(-1,-1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go("http://120.27.215.97:803/ppapp/#/home");

    }

    @Override
    protected void setClickEvent() {

    }

    @Override
    protected void onResume() {
        agentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        agentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    private ReceivedTitleCallback mCallback = new ReceivedTitleCallback() {
        @Override
        public void onReceivedTitle(WebView view, String title) {

        }
    };
}
