package com.lzy.mywheelsfour.utils.sp;

import com.example.lzy.sdk.utils.SPUtils;

public class Preferences {


    private static final String USER_INFO_IS_FIRST = "user_info_is_first";//是否第一次启动

    private static final String USER_ID = "user_id";

    private static final String TOKEN = "token";

    private static final String USER_NAME = "user_name";


    // 用户id
    public static void setUserid(String userid) {
        SPUtils.setString(USER_ID, userid);

    }

    public static String getUserid() {

        return SPUtils.getString(USER_ID, "");
    }

    // 首次使用
    public static void setIsFirst(boolean flag) {
        SPUtils.setBoolean(USER_INFO_IS_FIRST, flag);
    }

    public static boolean getIsFirst() {

        return SPUtils.getBoolean(USER_INFO_IS_FIRST, true);
    }

    // token
    public static void setToken(String token) {
        SPUtils.setString(TOKEN, token);
    }

    public static String getToken() {

        return SPUtils.getString(TOKEN, null);
    }


}
