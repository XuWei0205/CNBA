package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.LatestHeadlineBannerPresenter;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.Util;

import java.util.HashMap;

/**
 * Created by Dell on 2016/12/23.
 */
public class LatestHeadlineBannerModelImpl implements ILatestHeadlineBannerData {
    private Context mContext;
    private LatestHeadlineBannerPresenter presenter;

    public LatestHeadlineBannerModelImpl(Context context,LatestHeadlineBannerPresenter presenter){
        mContext = context;
        this.presenter = presenter;

    }
    @Override
    public void getLatestHeadlineInfo() {
        HashMap<String ,String> map = new HashMap<>();
        map.put("column","banner");
        NetManager.doHttpGet(mContext, null, API.BASE_GET_BANNER, map, LatestHeadlineBannerModel.class, new NetManager.ResponseListener<LatestHeadlineBannerModel>() {
            @Override
            public void onResponse(LatestHeadlineBannerModel response) {
                //presenter.setDate(response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(LatestHeadlineBannerModel response) {
                if (response != null && response.data != null && response.data.size() != 0) {
                    int size = response.data.size();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 20; i++) {
                        sb.append(response.data.get(i).id);
                        sb.append(",");
                    }
                    presenter.setDate(sb);
                }else{
                    Util.toastTips(mContext,"获取数据失败");
                }
            }
        });

    }
}
