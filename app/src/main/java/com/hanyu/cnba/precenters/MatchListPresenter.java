package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.IMatchModel;
import com.hanyu.cnba.models.MatchInfoModel;
import com.hanyu.cnba.models.MatchListModel;
import com.hanyu.cnba.models.MatchListModelImpl;
import com.hanyu.cnba.views.IMatchListView;
import com.hanyu.cnba.views.IView;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/21.
 */
public class MatchListPresenter implements IMatchListPresenter {
    private IMatchModel iMatchModel;
    private IMatchListView iMatchListView;
    private Context mContext;

    public MatchListPresenter(Context mContext,IMatchListView matchListView){
        this.mContext = mContext;
        iMatchListView = matchListView;
        iMatchModel = new MatchListModelImpl(mContext, this);
    }


    @Override
    public void setData(MatchListModel data,int source) {
        iMatchListView.setViewData(data,source);
    }



    @Override
    public void getData(String date,int source) {
        iMatchModel.getMatchInfo(date,source);
    }


}
