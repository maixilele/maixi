package com.example.imageloader;

import android.content.Context;

import com.example.imageloader.base.ImgLoaderStrategy;
import com.example.imageloader.impl.GlideStrategy;
import com.example.imageloader.setting.ImageSetting;

public class ImageLoader {
    private ImgLoaderStrategy imgLoaderStrategy;

    //单例
    private volatile static ImageLoader instance = null;
    private  ImageLoader(){
        //默认启用Glide
        imgLoaderStrategy = new GlideStrategy();
    }
    public static ImageLoader getInstance(){
        if (null == instance){
            synchronized (ImageLoader.class){
                if (null==instance){
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    /**
     * 加载图片
     * @param context
     * @param setting
     */
    public void loadImage(Context context, ImageSetting setting){
        if (null == imgLoaderStrategy){
            throw new NullPointerException("imgLoaderStrategy is null");
        }

        if (null == context){
            throw new IllegalArgumentException("context is null");
        }

        if (null == setting){
            throw new IllegalArgumentException("setting is null");
        }

        imgLoaderStrategy.loadImage(context, setting);
    }

    /**
     * 初始化策略
     * @param _imgLoaderStrategy
     */
    public void initStrategy(ImgLoaderStrategy _imgLoaderStrategy){
        this.imgLoaderStrategy = imgLoaderStrategy;
    }

    /**
     * 获取当前策略
     * @return
     */
    public ImgLoaderStrategy getImgLoaderStrategy(){
        return this.imgLoaderStrategy;
    }
}
