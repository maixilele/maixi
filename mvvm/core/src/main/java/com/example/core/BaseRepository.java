package com.example.core;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public abstract class BaseRepository<M extends IModel> {
    protected M mModel;

    public BaseRepository(){
        mModel=createModel();
    }

    protected abstract M createModel();

}
