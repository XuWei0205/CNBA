package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.ILatestHeadlineArticleListMode;
import com.hanyu.cnba.models.LatestHeadlineAbsArticleModel;
import com.hanyu.cnba.models.LatestHeadlineArticleListImpl;
import com.hanyu.cnba.models.LatestHeadlineArticleListModel;
import com.hanyu.cnba.views.ILatestHeadlineArticleListView;

/**
 * Created by Dell on 2016/12/26.
 */
public class LatestHeadlineArticleListPresenter implements ILatestHeadlineArticleListPresenter {
    private ILatestHeadlineArticleListMode mode;
    private ILatestHeadlineArticleListView view;
    private Context mContext;

    public LatestHeadlineArticleListPresenter(Context mContext,ILatestHeadlineArticleListView view){
        this.view = view;
        mode = new LatestHeadlineArticleListImpl(mContext,this);
        this.mContext = mContext;

    }

    @Override
    public void setData(LatestHeadlineAbsArticleModel data) {
        view.setViewData(data);
    }

    @Override
    public void getData(StringBuilder articleIds) {
        mode.getDataInfo(articleIds);

    }
}
