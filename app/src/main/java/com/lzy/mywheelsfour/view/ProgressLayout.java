package com.lzy.mywheelsfour.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lzy.mywheelsfour.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 四种状态的LinearLayout，用于切换当前的页面显示
 *
 * LOADING  加载中
 * ERROR    加载失败
 * EMPTY    没有数据
 * CONTENT  有内容
 *
 *
 * Created by bullet on 2018/2/28.
 */

public class ProgressLayout extends LinearLayout{
    private static final String LOADING_TAG = "loading_tag";
    private static final String ERROR_TAG = "error_tag";
    private static final String EMPTY_TAG = "empty_tag";

    private LayoutParams layoutParams;
    private LayoutInflater inflater;

    private LinearLayout loadingView ,emptyView,errorView;

    //包含的View集合
    private List<View> contentViews = new ArrayList<>();



    private enum State {
        LOADING, EMPTY, ERROR,CONTENT
    }

    private State currentState = State.LOADING;

    public ProgressLayout(Context context) {
        super(context);
        initInflater();
    }

    public ProgressLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflater();
    }

    private void  initInflater(){

        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if(child.getTag()==null||
                (!child.getTag().equals(LOADING_TAG)&&
                        !child.getTag().equals(EMPTY_TAG)&&
                        !child.getTag().equals(ERROR_TAG))){

            contentViews.add(child);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (errorView != null) {
            errorView.setOnClickListener(null);
        }
        if (emptyView != null) {
            emptyView.setOnClickListener(null);
        }
    }

    /**
     * 显示加载view
     */
    public void showLoading(){
        currentState = State.LOADING;
        showLoadingView();
        hideErrorView();
        hideEmptyView();
        setContentVisibility(false);

    }

    /**
     * 显示内容
     */
    public void showContent(){
        currentState = State.CONTENT;
        setContentVisibility(true);
        hideLoadingView();
        hideErrorView();
    }

    /**
     * 显示加载失败
     */
    public void showError(OnClickListener click){
        currentState = State.ERROR;
        showErrorView();
        hideLoadingView();
        hideEmptyView();
        errorView.setOnClickListener(click);
        setContentVisibility(false);
    }

    /**
     * 显示空白的加载页面
     */
    public void showEmpty(OnClickListener click){
        currentState = State.EMPTY;
        showEmptyView();
        hideLoadingView();
        hideErrorView();
        emptyView.setOnClickListener(click);
        setContentVisibility(false);
    }

    /**
     * 当前状态是否是显示内容
     * @return
     */
    public boolean isContent() {
        return currentState == State.CONTENT;
    }


    private void showEmptyView() {
        if (emptyView == null) {
            emptyView = (LinearLayout) inflater.inflate(R.layout.layout_empty_view, null);
            emptyView.setTag(ERROR_TAG);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(emptyView, layoutParams);
        } else {
            emptyView.setVisibility(VISIBLE);
        }

    }


    private void showErrorView() {
        if (errorView == null) {
            errorView = (LinearLayout) inflater.inflate(R.layout.layout_error_view, null);
            errorView.setTag(ERROR_TAG);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(errorView, layoutParams);
        } else {
            errorView.setVisibility(VISIBLE);
        }
    }


    private void showLoadingView() {

        if (loadingView == null) {
            loadingView = (LinearLayout) inflater.inflate(R.layout.layout_loading_view, null);
            loadingView.setTag(LOADING_TAG);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(loadingView, layoutParams);
        } else {
            loadingView.setVisibility(VISIBLE);
        }
    }


    private void hideLoadingView() {
        if (loadingView != null && loadingView.getVisibility() != GONE) {
            loadingView.setVisibility(GONE);
        }
    }

    private void hideEmptyView() {
        if (emptyView != null && emptyView.getVisibility() != GONE) {
            emptyView.setVisibility(GONE);
        }
    }

    private void hideErrorView() {
        if (errorView != null && errorView.getVisibility() != GONE) {
            errorView.setVisibility(GONE);
        }

    }


    public void setContentVisibility(boolean visible) {

        for (View contentView : contentViews) {
            contentView.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

}
