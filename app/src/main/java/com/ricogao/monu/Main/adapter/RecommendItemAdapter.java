package com.ricogao.monu.Main.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.ricogao.monu.Main.model.NewsItem;
import com.ricogao.monu.Main.model.RecommendItem;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/17.
 */

public class RecommendItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static String TAG = RecommendItemAdapter.class.getSimpleName();

    private final static int TYPE_HEADER = 0;
    private final static int TYPE_ITEM = 1;

    private List<RecommendItem> list;
    private List<NewsItem> news;
    private Context context;
    private OnRecommendItemClickListener listener;

    public RecommendItemAdapter(Context context, List<RecommendItem> list, List<NewsItem> news) {
        this.list = list;
        this.news = news;
        this.context = context;
    }

    public interface OnRecommendItemClickListener {
        void onItemClick(long id);
    }

    public void setListener(OnRecommendItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_layout, parent, false);
            return new NewsItemHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recommend_layout, parent, false);
            return new RecommendItemHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof NewsItemHolder) {
            NewsItemHolder nh = (NewsItemHolder) holder;

            nh.banner.setPages(new CBViewHolderCreator() {
                @Override
                public Object createHolder() {
                    return new NewsHolderView();
                }
            }, news)
                    .startTurning(5000)
                    .setPageIndicator(new int[]{R.drawable.page_indicator, R.drawable.page_indicator_selected})
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);


            nh.banner.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(context, news.get(position).getId() + "", Toast.LENGTH_SHORT).show();
                }
            });
        }


        if (holder instanceof RecommendItemHolder) {
            RecommendItemHolder rh = (RecommendItemHolder) holder;
            final RecommendItem item = list.get(position - 1);

            Picasso.with(context)
                    .load(item.getImgSrc())
                    .placeholder(R.drawable.placeholder)
                    .fit()
                    .centerCrop()
                    .into(rh.imgRecommend);

            rh.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(item.getId());
                    }
                }
            });

            rh.tvTitle.setText(item.getTitle());
            rh.tvLikes.setText(item.getLikes() + "");
            rh.tvName.setText(item.getName());
            rh.tvTrending.setVisibility(item.isTrending() ? View.VISIBLE : View.GONE);
            rh.btnLike.setSelected(item.isLiked());

            rh.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isSelected = view.isSelected();

                    item.setLiked(!isSelected);
                    view.setSelected(!isSelected);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }

        return TYPE_ITEM;
    }

    class RecommendItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.img_recommend)
        ImageView imgRecommend;
        @BindView(R.id.tv_recommend_title)
        TextView tvTitle;
        @BindView(R.id.tv_recommend_likes)
        TextView tvLikes;
        @BindView(R.id.tv_recommend_name)
        TextView tvName;
        @BindView(R.id.tv_recommend_trending)
        TextView tvTrending;
        @BindView(R.id.btn_like)
        ImageButton btnLike;

        RecommendItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class NewsItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.convenient_banner)
        ConvenientBanner banner;

        NewsItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
