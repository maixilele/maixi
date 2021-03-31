package com.example.usercenter.mvvmdemo.view;


import android.os.Bundle;
import android.widget.ImageView;

import com.example.core.view.BaseMVVMActivity;
import com.example.imageloader.ImageLoader;
import com.example.imageloader.impl.GlideStrategy;
import com.example.imageloader.setting.NormalImageSetting;
import com.example.log.LogLevel;
import com.example.log.LogType;
import com.example.log.ZLogManager;
import com.example.log.Zlog;
import com.example.usercenter.BR;
import com.example.usercenter.R;
import com.example.usercenter.databinding.UserLoginDataBinding;
import com.example.usercenter.mvvmdemo.viewmodel.UserLoginViewModel;


public class UserLoginActivity extends BaseMVVMActivity<UserLoginViewModel, UserLoginDataBinding> {


    private ImageView iv_register;

    @Override
    protected int getVariable() {
        return BR.reqData;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_login;
    }

    @Override
    protected UserLoginViewModel createViewModel() {
        return new UserLoginViewModel(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 启动
         */
        ImageLoader.getInstance().initStrategy(new GlideStrategy());

        iv_register = findViewById(R.id.iv_register);
        ImageLoader.getInstance()
                .loadImage(this, NormalImageSetting
                .builder()
                .url("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201807%2F15%2F20180715154106_admsh.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619655750&t=abdc31c99403eb32a94fc4305c393367")
                .imageRadius(50).imageView(iv_register)
                .build());

    }
}