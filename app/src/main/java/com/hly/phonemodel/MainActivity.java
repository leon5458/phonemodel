package com.hly.phonemodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("系统参数","手机厂商"+PhoneModelUtil.getDeviceBrand());
                Log.e("系统参数","手机手机型号"+PhoneModelUtil.getSystemModel());
                Log.e("系统参数","手机当前系统语言"+PhoneModelUtil.getSystemLanguage());
                Log.e("系统参数","手机系统版本号"+PhoneModelUtil.getSystemVersion());
            }
        });
    }
}
