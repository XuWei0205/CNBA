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
import com.hanyu.cnba.models.LatestHeadlineAbsArticleModel;
import com.hanyu.cnba.models.LatestHeadlineArticleDataModel;
import com.hanyu.cnba.models.MatchInfoModel;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/23.
 */
public class LatestHeadlineAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private ArrayList<LatestHeadlineAbsArticleModel> mDatas = new ArrayList<>();


    public void setDatas(ArrayList<LatestHeadlineAbsArticleModel> datas) {
        this.mDatas.clear();
        this.mDatas.addAll(datas);
    }

    public LatestHeadlineAdapter(Context mContext){
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);

    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {

        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_latest_headline,null);
            holder = new Holder();
            holder.imgv_article = (ImageView) convertView.findViewById(R.id.imgv_latest_headline);
            holder.tv_article = (TextView) convertView.findViewById(R.id.tv_latest_headline);
            convertView.setTag(holder);

        }else{
            holder = (Holder) convertView.getTag();
        }
        final LatestHeadlineAbsArticleModel dataModel = mDatas.get(position);
        String imgUrl = dataModel.imgurl;
        Glide.with(mContext).load(imgUrl).into(holder.imgv_article);
        holder.tv_article.setText(dataModel.title);
        return convertView;
    }
    static class Holder{
        public ImageView imgv_article;
        public TextView tv_article;

    }

}

