package com.hanyu.cnba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanyu.cnba.R;
import com.hanyu.cnba.models.VideoModel;

import java.util.ArrayList;


/**
 * Created by Dell on 2016/12/28.
 */
public class VideoAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<VideoModel> mdatas = new ArrayList<>();
    private Context mContext;


    public VideoAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void setData(ArrayList<VideoModel> data) {
        mdatas.clear();
        mdatas.addAll(data);
    }

    @Override
    public int getCount() {
        return mdatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mdatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_video, null);
            holder = new Holder();
            holder.imgv_video = (ImageView) convertView.findViewById(R.id.imgv_video_content);
            holder.tv_video = (TextView) convertView.findViewById(R.id.tv_video_content);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        VideoModel  model = mdatas.get(position);
        holder.tv_video.setText(model.title);
        Glide.with(mContext).load(model.imgurl).into(holder.imgv_video);

        return convertView;
    }

    class Holder {
        ImageView imgv_video;
        TextView tv_video;
    }
}
