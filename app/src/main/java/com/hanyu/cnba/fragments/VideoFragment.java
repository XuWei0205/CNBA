package com.hanyu.cnba.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.VideoAdapter;
import com.hanyu.cnba.models.VideoModel;
import com.hanyu.cnba.precenters.VideoListPresenter;
import com.hanyu.cnba.precenters.VideoPresenter;
import com.hanyu.cnba.views.IVideoListView;
import com.hanyu.cnba.views.IVideoView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2016/12/21.
 */
public class VideoFragment extends BasicFragment implements IVideoListView, IVideoView {
    View rootView;
    @Bind(R.id.lv_video)
    ListView lv_video;
    private VideoListPresenter listPresenter;
    private VideoPresenter videoPresenter;
    private ArrayList<VideoModel> datas = new ArrayList<>();
    private VideoAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.video_frg_layout, container, false);
            ButterKnife.bind(this, rootView);
            listPresenter = new VideoListPresenter(getActivity().getApplicationContext(), this);
            videoPresenter = new VideoPresenter(getActivity().getApplicationContext(), this);
            adapter = new VideoAdapter(getActivity().getApplicationContext());
            lv_video.setAdapter(adapter);
            getData();
        }else{
            if (rootView.getParent() != null){
                ((ViewGroup) rootView.getParent()).removeView(rootView);
            }
        }
        return rootView;
    }

    private void getData() {
        //listPresenter = new VideoListPresenter(getActivity().getApplicationContext(),this);
        listPresenter.getData();
    }

    @Override
    public void setViewData(StringBuilder videoIds) {

        videoPresenter.getData(videoIds);
    }

    @Override
    public void setViewData(VideoModel data) {
        datas.add(data);
        adapter.setData(datas);
        adapter.notifyDataSetChanged();
    }
}
