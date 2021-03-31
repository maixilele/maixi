package com.example.usercenter.entity;

import android.util.Log;

/**
 * @author:zhangyue
 * @date:2021/3/23
 */
public class UserEntity {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void userOnClick(UserEntity entity){
        Log.d("123","DataBinding Event onTouch.."+entity.getName());
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
