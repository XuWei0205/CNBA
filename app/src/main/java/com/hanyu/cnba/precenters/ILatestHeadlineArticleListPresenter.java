package com.hanyu.cnba.precenters;

import com.hanyu.cnba.models.LatestHeadlineAbsArticleModel;
import com.hanyu.cnba.models.LatestHeadlineArticleListModel;

/**
 * Created by Dell on 2016/12/26.
 */
public interface ILatestHeadlineArticleListPresenter {
    void setData(LatestHeadlineAbsArticleModel data);
    void getData(StringBuilder articleIds);
}
