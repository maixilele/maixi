package com.example.imageloader.setting;

import android.widget.ImageView;

public abstract  class ImageSetting {
    protected String mUrl;
    protected ImageView mView;
    protected int mPlaceholder;

    public String getmUrl() {
        return mUrl;
    }

    public ImageView getmView() {
        return mView;
    }

    public int getmPlaceholder() {
        return mPlaceholder;
    }
}
