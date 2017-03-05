package com.bwie.project_two_monthtest.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 作者：郭传沛
 * 时间：2017/3/5:19:00
 * 邮箱：gcpzdl@mail.com
 * 说明：
 */


public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ImageLoader
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        ImageLoader instance = ImageLoader.getInstance();
        instance.init(builder.build());
    }
}
