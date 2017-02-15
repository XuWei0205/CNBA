package com.hanyu.cnba.views;

import android.widget.ListView;

import com.hanyu.cnba.adapters.MatchListAdapter;
import com.hanyu.cnba.models.IMatchModel;
import com.hanyu.cnba.models.MatchListModel;

/**
 * Created by Dell on 2016/12/19.
 */
public interface IMatchListView extends IView{
    void setViewData(MatchListModel data,int source);

}
