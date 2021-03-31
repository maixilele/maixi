package com.example.log.impl;

import com.example.log.IZlog;

public class ConsoleLog implements IZlog {
    @Override
    public void d(String log) {
        System.out.println("");
    }

    @Override
    public void i(String log) {

    }

    @Override
    public void w(String log) {

    }

    @Override
    public void e(String log) {

    }

    @Override
    public void setTag(String tag) {

    }

    @Override
    public void setLogLevel(int level) {

    }
}
