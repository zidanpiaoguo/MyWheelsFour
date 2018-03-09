package com.lzy.mywheelsfour.contract.home;

import com.lzy.mvpsdk.base.mvpi.IBaseView;
import com.lzy.mywheelsfour.bean.home.HotMovieListBean;

import java.util.List;

/**
 * Created by bullet on 2018/2/28.
 */

public interface HomeContract {


    interface IHotMovieListView extends IBaseView {


        void addHotMovieList(List<HotMovieListBean.DataBean.HotBean> hot);



        void addMovieIds(List<Integer> movieIds);

        void addMoreMovies(List<HotMovieListBean.DataBean.HotBean> movies);

        void loadMoreError();

        void loadMoreCompleted();
    }

    interface IHotMoviePresenter{
        void getHotMovieList(int limit);

        void getMoreHotMovieList(int headline,String movieIds);
    }


}
