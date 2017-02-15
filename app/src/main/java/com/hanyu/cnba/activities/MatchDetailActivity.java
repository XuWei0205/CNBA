package com.hanyu.cnba.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.managers.ActivityManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dell on 2016/12/29.
 */
public class MatchDetailActivity extends BasicActivity {
    @Bind(R.id.btn_back)
    TextView tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    public static void startActivity(Context context){
        Intent intent = new Intent(context,MatchDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    @OnClick({R.id.btn_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_back:
                onBackPressed();
                break;

        }
    }

    @Override
    void initView() {

    }

    @Override
    int getLayoutRes() {
        return R.layout.match_base_detail_layout;
    }

    @Override
    View getContentView() {
        return null;
    }

}
