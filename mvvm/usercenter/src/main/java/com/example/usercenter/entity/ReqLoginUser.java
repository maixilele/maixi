package com.example.usercenter.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class ReqLoginUser extends BaseObservable {
    private String phoneNumber;
    private String pwd;

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(com.example.usercenter.BR.phoneNumber);
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        notifyPropertyChanged(com.example.usercenter.BR.pwd);
    }

    @Override
    public String toString() {
        return "ReqLoginUser{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
