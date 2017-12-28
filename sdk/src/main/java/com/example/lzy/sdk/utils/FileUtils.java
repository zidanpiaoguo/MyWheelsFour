package com.example.lzy.sdk.utils;

import android.text.TextUtils;

/**
 * Created by bullet on 2017/12/26.
 */

public class FileUtils {
    private static final String TAG = "FileUtils";


    /***
     * 获取文件类型
     *
     * @param paramString 文件名
     * @return
     */
    private String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            return str;
        }
        int i = paramString.lastIndexOf('.');

        if (i <= -1) {
            return str;
        }
        str = paramString.substring(i + 1);

        return str;
    }



}
