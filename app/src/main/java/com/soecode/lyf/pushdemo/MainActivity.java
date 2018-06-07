package com.soecode.lyf.pushdemo;

import android.app.Activity;
import android.os.Bundle;

import com.umeng.message.PushAgent;

/**
 * Created by liyifeng on 2018/6/1.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PushAgent.getInstance(this).onAppStart();
    }
}
