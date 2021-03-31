package com.example.usercenter.mvvmdemo.model.service.api;


import androidx.lifecycle.LiveData;

import com.example.net.BaseRespEntity;
import com.example.usercenter.mvvmdemo.model.service.entity.LoginEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public interface LoginApi {

    @POST("api/User/login")
    LiveData<BaseRespEntity<LoginEntity>> login(@Body LoginEntity entity);
}
