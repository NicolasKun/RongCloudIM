package me.nicolas.rongcloudimdemo;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by LeeQ
 * Date : 2016-09-12
 * Name : RongCloudIMDemo
 * Use :
 */
public class IMApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
