package com.example.net.retrofit;

import android.os.Looper;


import java.lang.reflect.Type;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.net.BaseRespEntity;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<BaseRespEntity<R>>> {
    private Type type;
    public LiveDataCallAdapter(Type _type){
        type=_type;
    }
    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public LiveData<BaseRespEntity<R>> adapt(Call<R> call) {
        final MutableLiveData<BaseRespEntity<R>> data=new MutableLiveData<>();

        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(Call<R> call, Response<R> response) {
                if (Looper.getMainLooper().getThread()==Thread.currentThread()){
                    data.setValue((BaseRespEntity<R>) response.body());
                }
                else{
                    data.postValue((BaseRespEntity<R>) response.body());
                }
            }

            @Override
            public void onFailure(Call<R> call, Throwable t) {
                if (Looper.getMainLooper().getThread()==Thread.currentThread()){
                    data.setValue(null);
                }
                else{
                    data.postValue(null);
                }
            }
        });
        return data;
    }
}
