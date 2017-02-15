package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.ILatestHeadlineArticleModel;
import com.hanyu.cnba.models.LatestHeadlineArticleImpl;
import com.hanyu.cnba.models.LatestHeadlineArticleModel;
import com.hanyu.cnba.views.ILatestHeadlineArticleView;

/**
 * Created by Dell on 2016/12/23.
 */
public class LatestHeadlineArticlePresenter implements ILatestHeadlineArticlePresenter  {
    private ILatestHeadlineArticleModel iLatestHeadlineArticleModel;
    private ILatestHeadlineArticleView iLatestHeadlineArticleView;
    private Context mContext;

    public  LatestHeadlineArticlePresenter(Context mContext,ILatestHeadlineArticleView iLatestHeadlineArticleView){
        this.mContext = mContext;
        this.iLatestHeadlineArticleView = iLatestHeadlineArticleView;
        iLatestHeadlineArticleModel = new LatestHeadlineArticleImpl(mContext,this);
    }
    @Override
    public void setDate(LatestHeadlineArticleModel data) {
        iLatestHeadlineArticleView.setAtcViewData(data);
    }

    @Override
    public void getDate(StringBuilder articleId) {
        iLatestHeadlineArticleModel.getLatestHeadlineInfo(articleId);
    }
}
