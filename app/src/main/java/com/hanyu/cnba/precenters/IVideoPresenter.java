package com.hanyu.cnba.precenters;

import com.hanyu.cnba.models.VideoModel;

/**
 * Created by Dell on 2016/12/28.
 */
public interface IVideoPresenter {
    void getData(StringBuilder videoIds);
    void setDate(VideoModel data);
}
