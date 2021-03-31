package com.example.imageloader.setting;

import android.widget.ImageView;

//通用的image
public class NormalImageSetting extends ImageSetting {
    //圆角值
    private int imRadius;

    public NormalImageSetting(Builder builder){
        this.mView = builder.imageView;
        this.mPlaceholder = builder.placeHolder;
        this.mUrl = builder.imgUrl;
        this.imRadius = builder.imgRadius;
    }

    public int getImRadius() {
        return imRadius;
    }

    public void setImRadius(int imRadius) {
        this.imRadius = imRadius;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private String imgUrl;
        private ImageView imageView;
        private int placeHolder;
        private int imgRadius;

        private Builder(){}

        public Builder url(String _url){
            imgUrl = _url;
            return this;
        }

        public Builder imageView(ImageView _imageView){
            imageView = _imageView;
            return this;
        }

        public Builder placeHolder(int _placeHolder){
            placeHolder = _placeHolder;
            return this;
        }

        public Builder imageRadius(int _radius){
            this.imgRadius = _radius;
            return this;
        }

        public NormalImageSetting build(){
            return new NormalImageSetting(this);
        }
    }
}
