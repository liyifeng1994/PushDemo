package com.soecode.lyf.pushdemo;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.mezu.MeizuRegister;
import org.android.agoo.xiaomi.MiPushRegistar;

/**
 * Created by liyifeng on 2018/6/1.
 */

public class App extends Application {

    private static final String TAG = App.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();

        UMConfigure.init(this, "***", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "***");

        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i(TAG, "device token: " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.i(TAG, "register failed: " + s + " " + s1);
            }
        });

        //小米通道
        MiPushRegistar.register(this, "***", "***");
        //华为通道
        HuaWeiRegister.register(this);
        //魅族通道
        MeizuRegister.register(this, "***", "***");
    }
}
