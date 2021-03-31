package com.example.net.api;

import com.example.net.entity.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);
}
