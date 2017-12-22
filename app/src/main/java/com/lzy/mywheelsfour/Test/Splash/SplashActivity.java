package com.lzy.mywheelsfour.Test.Splash;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.lzy.sdk.base.BaseActivity;
import com.example.lzy.sdk.config.SPConfig;
import com.example.lzy.sdk.utils.SPUtils;
import com.lzy.mywheelsfour.MainActivity;
import com.lzy.mywheelsfour.R;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by bullet on 2017/12/22.
 */

public class SplashActivity extends BaseActivity  implements EasyPermissions.PermissionCallbacks  {

    private static final String TAG = "SplashActivity";
    private static final int RC_CAMERA_AND_WRITE  = 1;
    private static final int RC_READ = 2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        methodRequiresTwoPermission();
        ReadPermission();
    }

    @Override
    protected void initData() {

        new Thread(){
            @Override
            public void run() {
                super.run();

                //延时操作

                //UI操作的界面
                //如果没有延时操作，可以不创建线程

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = null;
                        if(SPUtils.getBoolean(SPConfig.FIRST_OPEN,true)){
                            intent =new Intent(SplashActivity.this,GuideActivity.class);
                            SPUtils.setBoolean(SPConfig.FIRST_OPEN,false);
                        }else {
                            intent = new Intent(SplashActivity.this, GuideActivity.class);

                        }
                        startActivity(intent);
                    }
                });
            }
        }.start();

    }

    @Override
    protected void setClickEvent() {

    }


    @AfterPermissionGranted(RC_CAMERA_AND_WRITE)
    private void methodRequiresTwoPermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
            Log.d(TAG, "methodRequiresTwoPermission: true");
        } else {
            // Do not have permissions, request them now
            Log.d(TAG, "methodRequiresTwoPermission: false ");
            EasyPermissions.requestPermissions(this, "相机和写权限",
                    RC_CAMERA_AND_WRITE, perms);
        }
    }

    @AfterPermissionGranted(RC_READ)
    private void ReadPermission(){
        String[] perms = {Manifest.permission.RECORD_AUDIO};
        if(EasyPermissions.hasPermissions(this,perms)){
            Log.d(TAG, "ReadPermission: ");
        }else {
//            Log.d(TAG, "ReadPermission: false");
            EasyPermissions.requestPermissions(this,"读取权限",RC_READ,perms);


        }
    }







    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

        Log.d(TAG, "onPermissionsGranted: requestCode"+requestCode);

        Log.d(TAG, "onPermissionsGranted:perms "+perms.toString());
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

        Log.d(TAG, "onPermissionsDenied:  requestCode"+requestCode);
        Log.d(TAG, "onPermissionsDenied: perms "+perms.toString());

        new AlertDialog
                .Builder(this)
                .setView(LayoutInflater.from(this).inflate(R.layout.view_dialog,null))
                .show();

    }
}
