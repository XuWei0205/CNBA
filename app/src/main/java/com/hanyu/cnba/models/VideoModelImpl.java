package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.precenters.VideoPresenter;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.CLog;
import com.hanyu.cnba.utils.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2016/12/28.
 */
public class VideoModelImpl implements IVideoModel {
    private Context mContext;
    private VideoPresenter presenter;

    public VideoModelImpl(Context mContext,VideoPresenter presenter){
         this.presenter = presenter;
        this.mContext = mContext;
    }
    @Override
    public void getDataInfo(StringBuilder videoIds) {
        HashMap<String,String> map = new HashMap<>();
        map.put("column","videos");
        map.put("articleIds",videoIds.toString());
        NetManager.doHttpGet(mContext, null, API.BASE_GET_ARTICLE_LIST, map, VideoAbsModel.class, new NetManager.ResponseListener<VideoAbsModel>() {
            @Override
            public void onResponse(VideoAbsModel response) {
                if (response != null && response.data != null ){
                    Map<Long ,VideoModel> map = response.data;
                    for (VideoModel value : map.values()) {
                        if ( value.title != null) {
                            presenter.setDate(value);
                        }
                        CLog.i("value------------------>" + value);
                    }
                }else{
                    Util.toastTips(mContext,"读取数据失败");
                }

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(VideoAbsModel response) {


            }
        });
    }
}
