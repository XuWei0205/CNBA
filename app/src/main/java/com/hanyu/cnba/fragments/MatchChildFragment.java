package com.hanyu.cnba.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.MatchListAdapter;
import com.hanyu.cnba.models.MatchInfoModel;
import com.hanyu.cnba.models.MatchListModel;
import com.hanyu.cnba.precenters.IMatchListPresenter;
import com.hanyu.cnba.precenters.MatchListPresenter;
import com.hanyu.cnba.utils.Date;
import com.hanyu.cnba.utils.LocalDisplay;
import com.hanyu.cnba.utils.Util;
import com.hanyu.cnba.views.IMatchListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * Created by Dell on 2016/12/26.
 */
public class MatchChildFragment extends Fragment implements IMatchListView {
    View rootView;
    @Bind(R.id.match_day)
    TextView tv_tip;
    @Bind(R.id.lv_match)
    ListView lv_match;
    //@Bind(R.id.item_game_text_left)
    //TextView tv_gameDetil;

    private ArrayList<MatchInfoModel> datas = new ArrayList<>();
    private MatchListAdapter matchListAdapter;
    private IMatchListPresenter presenter;
    private Handler handler = new Handler();
    private PtrFrameLayout mPtrFrame;
    private String date ;
    private int day;

    /**
     * 请求刷新开关，ON时时可以刷新 在onDestroy方法里设为OFF 每次创建Fragment时设为ON
     */
    private String refreshSwitch = "ON";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.match_frg_layout, container, false);
            ButterKnife.bind(this, rootView);
            getData();
            refreshSwitch = "ON";
            matchListAdapter = new MatchListAdapter(getActivity().getApplicationContext());
            //tv_tip = (TextView) view.findViewById(R.id.match_day);
            //lv_match = (ListView) view.findViewById(R.id.lv_match);
            lv_match.setAdapter(matchListAdapter);


            /** 设置mPtrFrame **/
            mPtrFrame = (PtrFrameLayout) rootView.findViewById(R.id.list_frame);
            final MaterialHeader header = new MaterialHeader(getActivity().getApplicationContext());
            int[] colors = getResources().getIntArray(R.array.google_colors);
            header.setColorSchemeColors(colors);
            header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
            header.setPadding(0, LocalDisplay.dp2px(15), 0, LocalDisplay.dp2px(10));
            header.setPtrFrameLayout(mPtrFrame);

            mPtrFrame.setLoadingMinTime(1000);
            mPtrFrame.setDurationToCloseHeader(1500);
            mPtrFrame.setHeaderView(header);
            mPtrFrame.addPtrUIHandler(header);
            mPtrFrame.setResistance(4.0f);//设置提抗力
            mPtrFrame.setRatioOfHeaderHeightToRefresh(0.2f);//触发刷新时移动的位置比例
            mPtrFrame.setDurationToClose(3000);//回弹延时
            mPtrFrame.setDurationToCloseHeader(1000);//头部回弹时间
            mPtrFrame.setPullToRefresh(false);//
            mPtrFrame.setKeepHeaderWhenRefresh(true);
            mPtrFrame.disableWhenHorizontalMove(true);
            mPtrFrame.setPtrHandler(new PtrHandler() {
                @Override
                public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                    return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);

                }

                @Override
                public void onRefreshBegin(PtrFrameLayout frame) {
                    presenter.getData(date, 2);


                }
            });

        }else{
            if(rootView.getParent() != null){
                ((ViewGroup)rootView.getParent()).removeView(rootView);
            }
        }
        return rootView;
    }

    public void reFresh() {
        datas.clear();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getData(date, 1);

            }
        }, 10000);
    }

    public void getData() {
        presenter = new MatchListPresenter(getActivity().getApplicationContext(), this);
        presenter.getData(date, 1);
    }

    public void setDay(int day){
        this.day = day;
        date = new Date().getDate(day);
    }

    @Override
    public void setViewData(MatchListModel data, int source) {
        if (source == 2) {
            mPtrFrame.refreshComplete();
            datas.clear();
            matchListAdapter.notifyDataSetChanged();
        }
        if (data != null && data.data != null && data.data.matches != null) {
            if (data.data.matches.size() == 0) {
                tv_tip.setText(date + getString(R.string.no_match));
            } else {
                tv_tip.setText(date);
                int size = data.data.matches.size();
                for (int i = 0; i < size; i++) {
                    datas.add(data.data.matches.get(i).matchInfo);
                    matchListAdapter.setDatas(datas);
                    matchListAdapter.notifyDataSetChanged();
                }
                if (data.data.matches.get(0).updateFrequency != null && "10".equals(data.data.matches.get(0).updateFrequency) && "ON".equals(refreshSwitch) && source == 1) {
                    reFresh();
                }
            }


        } else {
            // 网络获取失败，提示
            Util.toastTips(getActivity().getApplicationContext(), "请求数据失败");
        }
    }



    @Override
    public void onDestroy() {
        refreshSwitch = "OFF";
        super.onDestroy();


    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

}
