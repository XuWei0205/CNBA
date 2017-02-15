package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.DataRankListPresenter;
import com.hanyu.cnba.utils.API;

import java.util.HashMap;

/**
 * Created by Dell on 2016/12/25.
 */
public class DataRankListModelIpml implements IDateRankListModel {
    private DataRankListPresenter presenter;
    private Context mContext;
    public DataRankListModelIpml(Context mContext,DataRankListPresenter presenter){
        this.presenter = presenter;
        this.mContext = mContext;
    }

    @Override
    public void getLatestHeadlineInfo(String statType, String num, String tabType, String seasonId) {
        HashMap<String ,String> map = new HashMap<>();
        //statType=point&num=25&tabType=1&seasonId=2016
        map.put("statType",statType);
        map.put("num",num);
        map.put("tabType",tabType);
        map.put("seasonId",seasonId);
        NetManager.doHttpGet(mContext, null, API.BASE_GET_RANK_LIST, map, DataRankListModel.class, new NetManager.ResponseListener<DataRankListModel>() {
            @Override
            public void onResponse(DataRankListModel response) {
                presenter.setData(response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(DataRankListModel response) {

            }
        });
    }
}
