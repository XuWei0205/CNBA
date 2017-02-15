package com.hanyu.cnba.precenters;

import com.hanyu.cnba.models.MatchListModel;

/**
 * Created by hehuajia on 16/12/21.
 */

public interface IMatchListPresenter {
    void setData(MatchListModel data,int source);
    void getData(String date,int source);

}
