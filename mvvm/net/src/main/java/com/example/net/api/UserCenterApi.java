package com.example.net.api;

import com.example.net.BaseRespEntity;

import androidx.lifecycle.LiveData;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public interface UserCenterApi {

    @POST("/login")
    @FormUrlEncoded
    LiveData<BaseRespEntity<Object>> login(@Field("username") String username, @Field("pwd") String pwd);
}
