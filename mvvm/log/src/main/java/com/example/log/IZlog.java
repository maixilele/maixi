package com.example.log;

public interface IZlog {
    void d(String log);
    void i(String log);
    void w(String log);
    void e(String log);


    void setTag(String tag);
    void setLogLevel(int level);
}
