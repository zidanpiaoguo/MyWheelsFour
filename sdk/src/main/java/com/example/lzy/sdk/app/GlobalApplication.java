package com.example.lzy.sdk.app;

import android.app.Application;

/**
 * Created by bullet on 2017/12/18.
 */

public class GlobalApplication  extends Application{

    private static GlobalApplication application;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }


    public static GlobalApplication getInstance() {
        return application;
    }

}
