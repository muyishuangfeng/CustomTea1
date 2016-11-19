package com.yk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import com.yk.base.BaseActivity;
import com.yk.utils.SharepreferenceUtils;
import com.yk.R;

/**
 * Created by Silence on 2016/11/19.
 */

public class SplashActivity extends AppCompatActivity {
    //进入主页面
    public static final int GO_HOME = 0X01;
    //进入引导页面
    public static final int GO_GUID = 0X02;
    //等待时间
    public static final long SPLASH_WAIT_TIME = 3000;
    public SharepreferenceUtils mPrefernce;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initView();
        initData();
    }


    public void initView() {
        setContentView(R.layout.activity_splash);
        mPrefernce = new SharepreferenceUtils(getApplicationContext());
        //是否是第一次进入应用
        if (mPrefernce.getIsFirst().equals("1")){
            mHandler.sendEmptyMessageDelayed(GO_GUID,SPLASH_WAIT_TIME);
        }else{
            mHandler.sendEmptyMessageDelayed(GO_HOME,SPLASH_WAIT_TIME);
        }

    }


    public void initData() {

    }

    /**
     * 进入到主页面
     */
    public void goHome() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
       // Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 进入到引导页
     */
    public void goGuide() {
        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
        startActivity(intent);
        finish();
    }

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUID: {//进入引导页
                    goGuide();
                }
                break;
                case GO_HOME: {//进入主页面
                    goHome();
                }
                break;
            }
            super.handleMessage(msg);
        }
    };
}
