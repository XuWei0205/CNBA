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
import com.hanyu.cnba.models.PlayerModel;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Dell on 2016/12/25.
 */
public class DataRankAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private ArrayList<PlayerModel> mData = new ArrayList<>();

    public DataRankAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);

    }
    public void setData(ArrayList<PlayerModel> playerModels){
        mData.clear();
        mData.addAll(playerModels);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_data_player, null);
            holder = new Holder();
            holder.imgv_playerIcon = (ImageView)convertView.findViewById(R.id.playerIcon);
            holder.imgv_teamIcon = (ImageView) convertView.findViewById(R.id.teamIcon);
            holder.tv_jerseyNum = (TextView) convertView.findViewById(R.id.jerseyNum);
            holder.tv_playerCnName = (TextView) convertView.findViewById(R.id.playerCnName);
            holder.tv_teamName = (TextView) convertView.findViewById(R.id.teamName);
            holder.tv_valueNum = (TextView) convertView.findViewById(R.id.valueNum);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        PlayerModel playerModel = mData.get(position);
        holder.tv_jerseyNum.setText("第"+ playerModel.serial);
        holder.tv_valueNum.setText(playerModel.value);
        holder.tv_playerCnName.setText(playerModel.playerName);
        holder.tv_teamName.setText(playerModel.teamName);
        Glide.with(mContext).load(playerModel.teamIcon).into(holder.imgv_teamIcon);
        Glide.with(mContext).load(playerModel.playerIcon).into(holder.imgv_playerIcon);


        return convertView;
    }

    class Holder {
        TextView tv_jerseyNum;
        TextView tv_valueNum;
        TextView tv_playerCnName;
        TextView tv_teamName;
        ImageView imgv_playerIcon;
        ImageView imgv_teamIcon;

    }
}
