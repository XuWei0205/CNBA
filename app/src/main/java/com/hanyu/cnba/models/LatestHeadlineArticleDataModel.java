package com.hanyu.cnba.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/23.
 */
public class LatestHeadlineArticleDataModel {
    public String title ;
    @SerializedName("abstract")
    public String abs;
    public ArrayList<LatestHeadlineArticleContentModel> content;
    public String url;
    public String imgurl;
    public String imgurl1;
    public String imgurl2;
    public String pub_time;
    public String atype;
    public String commentId;
    public String newsAppId;
    public String source;
    public String commentsNum;
    public String upNum;
    public String pub_time_new;
    public String isCollect;

}
