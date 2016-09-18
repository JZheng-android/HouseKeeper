package com.example.housekeeper.util;

import android.util.Log;

/**
 * Created by Administrator on 2016/9/18.
 */
public class LogUtil {
    public static boolean isOpenDebug = true;
    public static boolean isOpenWarn = true;
    public static void debug(String tag ,String msg ){
        if (isOpenDebug){
            Log.d(tag , msg);
        }
    }
    public static void warn(String tag ,String msg ){
        if (isOpenWarn){
            Log.d(tag , msg);
        }
    }
}
