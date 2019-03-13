package com.hly.phonemodel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.Locale;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2019/2/21~~~~~~
 * ~~~~~~更改时间:2019/2/21~~~~~~
 * ~~~~~~版本号:2.0~~~~~~
 */
public class PhoneModelUtil {
    /**
     * 获取当前手机系统语言。
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return  语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }


    /**
     * 获取产品名称
     */

    public static String getDeviceProduct() {
        return android.os.Build.PRODUCT;
    }

    /**
     * 获取手机品牌
     */
    public static String getSystemPhoneName() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return  手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }


//     需要添加权限
    @SuppressLint("MissingPermission")
    public static String getIMSI(Context context) {
        TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getSubscriberId();
    }

    /**
     * AndroidId
     * 在设备首次启动时，系统会随机生成一个64位的数字，
     * 并把这个数字以16进制字符串的形式保存下来。不需要权限，
     * 平板设备通用。获取成功率也较高，缺点是设备恢复出厂设置会重置。
     * 另外就是某些厂商的低版本系统会有bug，返回的都是相同的AndroidId。
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidId(Context mContext) {
        return Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     * @return  手机IMEI
     */
    @SuppressLint("MissingPermission")
    public static String getIMEI(Context ctx) {
//        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceId = tm.getDeviceId();
//        if (deviceId != null) {
//            return deviceId;
//        }
//        return "UnKnown";
        String deviceId ="UnKnown";
        try {
            TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
        }catch (Exception e){
            e.getMessage();
        }
        return deviceId;
    }
}