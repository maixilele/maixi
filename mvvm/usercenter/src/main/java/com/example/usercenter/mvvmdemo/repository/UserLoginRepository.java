package com.example.usercenter.mvvmdemo.repository;



import androidx.lifecycle.LiveData;

import com.example.core.BaseRepository;
import com.example.net.BaseRespEntity;
import com.example.usercenter.mvvmdemo.model.UserLoginModel;
import com.example.usercenter.mvvmdemo.model.service.entity.LoginEntity;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginRepository extends BaseRepository<UserLoginModel> {
    @Override
    protected UserLoginModel createModel() {
        return new UserLoginModel();
    }

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        //判断网络状态  如果可用
        return mModel.login(entity);
    }
}
