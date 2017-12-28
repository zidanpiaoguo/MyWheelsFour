package com.example.lzy.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lzy.sdk.app.GlobalApplication;
import com.example.lzy.sdk.config.SPConfig;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * sharePreferences 工具类
 *
 * Created by bullet on 2017/8/30.
 */

public class SPUtils {

    public static String SP_NAME = SPConfig.SP_NAME_1;
    private static SharedPreferences sp;
    private static String serStr;


    private static Context context = GlobalApplication.getInstance().getApplicationContext();




    /**
     * 获取重新定义的SP,
     *
     * @return
     */

    public static SPUtils getSPUtils() {
        SPUtils spUtils = new SPUtils();
        if (sp == null) {
            sp = context.getSharedPreferences(SPConfig.SP_NAME_2, Context.MODE_PRIVATE);
        }
        return spUtils;
    }


    /**
     * 获取SharedPreferences
     *
     * @return
     */

    public static SharedPreferences getSharedPreferences() {
        if (sp == null) {
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp;
    }


    /**
     * 获取 boolead 类型的保存数据
     *
     *
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean( String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }

        return sp.getBoolean(key, defValue);
    }



    /**
     * 保存 boolead 类型的数据
     *
     *
     * @param key
     * @param value
     */
    public static void setBoolean( String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }



    /**
     * 获取 保存的 string 数据
     *
     *
     * @param key
     * @param defValue
     * @return
     */
    public static String getString( String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 保存 string 类型的数据
     *
     *
     * @param key
     * @param value
     */
    public static void setString( String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).apply();
    }


    /**
     * 获取缓存的 int 类型的数据
     *
     *
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt( String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

    /**
     * 缓存int类型的数据
     *
     *
     * @param key
     * @param value
     */
    public static void setInt( String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).apply();
    }



    /**
     * 清除所有缓存数据
     *
     *
     */
    public static void clearAll() {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().clear().apply();
    }


    /**
     * 存储对象
     * @param object
     * @param key
     */
    public static void setObject(Object object, String key) {
        SharedPreferences.Editor prefsEditor = getSharedPreferences().edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }



    /**
     * 获取对象
     * @param type
     * @param key
     * @return
     */
    public static Object getObject( Class<?> type, String key) {
        Gson gson = new Gson();
        String json = getSharedPreferences().getString(key, null);
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            return null;
        }
    }



    /**
     * 序列化保存对象
     *
     * @param context
     * @param key
     * @param obj     要保存的对象，只能保存实现了serializable的对象 modified:
     */
    public static void setSerializableObject(Context context, String key, Object obj) {
        String serialize = "";
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        try {
            serialize = serialize(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sp.edit().putString(key, serialize).commit();
    }

    /**
     * 序列化对象
     *
     * @param obj
     */
    private static String serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        serStr = byteArrayOutputStream.toString("ISO-8859-1");
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return serStr;
    }

    /**
     * 反序列化对象
     *
     * @param str
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static Object getSerializableObject(String str) throws IOException,
            ClassNotFoundException {
        String redStr = java.net.URLDecoder.decode(str, "UTF-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                redStr.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        Object person = (Object) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return person;
    }



}
