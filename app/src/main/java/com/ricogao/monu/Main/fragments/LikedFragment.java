package com.ricogao.monu.Main.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ricogao.monu.Main.activity.DetailActivity;
import com.ricogao.monu.Main.adapter.SearchItemAdatper;
import com.ricogao.monu.Main.model.SearchItem;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
import com.ricogao.monu.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/22.
 */

public class LikedFragment extends Fragment implements SearchItemAdatper.OnSearchItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private SearchItemAdatper adatper;
    private List<SearchItem> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    private void init() {
        SharedPreferencesUtil spUtil = new SharedPreferencesUtil(this.getContext());
        if (spUtil.getLanguage().equals("en")) {
            list = DataUtil.getLikes();
        } else {
            list = DataUtil.getCNLikes();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        adatper = new SearchItemAdatper(this.getContext(), list);
        adatper.setListener(this);
        recyclerView.setAdapter(adatper);
    }


    @Override
    public void onSearchItemClick(long id) {
        Intent it = new Intent(this.getContext(), DetailActivity.class);
        startActivity(it);
    }
}
