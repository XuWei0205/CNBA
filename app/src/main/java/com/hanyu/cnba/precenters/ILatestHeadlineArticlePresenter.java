package com.hanyu.cnba.precenters;

import com.hanyu.cnba.models.LatestHeadlineArticleModel;
import com.hanyu.cnba.models.LatestHeadlineBannerModel;

/**
 * Created by Dell on 2016/12/23.
 */
public interface ILatestHeadlineArticlePresenter {
    void setDate(LatestHeadlineArticleModel data);
    void getDate(StringBuilder articleId);
}
