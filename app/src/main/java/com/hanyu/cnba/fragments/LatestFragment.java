package com.hanyu.cnba.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.LatestHeadlineAdapter;
import com.hanyu.cnba.models.LatestHeadlineAbsArticleModel;
import com.hanyu.cnba.precenters.LatestHeadlineArticleListPresenter;
import com.hanyu.cnba.precenters.LatestHeadlineBannerPresenter;
import com.hanyu.cnba.views.ILatestHeadlineArticleListView;
import com.hanyu.cnba.views.ILatestHeadlineBannerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2016/12/21.
 */
public class LatestFragment extends BasicFragment implements ILatestHeadlineBannerView, ILatestHeadlineArticleListView {
    View rootView;
    @Bind(R.id.lv_latest_headline)
    ListView lv_headline;

    private LatestHeadlineBannerPresenter banPresenter;
    private LatestHeadlineArticleListPresenter atcPresenter;
    private ArrayList<LatestHeadlineAbsArticleModel> datas = new ArrayList<>();
    private LatestHeadlineAdapter adapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.latest_frg_layout, container, false);
            ButterKnife.bind(this, rootView);
            adapter = new LatestHeadlineAdapter(getActivity().getApplicationContext());
            lv_headline.setAdapter(adapter);
            getData();
        }else{
            if (rootView.getParent() != null){
                ((ViewGroup)rootView.getParent()).removeView(rootView);
            }
        }
        return rootView;
    }

    public void getData() {
        banPresenter = new LatestHeadlineBannerPresenter(getActivity().getApplicationContext(), this);
        banPresenter.getDate();
    }

    public void getArticle(StringBuilder articleIds) {

        atcPresenter = new LatestHeadlineArticleListPresenter(getActivity().getApplicationContext(), this);
        atcPresenter.getData(articleIds);

    }

    @Override
    public void setViewData(StringBuilder articleIds) {
        getArticle(articleIds);

    }


    @Override
    public void setViewData(LatestHeadlineAbsArticleModel data) {
        datas.add(data);
        adapter.setDatas(datas);
        adapter.notifyDataSetChanged();

    }
}

