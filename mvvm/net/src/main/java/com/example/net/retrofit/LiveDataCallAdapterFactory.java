package com.example.net.retrofit;


import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.lifecycle.LiveData;
import com.example.net.BaseRespEntity;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {

    public static LiveDataCallAdapterFactory create(){
        return new LiveDataCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType=  getRawType(returnType);
        if (rawType != LiveData.class ){
//            throw new IllegalStateException("not LiveData type...");
            return null;
        }
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType)returnType);
        Class<?> rawObservableType = getRawType(parameterUpperBound);
        if (rawObservableType != BaseRespEntity.class){
            throw new IllegalArgumentException("parameter type is wrong...");
        }
        return new LiveDataCallAdapter<>(rawObservableType);
    }
}
