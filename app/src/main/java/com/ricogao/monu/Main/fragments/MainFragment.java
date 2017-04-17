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
        list = new ArrayList<>();

        RecommendItem item1 = new RecommendItem();
        item1.setId(1);
        item1.setLiked(false);
        item1.setTitle("Take Me To Place I Never Knew");
        item1.setName("Ithaa, underwater restaurant");
        item1.setLikes(240);
        item1.setTrending(true);
        item1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c0/2e/ac/c02eac7cb5fe6082e1c091916832c660.jpg");


        RecommendItem item2 = new RecommendItem();
        item2.setId(2);
        item2.setLiked(true);
        item2.setTitle("Lovely garden restaurant");
        item2.setName("Welly garden, garden restaurant");
        item2.setLikes(169);
        item2.setTrending(false);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/cf/d1/d3/cfd1d353b6a196dfd7843787e212faa4.jpg");

        list.add(item1);
        list.add(item2);
        list.add(item2);
        list.add(item2);


        NewsItem news1 = new NewsItem();
        news1.setId(1);
        news1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/cf/d1/d3/cfd1d353b6a196dfd7843787e212faa4.jpg");
        news1.setTitle("Most visited garden restaurants");
        news1.setSubTitle("latest ranking 2016-2017");

        NewsItem news2 = new NewsItem();
        news2.setId(2);
        news2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c0/2e/ac/c02eac7cb5fe6082e1c091916832c660.jpg");
        news2.setTitle("Amazing under water restaurant");
        news2.setSubTitle("Experience you never had");

        NewsItem news3 = new NewsItem();
        news3.setId(3);
        news3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");
        news3.setTitle("Best Sushi bar in the EU");
        news3.setSubTitle("Recommendation for Sushi lovers");

        NewsItem news4 = new NewsItem();
        news4.setId(4);
        news4.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c1/26/4c/c1264c813c3c92336876bff7f806aa5c.jpg");
        news4.setTitle("Let's have some music");
        news4.setSubTitle("Jazz and amazing food");

        items = new ArrayList<>();
        items.add(news1);
        items.add(news2);
        items.add(news3);
        items.add(news4);

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
