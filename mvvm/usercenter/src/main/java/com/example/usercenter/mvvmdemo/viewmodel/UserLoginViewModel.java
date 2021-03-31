package com.example.usercenter.mvvmdemo.viewmodel;

import android.util.Log;



import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.core.BaseViewModel;
import com.example.log.ZLogManager;
import com.example.net.BaseRespEntity;
import com.example.usercenter.mvvmdemo.model.service.entity.LoginEntity;
import com.example.usercenter.mvvmdemo.repository.UserLoginRepository;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginViewModel extends BaseViewModel<UserLoginRepository> {
    public LoginEntity reqUserEntity=new LoginEntity();
    public UserLoginViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserLoginRepository createRepository() {
        return new UserLoginRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public void loginCmd(LoginEntity entity){
        ZLogManager.getInstance().w("我是迈兮乐乐");
        mRepository.login(entity).observe(mOwner, new Observer<BaseRespEntity<LoginEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<LoginEntity> result) {
                ZLogManager.getInstance().d("result->"+result.toString());
            }
        });

    }
}
