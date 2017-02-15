package com.hanyu.cnba.models;

/**
 * Created by Dell on 2016/12/25.
 */
public interface IDateRankListModel {
    void getLatestHeadlineInfo(String statType,String num,String tabType,String seasonId);
    //http://sportsnba.qq.com/player/statsRank?statType=point&num=25&tabType=1&seasonId=2016
}
