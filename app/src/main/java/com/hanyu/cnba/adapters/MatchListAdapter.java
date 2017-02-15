package com.hanyu.cnba.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanyu.cnba.R;
import com.hanyu.cnba.activities.MatchDetailActivity;
import com.hanyu.cnba.models.MatchInfoModel;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/21.
 */
public class MatchListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    public ArrayList<MatchInfoModel> mDatas = new ArrayList<>();
    public MatchListAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }
    public void setDatas(ArrayList<MatchInfoModel> datas) {
        this.mDatas.clear();
        this.mDatas.addAll(datas);
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public MatchInfoModel getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_match, null);
            holder = new Holder();
            holder.item_game_relativelayout_left = (RelativeLayout) convertView.findViewById(R.id.item_game_relativelayout_left);

            holder.imgv_item_game_image_left = (ImageView) convertView.findViewById(R.id.item_game_image_left);
            holder.imgv_item_game_image_right = (ImageView) convertView.findViewById(R.id.item_game_image_right);
            holder.tv_item_game_text_score_left = (TextView) convertView.findViewById(R.id.item_game_text_score_left);
            holder.tv_item_game_text_score_right = (TextView) convertView.findViewById(R.id.item_game_text_score_right);
            holder.tv_item_game_text_left_name = (TextView) convertView.findViewById(R.id.item_game_text_left_name);
            holder.tv_item_game_text_right_name = (TextView) convertView.findViewById(R.id.item_game_text_right_name);
            holder.tv_item_game_title_type = (TextView)convertView.findViewById(R.id.item_game_title_type);
            holder.tv_item_game_title_right = (TextView)convertView.findViewById(R.id.item_game_title_right);
            holder.tv_item_game_title_left = (TextView)convertView.findViewById(R.id.item_game_title_left);
            holder.tv_item_game_title_center = (TextView)convertView.findViewById(R.id.item_game_title_center);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final MatchInfoModel infoModel = mDatas.get(position);
        holder.tv_item_game_text_score_left.setText(infoModel.leftGoal);
        holder.tv_item_game_text_score_right.setText(infoModel.rightGoal);
        int compare =(infoModel.leftGoal).compareTo(infoModel.rightGoal);
        int size =  infoModel.leftGoal.length() - infoModel.rightGoal.length();
        if ((compare > 0 && size == 0) || size > 0){
            holder.tv_item_game_text_score_left.setTextColor(Color.BLACK);
            holder.tv_item_game_text_score_right.setTextColor(Color.GRAY);
        }else if((compare < 0 && size == 0) || size < 0 ){
            holder.tv_item_game_text_score_left.setTextColor(Color.GRAY);
            holder.tv_item_game_text_score_right.setTextColor(Color.BLACK);
        }else if (compare == 0){
            holder.tv_item_game_text_score_left.setTextColor(Color.GRAY);
            holder.tv_item_game_text_score_right.setTextColor(Color.GRAY);
        }
        holder.tv_item_game_text_left_name.setText(infoModel.leftName);
        holder.tv_item_game_text_right_name.setText(infoModel.rightName);
        holder.tv_item_game_title_type.setText(infoModel.matchDesc);
        Glide.with(mContext).load(infoModel.leftBadge).into(holder.imgv_item_game_image_left);
        Glide.with(mContext).load(infoModel.rightBadge).into(holder.imgv_item_game_image_right);
        if(("第4节".equals(infoModel.quarter)|| "加时1".equals(infoModel.quarter) ||"加时2".equals(infoModel.quarter)) && "00:00".equals(infoModel.quarterTime)){
            holder.tv_item_game_title_center.setText("比赛结束");
            holder.tv_item_game_title_center.setTextColor(Color.BLACK);
            holder.tv_item_game_title_left.setText("");
            holder.tv_item_game_title_right.setText("");


        }else if ("".equals(infoModel.quarter)) {
            holder.tv_item_game_title_center.setText("于"+infoModel.startTime +"开始");
            holder.tv_item_game_title_center.setTextColor(Color.GRAY);
            holder.tv_item_game_title_left.setText("");
            holder.tv_item_game_title_right.setText("");


        } else {
            holder.tv_item_game_title_center.setText(infoModel.quarter);
            holder.tv_item_game_title_center.setTextColor(Color.RED);
            holder.tv_item_game_title_left.setText("直播");
            holder.tv_item_game_title_left.setTextColor(Color.RED);
            holder.tv_item_game_title_right.setText(infoModel.quarterTime);
            holder.tv_item_game_title_right.setTextColor(Color.RED);
        }

        holder.item_game_relativelayout_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchDetailActivity.startActivity(mContext);
            }
        });
        return convertView;
    }



    static class Holder {
        public RelativeLayout item_game_relativelayout_left;
        public ImageView imgv_item_game_image_left;
        public ImageView imgv_item_game_image_right;
        public TextView tv_item_game_text_left_name;
        public TextView tv_item_game_text_right_name;
        public TextView tv_item_game_text_score_left;
        public TextView tv_item_game_text_score_right;
        public TextView tv_item_game_title_center;
        public TextView tv_item_game_title_left;
        public TextView tv_item_game_title_right;
        public TextView tv_item_game_title_type;

    }
}
