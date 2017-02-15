package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.MatchListPresenter;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.CLog;
import com.hanyu.cnba.utils.Date;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dell on 2016/12/21.
 */
public class MatchListModelImpl implements IMatchModel {
    private Context mContext;
    private MatchListPresenter mPresenter;


    public MatchListModelImpl(Context context,MatchListPresenter presenter){
        mContext =  context;
        mPresenter = presenter;
    }


    @Override
    public void getMatchInfo(String date, final int source) {
        HashMap<String, String> map = new HashMap<>();
        map.put("date", date);
        NetManager.doHttpGet(mContext, null, API.BASE_GET_MATCH_LIST, map, MatchListModel.class, new NetManager.ResponseListener<MatchListModel>() {
            @Override
            public void onResponse(MatchListModel response) {
                //CLog.i("Thread id onResponse: " + Thread.currentThread());
                if (response != null) {
                    mPresenter.setData(response,source);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(MatchListModel response) {

            }
        });
    }



}
