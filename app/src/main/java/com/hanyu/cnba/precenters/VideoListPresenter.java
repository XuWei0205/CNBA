package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.IVideoListModel;
import com.hanyu.cnba.models.VideoListModelImpl;
import com.hanyu.cnba.views.IVideoListView;

/**
 * Created by Dell on 2016/12/28.
 */
public class VideoListPresenter implements IVideoListPresenter {
    private IVideoListModel model;
    private IVideoListView view;
    private Context mContext;
    public VideoListPresenter(Context mContext,IVideoListView view){
        this.view = view;
        this.mContext = mContext;
        model = new VideoListModelImpl(mContext,this);

    }

    @Override
    public void getData() {
        model.getDataInfo();
    }

    @Override
    public void setData(StringBuilder videoIds) {
       view.setViewData(videoIds);
    }
}
