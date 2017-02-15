package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.IVideoModel;
import com.hanyu.cnba.models.VideoModel;
import com.hanyu.cnba.models.VideoModelImpl;
import com.hanyu.cnba.views.IVideoView;

/**
 * Created by Dell on 2016/12/28.
 */
public class VideoPresenter implements IVideoPresenter {
    private IVideoView view;
    private IVideoModel model;
    private Context mContext;
    public VideoPresenter(Context mContext,IVideoView view){
        this.mContext = mContext;
        this.view = view ;
        model = new VideoModelImpl(mContext,this);
    }

    @Override
    public void getData(StringBuilder videoIds) {
        model.getDataInfo(videoIds);
    }

    @Override
    public void setDate(VideoModel data) {
        view.setViewData(data);

    }
}
