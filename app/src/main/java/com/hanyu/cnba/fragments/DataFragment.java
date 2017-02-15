package com.hanyu.cnba.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.DataFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dell on 2016/12/21.
 */
public class DataFragment extends BasicFragment {
    View rootView;
    @Bind(R.id.vp_data_frg)
    ViewPager vp_baseFrg;
    @Bind(R.id.leftImg)
    ImageView imgv_leftArrow;
    @Bind(R.id.rightImg)
    ImageView imgv_rightArrow;
    int curIndex = 0;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
if (rootView == null) {
    rootView = inflater.inflate(R.layout.data_base_layout, container, false);
    ButterKnife.bind(this, rootView);
   /* FragmentManager fgmM = getChildFragmentManager();
    Fragment mtcFgm = new MatchChildFragment();
    FragmentTransaction ft = fgmM.beginTransaction();
    ft.add(R.id.data_frg, mtcFgm, null);
    ft.commitAllowingStateLoss();*/

    DataChildFragment f1 = new DataChildFragment();
    f1.setType("rebound");
    DataChildFragment f2 = new DataChildFragment();
    f2.setType("point");
    DataChildFragment f3 = new DataChildFragment();
    f3.setType("steal");
    DataChildFragment f4 = new DataChildFragment();
    f4.setType("block");
    DataChildFragment f5 = new DataChildFragment();
    f5.setType("assist");


    // 将要分页显示的View装入数组中
    final List<Fragment> list = new ArrayList<>();
    list.add(f1);
    list.add(f2);
    list.add(f3);
    list.add(f4);
    list.add(f5);
    final DataFragmentAdapter adapter = new DataFragmentAdapter(getFragmentManager(), list);
    vp_baseFrg.setAdapter(adapter);
}else{
    if (rootView.getParent() != null){
        ((ViewGroup)rootView.getParent()).removeView(rootView);
    }
}
        return rootView;
    }
    @OnClick({R.id.leftImg,R.id.rightImg})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.leftImg:
                if (curIndex != 0  && curIndex > 0){
                    curIndex--;
                    vp_baseFrg.setCurrentItem(curIndex);
                }
            break;
            case R.id.rightImg:
                if (curIndex != 5 && curIndex <5){
                    curIndex ++;
                    vp_baseFrg.setCurrentItem(curIndex);
                }
        }
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
