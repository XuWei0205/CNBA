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

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.MatchFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2016/12/19.
 */
public class MatchFragment extends BasicFragment {
    View rootView;
    @Bind(R.id.vp_base_frg)
    ViewPager vp_baseFrg;
    private List<MatchChildFragment> list = new ArrayList<>();
    private MatchFragmentAdapter adapter;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        vp_baseFrg.setOffscreenPageLimit(5);
        if(rootView == null) {
            rootView = inflater.inflate(R.layout.match_base_frg, container, false);
            ButterKnife.bind(this, rootView);
            adapter = new MatchFragmentAdapter(getFragmentManager(), list);


            for (int i = -31; i < 32; i++) {
                MatchChildFragment fragment = new MatchChildFragment();
                fragment.setDay(i);
                list.add(fragment);
            }
            vp_baseFrg.setAdapter(adapter);
            vp_baseFrg.setCurrentItem(31);
            vp_baseFrg.setOffscreenPageLimit(5);
        }else {
            if (rootView.getParent() != null){
                ((ViewGroup) rootView.getParent()).removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }


}
