package com.example.net;

import android.text.TextUtils;

import com.example.net.api.TokenApi;
import com.example.net.entity.TokenRespEntity;
import com.example.net.retrofit.LiveDataCallAdapterFactory;
import com.example.net.utils.ConstValue;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public class NetTools {

    private Retrofit mRetrofit;

    private NetTools(){
        createRetrofit();
    }
    private volatile static NetTools instance=null;
    public static NetTools getInstance(){
        if (null==instance){
            synchronized (NetTools.class){
                if (null==instance){
                    instance=new NetTools();
                }
            }
        }
        return instance;
    }

    /**
     * 创建Retrofit实例
     * @return
     */
    private void createRetrofit(){
        mRetrofit = new Retrofit.Builder().client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .baseUrl(BuildConfig.baseUrl)
                .build();
    }

    /**
     * 创建Okhttp客户端实例
     * @return
     */
    private OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(ConstValue.TIMEOUT_VALUE, TimeUnit.SECONDS)
                .readTimeout(ConstValue.TIMEOUT_VALUE,TimeUnit.SECONDS)
                .writeTimeout(ConstValue.TIMEOUT_VALUE,TimeUnit.SECONDS)
                .addNetworkInterceptor(createNetworkInterceptor())
                .addInterceptor(createTokenInterceptor())
                .build();
    }

    /**
     * 创建处理Token的自定义拦截器
     * @return
     */
    private Interceptor createTokenInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                //缓存Token 添加到请求头 待实现...

                //如果是401 同步请求Token然后加载到新请求的Header里，重新发起业务请求
                if (checkHttpCode401(response)){
                    String token=requestToken();
                    if (TextUtils.isEmpty(token)){
                        //ZLog.e("Error : token is null...");
                        throw new RuntimeException("Token is null...");
                    }
                    //Request newRequest=chain.request();
                    Request.Builder newBuilder = request.newBuilder().addHeader("Authorization", "bearer " + token);

                    Request newRequest=newBuilder.build();
                    return chain.proceed(newRequest);
                }


                return response;
            }
        };
        return interceptor;
    }

    /**
     * 判断HTTP CODE 是否401 —— TOKEN失效
     * @param response
     * @return
     */
    private boolean checkHttpCode401(Response response) {
        if (null==response){
            return false;
        }

        if (response.code()==401){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 获取Token的同步网络请求
     * @return
     */
    private String requestToken() {

        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> password = (Call<TokenRespEntity>) tokenApi.getToken("password", ConstValue.AUTHCODE, "");

        try {
            retrofit2.Response<TokenRespEntity> result = password.execute();
            if (result!=null&&result.body()!=null){
                return  result.body().getAccess_token();
            }
        } catch (IOException e) {
            //ZLog.e(e.getMessage());
        }
        return "";
    }

    /**
     * 创建日志拦截器
     * @return
     */
    private Interceptor createNetworkInterceptor() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    /**
     * 创建接口实例
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T create(Class<?> clazz){
        return (T) mRetrofit.create(clazz);
    }

}
