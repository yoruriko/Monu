package com.ricogao.monu.Main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.ricogao.monu.Main.adapter.NewsHolderView;
import com.ricogao.monu.Main.model.NewsItem;
import com.ricogao.monu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/16.
 */

public class MainFragment extends Fragment {
    private final static String TAG = MainFragment.class.getSimpleName();

    private List<NewsItem> items;

    @BindView(R.id.convenient_banner)
    ConvenientBanner banner;

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
        initBanner();

    }

    private void initBanner() {

        NewsItem item1 = new NewsItem();
        item1.setId(1);
        item1.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/cf/d1/d3/cfd1d353b6a196dfd7843787e212faa4.jpg");
        item1.setTitle("Most visited garden restaurants");
        item1.setSubTitle("latest ranking 2016-2017");

        NewsItem item2 = new NewsItem();
        item2.setId(2);
        item2.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c0/2e/ac/c02eac7cb5fe6082e1c091916832c660.jpg");
        item2.setTitle("Amazing under water restaurant");
        item2.setSubTitle("Experience you never had");

        NewsItem item3 = new NewsItem();
        item3.setId(3);
        item3.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");
        item3.setTitle("Best Sushi bar in the EU");
        item3.setSubTitle("Recommendation for Sushi lovers");

        NewsItem item4 = new NewsItem();
        item4.setId(4);
        item4.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/c1/26/4c/c1264c813c3c92336876bff7f806aa5c.jpg");
        item4.setTitle("Let's have some music");
        item4.setSubTitle("Jazz and amazing food");

        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new NewsHolderView();
            }
        }, items)
                .startTurning(5000)
                .setPageIndicator(new int[]{R.drawable.page_indicator, R.drawable.page_indicator_selected})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);


        banner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), items.get(position).getId() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
