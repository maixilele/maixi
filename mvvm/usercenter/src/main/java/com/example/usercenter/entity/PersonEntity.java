package com.example.usercenter.entity;

import android.util.Log;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * @author:zhangyue
 * @date:2021/3/24
 */
public class PersonEntity {
    public  ObservableInt age=new ObservableInt();
    public  ObservableField<String> name=new ObservableField<>();

    public ObservableField<String> headerImg=new ObservableField<>();

    public void addData(PersonEntity entity){
        Log.d("123","content:"+entity.toString());
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }


}
