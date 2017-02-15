package com.hanyu.cnba.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.hanyu.cnba.R;



/**
 * Created by Dell on 2016/12/21.
 */
public class SplashActivity extends BasicActivity{
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);


            }
        }, 3000);

    }

    @Override
    void initView() {

    }

    @Override
    int getLayoutRes() {
        return R.layout.splash_layout;
    }

    @Override
    View getContentView() {
        return null;
    }
}
