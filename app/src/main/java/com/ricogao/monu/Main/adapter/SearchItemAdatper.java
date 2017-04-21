package com.ricogao.monu.Main.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ricogao.monu.Main.model.SearchItem;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/17.
 */

public class SearchItemAdatper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static String TAG = SearchItemAdatper.class.getSimpleName();

    private Context context;
    private List<SearchItem> list;
    private OnSearchItemClickListener listener;

    private final int TYPE_FOOTER = -1;
    private final int TYPE_ITEM = 0;

    public SearchItemAdatper(Context context, List<SearchItem> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<SearchItem> list) {
        this.list = list;
    }

    public interface OnSearchItemClickListener {
        void onSearchItemClick(long id);
    }

    public void setListener(OnSearchItemClickListener listener) {
        this.listener = listener;
    }

    class SearchItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_keywords)
        TextView tvKeywords;
        @BindView(R.id.tv_cost)
        TextView tvCost;
        @BindView(R.id.tv_distance)
        TextView tvDistance;
        @BindView(R.id.tv_likes)
        TextView tvLikes;
        @BindView(R.id.tv_seats)
        TextView tvSeats;
        @BindView(R.id.img_search)
        ImageView imgSearch;

        SearchItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.panel_no_result)
        LinearLayout panelNoResult;

        FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_footer_layout, parent, false);
            return new FooterViewHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searach_item_layout, parent, false);

        return new SearchItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SearchItemViewHolder) {
            SearchItemViewHolder sh = (SearchItemViewHolder) holder;
            final SearchItem item = list.get(position);

            sh.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onSearchItemClick(item.getId());
                    }
                }
            });

            sh.tvName.setText(item.getName());
            sh.tvKeywords.setText(item.getKeywords());
            sh.tvDistance.setText(String.format("%.1f", item.getDistance()) + " km");
            sh.tvLikes.setText(item.getLikes() + "");
            sh.tvSeats.setText(item.getSeats() + "");
            sh.tvCost.setText("$" + String.format("%.1f", item.getAvgCost()));

            Picasso.with(context)
                    .load(item.getImgSrc())
                    .placeholder(R.drawable.placeholder)
                    .fit()
                    .centerCrop()
                    .into(sh.imgSearch);
        }

        if (holder instanceof FooterViewHolder) {
            FooterViewHolder fh = (FooterViewHolder) holder;

            if (list.size() == 0) {
                fh.panelNoResult.setVisibility(View.VISIBLE);
            } else {
                fh.panelNoResult.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }
}
