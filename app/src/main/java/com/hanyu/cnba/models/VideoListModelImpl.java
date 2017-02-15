package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.VideoListPresenter;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2016/12/28.
 */
public class VideoListModelImpl implements IVideoListModel {
    private VideoListPresenter presenter;
    private Context mContext;

    public VideoListModelImpl(Context mContext,VideoListPresenter presenter){
        this.mContext = mContext;
        this.presenter = presenter;
    }
    @Override
    public void getDataInfo() {
        Map<String ,String> map = new HashMap<>();
        map.put("column","videos");
        NetManager.doHttpGet(mContext, null, API.BASE_GET_BANNER, map, VideoListModel.class, new NetManager.ResponseListener<VideoListModel>() {
            @Override
            public void onResponse(VideoListModel response) {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(VideoListModel response) {
                if (response != null && response.data != null && response.data.size() != 0){
                    StringBuilder videoIds = new StringBuilder();
                    for (int i = 0 ; i < 5 ; i++){
                        videoIds.append(response.data.get(i).id);
                        videoIds.append(",");
                    }
                    presenter.setData(videoIds);
                }else {
                    Util.toastTips(mContext,"请求数据失败");
                }
            }
        });
    }
}
