package com.ricogao.monu.Main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.ricogao.monu.Main.model.NewsItem;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/16.
 */

public class NewsHolderView implements Holder<NewsItem> {
    @BindView(R.id.img_news)
    ImageView imgNews;
    @BindView(R.id.tv_news_title)
    TextView tvTitle;
    @BindView(R.id.tv_news_subtitle)
    TextView tvSubTitle;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int position, NewsItem data) {
        Picasso.with(context)
                .load(data.getImgSrc())
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(imgNews);

        tvTitle.setText(data.getTitle());
        tvSubTitle.setText(data.getSubTitle());
    }
}
