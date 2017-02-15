package com.hanyu.cnba.activities;





import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.fragments.BasicFragment;
import com.hanyu.cnba.fragments.DataFragment;
import com.hanyu.cnba.fragments.LatestFragment;
import com.hanyu.cnba.fragments.MatchFragment;
import com.hanyu.cnba.fragments.MoreFragment;
import com.hanyu.cnba.fragments.VideoFragment;
import com.hanyu.cnba.managers.ActivityManager;
import com.hanyu.cnba.utils.CLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BasicActivity {
    private int currentFrg ;
    @Bind(R.id.head_title)
    TextView tv_title;
    @Bind(R.id.imgv_match)
    ImageView imgv_match;
    @Bind(R.id.tv_match)
    TextView tv_match;
    @Bind(R.id.imgv_latest)
    ImageView imgv_latest;
    @Bind(R.id.tv_latest)
    TextView tv_latest;
    @Bind(R.id.imgv_video)
    ImageView imgv_video;
    @Bind(R.id.tv_video)
    TextView tv_video;
    @Bind(R.id.imgv_data)
    ImageView imgv_data;
    @Bind(R.id.tv_data)
    TextView tv_data;
    @Bind(R.id.imgv_more)
    ImageView imgv_more;
    @Bind(R.id.tv_more)
    TextView tv_more;
   /* @Bind(R.id.pager)
    ViewPager vp_fragment;*/

    MatchFragment matchFragment;
    LatestFragment latestFragment;
    VideoFragment videoFragment;
    DataFragment dataFragment;
    MoreFragment moreFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        if (savedInstanceState == null){
            setDefaultFragment();
        }else {
            FragmentManager fgmM = getSupportFragmentManager();
            FragmentTransaction ft = fgmM.beginTransaction();
            BasicFragment fgm =(BasicFragment) getSupportFragmentManager().findFragmentByTag("match");
            if (fgm != null) {
                ft.replace(R.id.act_frg, fgm);
                ft.commitAllowingStateLoss();
            } else {
                setDefaultFragment();
            }
        }


    }

    private void setDefaultFragment() {
        currentFrg = 1;
        tv_title.setText("比赛");
        FragmentManager fgmM = getSupportFragmentManager() ;
       // Fragment mtcFgm = getFragmentManager().findFragmentByTag("tag");
        matchFragment = new MatchFragment();
        FragmentTransaction ft = fgmM.beginTransaction();
        ft.add(R.id.act_frg, matchFragment,"match");
        ft.commitAllowingStateLoss();
        imgv_match.setSelected(true);
        tv_match.setSelected(true);



    }

    @Override
    void initView() {


    }

    @Override
    int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    View getContentView() {
        return null;
    }
    @OnClick({R.id.layout_match, R.id.layout_latest, R.id.layout_video, R.id.layout_data, R.id.layout_more})
    public void onClick(View view) {
        BasicFragment fragment = null;
        int frgId = 1;
        String tag = "match";
        switch (view.getId()){
            case R.id.layout_match:
                if (matchFragment == null) {
                    matchFragment = new MatchFragment();
                }
                fragment = matchFragment;
                 frgId = 1;
                tag = "match";
                tv_title.setText("比赛");
                break;
            case R.id.layout_latest:
                if (latestFragment == null) {
                    latestFragment = new LatestFragment();
                }
                fragment  = latestFragment;
                frgId = 2;
                tag = "latest";
                tv_title.setText("最新");
                break;
            case R.id.layout_video:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                }
                fragment = videoFragment;
                frgId = 3;
                tag = "video";
                tv_title.setText("视频");
                break;
            case R.id.layout_data:
                if (dataFragment == null) {
                    dataFragment = new DataFragment();
                }
                fragment = dataFragment;
                frgId = 4;
                tag = "data";
                tv_title.setText("数据");
                break;
            case R.id.layout_more:
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                }
                fragment = moreFragment;
                frgId = 5;
                tag = "more";
                tv_title.setText("更多");
                break;
        }
        if(fragment != null) {
            changeFrg(fragment, frgId, tag);
        }

        changeBkg(view.getId());

    }

    private void changeFrg(BasicFragment fragment,int id,String tag){
        if(currentFrg != id) {

            FragmentManager fgmM = getSupportFragmentManager();
            FragmentTransaction ft = fgmM.beginTransaction();
            ft.replace(R.id.act_frg,fragment,tag);
            ft.commitAllowingStateLoss();
           /* FragmentManager fgmM = getSupportFragmentManager();
            FragmentTransaction ft = fgmM.beginTransaction();
            ft.replace(R.id.act_frg, fragment,tag);
            ft.commitAllowingStateLoss();*/
            currentFrg = id;
            CLog.i("+++++++++++++++++"+id+"+=====================");
        }

    }
    private void changeBkg(int id){
        switch (id) {
            case R.id.layout_match:
                imgv_match.setSelected(true);
                tv_match.setSelected(true);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);

                break;
            case R.id.layout_latest:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(true);
                tv_latest.setSelected(true);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);

                break;
            case R.id.layout_video:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(true);
                tv_video.setSelected(true);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);
                break;
            case R.id.layout_data:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(true);
                tv_data.setSelected(true);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);
                break;
            case R.id.layout_more:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(true);
                tv_more.setSelected(true);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityManager.finishAll();
    }
}
