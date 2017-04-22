package com.ricogao.monu.Main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ricogao.monu.Main.adapter.RecommendItemAdapter;
import com.ricogao.monu.Main.model.NewsItem;
import com.ricogao.monu.Main.model.RecommendItem;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
import com.ricogao.monu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/16.
 */

public class MainFragment extends Fragment implements RecommendItemAdapter.OnRecommendItemClickListener {
    private final static String TAG = MainFragment.class.getSimpleName();

    private RecommendItemAdapter adapter;

    private List<NewsItem> items;

    private List<RecommendItem> list;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        initRecyclerView();
    }


    private void initRecyclerView() {
        SharedPreferencesUtil spUtil = new SharedPreferencesUtil(this.getContext());

        if (spUtil.getLanguage().equals("en")) {
            items = DataUtil.getNews();
            list = DataUtil.getRecommends();
        } else {
            items = DataUtil.getCNNews();
            list = DataUtil.getCNRecommends();
        }

        if (adapter == null) {
            adapter = new RecommendItemAdapter(this.getContext(), list, items);
            adapter.setListener(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(long id) {
        Toast.makeText(this.getContext(), id + "", Toast.LENGTH_SHORT).show();
    }
}
