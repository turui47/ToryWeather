package com.tory.weather.utils;

import android.util.Log;

/**
 * Created by soonyo on 2017/9/26.
 */

public class LogManager {

    private static final String TAG = "Tory";

    private static LogManager mInstance;

    private LogManager() {
    }

    public static LogManager getInstance() {
        if (mInstance == null){
            synchronized (LogManager.class){
                if (mInstance == null){
                    mInstance = new LogManager();
                }
            }
        }
        return mInstance;
    }

    public void LogCat(String msg){
        Log.v(TAG,msg);
    }
}
