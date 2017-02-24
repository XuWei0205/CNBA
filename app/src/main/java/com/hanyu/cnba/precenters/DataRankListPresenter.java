package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.DataRankListModel;
import com.hanyu.cnba.models.DataRankListModelIpml;
import com.hanyu.cnba.models.IDateRankListModel;
import com.hanyu.cnba.views.IDataRankListView;

/**
 * Created by Dell on 2016/12/25.
 */
public class DataRankListPresenter implements IDataRankListPresenter {
    private IDataRankListView iView;
    private IDateRankListModel iModel;
    private Context mContext;
    public DataRankListPresenter(Context mContext, IDataRankListView iView){
        this.mContext = mContext;
        this.iView = iView;
        iModel = new DataRankListModelIpml(mContext,this);


    }
    @Override
    public void setData(DataRankListModel data) {
        iView.setViewData(data);
    }

    @Override
    public void getData(String statType, String num, String tabType, String seasonId) {

        iModel.getLatestHeadlineInfo(statType,num,tabType,seasonId);
    }
}
