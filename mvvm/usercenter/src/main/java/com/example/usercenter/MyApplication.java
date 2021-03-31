package com.example.usercenter;

import android.app.Application;

import com.example.log.LogLevel;
import com.example.log.LogType;
import com.example.log.ZLogManager;
import com.example.log.Zlog;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Zlog zlog = new Zlog.Builder()
                .setLogType(LogType.LOGCAT)
                .setLevel(LogLevel.DEBUG)
                .setTag("maixilele")
                .build();
        ZLogManager.getInstance().inti(zlog);
    }
}
