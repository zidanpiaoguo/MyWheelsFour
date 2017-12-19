package com.example.lzy.sdk.utils;

import android.widget.Toast;

import com.example.lzy.sdk.app.GlobalApplication;

/**
 * Created by bullet on 2017/8/30.
 */
public class ToastUtils {
    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    public static void makeText(String s) {
        if (toast == null) {
            toast = Toast.makeText(GlobalApplication.getInstance(), s, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime = twoTime;
    }


    public static void makeText(int resId) {
        makeText(GlobalApplication.getInstance().getString(resId));
    }

}
