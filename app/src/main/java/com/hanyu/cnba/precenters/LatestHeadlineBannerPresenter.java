package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.ILatestHeadlineBannerData;
import com.hanyu.cnba.models.LatestHeadlineBannerModel;
import com.hanyu.cnba.models.LatestHeadlineBannerModelImpl;
import com.hanyu.cnba.views.ILatestHeadlineBannerView;

/**
 * Created by Dell on 2016/12/23.
 */
public class LatestHeadlineBannerPresenter implements ILatestHeadlineBannerPresenter {
    private ILatestHeadlineBannerData iLatestHeadlineDataModel;
    private ILatestHeadlineBannerView iLatestHeadlineBannerView;
    private Context mContext;


    public LatestHeadlineBannerPresenter(Context mContext,ILatestHeadlineBannerView iLatestHeadlineBannerView){
        this.mContext = mContext;
        this.iLatestHeadlineBannerView = iLatestHeadlineBannerView;
        iLatestHeadlineDataModel = new LatestHeadlineBannerModelImpl(mContext,this);
    }

    @Override
    public void setDate(StringBuilder sb) {
        iLatestHeadlineBannerView.setViewData(sb);
    }

    @Override
    public void getDate() {
        iLatestHeadlineDataModel.getLatestHeadlineInfo();
    }
}
