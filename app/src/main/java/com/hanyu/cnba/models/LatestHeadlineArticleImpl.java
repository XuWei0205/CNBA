package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.LatestHeadlineArticlePresenter;
import com.hanyu.cnba.utils.API;

import java.util.HashMap;

/**
 * Created by Dell on 2016/12/23.
 */
public class LatestHeadlineArticleImpl implements ILatestHeadlineArticleModel {
    private Context mContext;
    private LatestHeadlineArticlePresenter presenter;

    public LatestHeadlineArticleImpl(Context mContext, LatestHeadlineArticlePresenter presenter){
        this.mContext = mContext;
        this.presenter = presenter;

    }


    @Override
    public void getLatestHeadlineInfo(StringBuilder articleId) {
        HashMap<String ,String> map = new HashMap<>();
        map.put("column","banner");
        map.put("articleIds",articleId.toString());
        NetManager.doHttpGet(mContext, null, API.BASE_GET_LATEST_HEADLINE_ARTICLE, map, LatestHeadlineArticleModel.class, new NetManager.ResponseListener<LatestHeadlineArticleModel>() {
            @Override
            public void onResponse(LatestHeadlineArticleModel response) {
                presenter.setDate(response);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(LatestHeadlineArticleModel response) {

            }
        });
    }
}
