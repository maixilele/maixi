package com.example.usercenter.mvvmdemo.model.service.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */

public class UserLoginEntity extends BaseObservable {
    public int id;
    public String name;
    public String pwd;

    public UserLoginEntity(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public UserLoginEntity(){}

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(com.example.usercenter.BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.example.usercenter.BR.name);
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
        return "UserLoginEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
