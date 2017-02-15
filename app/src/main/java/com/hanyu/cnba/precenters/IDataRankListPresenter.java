package com.hanyu.cnba.precenters;

import com.hanyu.cnba.models.DataRankListModel;

/**
 * Created by Dell on 2016/12/25.
 */
public interface IDataRankListPresenter {
    void setData(DataRankListModel data);
    void getData(String statType, String num, String tabType, String seasonId);

}
