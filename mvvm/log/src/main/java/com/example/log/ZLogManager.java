package com.example.log;

public class ZLogManager {
    private static ZLogManager instance = new ZLogManager();
    private ZLogManager(){};
    public static ZLogManager getInstance(){
        return instance;
    }

    private Zlog zlog;
    public void inti(Zlog _log){
        if (_log == null){
            zlog = new Zlog.Builder().setLogType(LogType.LOGCAT)
                    .setLevel(LogLevel.DEBUG)
                    .setTag("1808---").build();
        }else{
            zlog = _log;
        }
    }

    public void d(String log) {
        zlog.d(log);
    }

    public void i(String log) {
        zlog.i(log);
    }

    public void w(String log) {
        zlog.w(log);
    }

    public void e(String log) {
        zlog.e(log);
    }
}
