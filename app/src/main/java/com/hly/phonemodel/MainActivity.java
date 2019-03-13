package com.hly.phonemodel;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, "请打开权限", 1, perms);
        }

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("系统参数","手机名称"+PhoneModelUtil.getSystemPhoneName());
                Log.e("系统参数","产品名称"+PhoneModelUtil.getDeviceProduct());
                Log.e("系统参数","手机厂商"+PhoneModelUtil.getDeviceBrand());
                Log.e("系统参数","手机手机型号"+PhoneModelUtil.getSystemModel());
                Log.e("系统参数","手机当前系统语言"+PhoneModelUtil.getSystemLanguage());
                Log.e("系统参数","手机系统版本号"+PhoneModelUtil.getSystemVersion());
                Log.e("系统参数","手机AndroidId"+PhoneModelUtil.getAndroidId(getApplicationContext()));
                Log.e("系统参数","手机IMEI"+PhoneModelUtil.getIMEI(getApplicationContext()));
            }
        });
    }
}
