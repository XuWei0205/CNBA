package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.LatestHeadlineArticleListPresenter;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.CLog;
import com.hanyu.cnba.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dell on 2016/12/26.
 */
public class LatestHeadlineArticleListImpl implements ILatestHeadlineArticleListMode {
    private Context mContext;
    private LatestHeadlineArticleListPresenter presenter;

    public LatestHeadlineArticleListImpl(Context mContext,LatestHeadlineArticleListPresenter presenter){
        this.mContext = mContext;
        this.presenter = presenter;
    }

    @Override
    public void getDataInfo(StringBuilder articleIds) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("column","banner");
        map.put("articleIds",articleIds.toString());
        NetManager.doHttpGet(mContext, null, API.BASE_GET_ARTICLE_LIST, map, LatestHeadlineArticleListModel.class, new NetManager.ResponseListener<LatestHeadlineArticleListModel>() {
            @Override
            public void onResponse(LatestHeadlineArticleListModel response) {
                if (response != null && response.data != null ) {
                    Map<Long ,LatestHeadlineAbsArticleModel> map = response.data;
                    for (LatestHeadlineAbsArticleModel value : map.values()) {
                        if ( value.title != null) {
                            presenter.setData(value);
                        }
                        CLog.i("value------------------>"+ value);
                    }
                }else{
                    Util.toastTips(mContext,"获取数据失败");
                }
               // presenter.setData(response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(LatestHeadlineArticleListModel response) {
               /* if (response != null && response.data != null) {
                    Map<Long ,LatestHeadlineAbsArticleModel> map = response.data;
                    for (LatestHeadlineAbsArticleModel value : map.values()) {
                        presenter.setData(value);
                        CLog.i("value------------------>"+ value);
                    }
                }else{
                    Util.toastTips(mContext,"获取数据失败");
                }*/
            }
        });
    }
}
