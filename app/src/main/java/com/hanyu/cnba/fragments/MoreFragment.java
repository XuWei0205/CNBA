package com.hanyu.cnba.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hanyu.cnba.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dell on 2016/12/21.
 */
public class MoreFragment extends BasicFragment {
    View rootView;
    @Bind(R.id.ly_team)
    RelativeLayout layout_team;
    @Bind(R.id.ly_player)
    RelativeLayout layout_player;
    @Bind(R.id.ly_qdsc)
    RelativeLayout layout_qdsc;
    @Bind(R.id.ly_ranking)
    RelativeLayout layout_ranking;
    @Bind(R.id.ly_pics)
    RelativeLayout layout_pics;
    @Bind(R.id.ly_date)
    RelativeLayout layout_date;
    @Bind(R.id.rly_shop)
    RelativeLayout layout_content;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.more_frg_layout, container, false);
//        layout_team.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"aaa",Toast.LENGTH_SHORT).show();
//            }
//        });
            ButterKnife.bind(this, rootView);
        }else{
            if (rootView.getParent() != null){
                ((ViewGroup) rootView.getParent()).removeView(rootView);
            }
        }
        return rootView;
    }

    @OnClick({R.id.ly_team, R.id.ly_player, R.id.ly_qdsc, R.id.ly_ranking, R.id.ly_pics, R.id.ly_date, R.id.rly_shop,})
    public void onClick(View view) {
        switch (view.getId()) {

        }
        Toast.makeText(getActivity(), "haha", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
