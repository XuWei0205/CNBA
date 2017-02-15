package com.hanyu.cnba.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.DataRankAdapter;
import com.hanyu.cnba.models.DataRankListModel;
import com.hanyu.cnba.models.PlayerModel;
import com.hanyu.cnba.precenters.DataRankListPresenter;
import com.hanyu.cnba.utils.Util;
import com.hanyu.cnba.views.IDataRankListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2016/12/27.
 */
public class DataChildFragment extends Fragment implements IDataRankListView {
    private DataRankListPresenter presenter;
    private ArrayList<PlayerModel> playerList = new ArrayList<>();
    private ListView lv_rank;
    private DataRankAdapter adapter;
    private String type;
    View rootView;
    @Bind(R.id.tv_data_name)
    TextView tv_dataName;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (rootView == null) {
           rootView = inflater.inflate(R.layout.data_frg_layout, container, false);
           ButterKnife.bind(this, rootView);
           lv_rank = (ListView) rootView.findViewById(R.id.lv_data_player);
           adapter = new DataRankAdapter(getActivity().getApplicationContext());
           lv_rank.setAdapter(adapter);
           getData(type);
           setChinesTip();
       }else{
           if (rootView.getParent() != null){
               ((ViewGroup)rootView.getParent()).removeView(rootView);
           }
       }
        return rootView;
    }


    public void setType(String type){
        this.type = type;
    }
    public void setChinesTip(){
        if("rebound".equals(type)){
            tv_dataName.setText(R.string.rebound);
        }else if ("point".equals(type)){
            tv_dataName.setText(R.string.point);
        }else if ("steal".equals(type)){
            tv_dataName.setText(R.string.steal);
        }else if ("block".equals(type)){
            tv_dataName.setText(R.string.block);
        }else if ("assist".equals(type)){
            tv_dataName.setText(R.string.assist);
        }
    }

    private void getData(String type){
        presenter = new DataRankListPresenter(getActivity().getApplicationContext(),this);
        presenter.getData(type,"10","1","2016");
    }

    @Override
    public void setViewData(DataRankListModel data) {
        if (data !=  null && data.data != null && data.data.point != null){
            playerList.clear();
            playerList.addAll(data.data.point);
            adapter.setData(playerList);
            adapter.notifyDataSetChanged();
        }else if (data !=  null && data.data != null && data.data.rebound != null){
            playerList.clear();
            playerList.addAll(data.data.rebound);
            adapter.setData(playerList);
            adapter.notifyDataSetChanged();
        }else if (data !=  null && data.data != null && data.data.steal != null){
            playerList.clear();
            playerList.addAll(data.data.steal);
            adapter.setData(playerList);
            adapter.notifyDataSetChanged();
        }else if (data !=  null && data.data != null && data.data.block != null){
            playerList.clear();
            playerList.addAll(data.data.block);
            adapter.setData(playerList);
            adapter.notifyDataSetChanged();
        }else if (data !=  null && data.data != null && data.data.assist != null){
            playerList.clear();
            playerList.addAll(data.data.assist);
            adapter.setData(playerList);
            adapter.notifyDataSetChanged();
        }else{
            Util.toastTips(getActivity().getApplicationContext(),"获取消息失败");
        }

    }
}
