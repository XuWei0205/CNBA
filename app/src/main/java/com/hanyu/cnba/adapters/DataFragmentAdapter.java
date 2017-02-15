package com.hanyu.cnba.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hanyu.cnba.fragments.DataChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2016/12/27.
 */
public class DataFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;


    public DataFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

    @Override
    public int getCount() {
        return list.size();
    }//设置Item的数量

}
