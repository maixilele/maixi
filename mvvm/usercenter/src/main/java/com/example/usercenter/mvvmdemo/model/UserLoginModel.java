package com.example.usercenter.mvvmdemo.model;



import androidx.lifecycle.LiveData;

import com.example.core.IModel;
import com.example.net.BaseRespEntity;
import com.example.net.NetTools;
import com.example.usercenter.mvvmdemo.model.service.api.LoginApi;
import com.example.usercenter.mvvmdemo.model.service.entity.LoginEntity;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginModel implements IModel {

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        LoginApi api = NetTools.getInstance().create(LoginApi.class);
        return api.login(entity);
    }
}
