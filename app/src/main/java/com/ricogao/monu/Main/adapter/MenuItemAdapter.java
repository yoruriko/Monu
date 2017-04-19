package com.ricogao.monu.Main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ricogao.monu.Main.model.MenuItem;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/19.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static String TAG = MenuItemAdapter.class.getSimpleName();

    private Context context;
    private List<MenuItem> list;

    private OnMenuItemClickListener listener;

    public interface OnMenuItemClickListener {
        void onMenuItemClick(long id);
    }

    public void setList(List<MenuItem> list) {
        this.list = list;
    }

    public void setListener(OnMenuItemClickListener listener) {
        this.listener = listener;
    }

    public MenuItemAdapter(Context context, List<MenuItem> list) {
        this.context = context;
        this.list = list;
    }

    class MenuItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.menu_item)
        RelativeLayout menuItem;
        @BindView(R.id.img_menu)
        ImageView imgMenu;
        @BindView(R.id.tv_menu_name)
        TextView tvMenuName;
        @BindView(R.id.img_label)
        ImageView imgLabel;

        public MenuItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_layout, parent, false);
        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MenuItem item = list.get(position);
        MenuItemViewHolder mh = (MenuItemViewHolder) holder;


        Picasso.with(context)
                .load(item.getImgSrc())
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(mh.imgMenu);

        mh.tvMenuName.setText(item.getName());
        mh.menuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMenuItemClick(item.getId());
                }
            }
        });

        if (item.isSpicy()) {
            mh.imgLabel.setVisibility(View.VISIBLE);
            mh.imgLabel.setImageResource(R.drawable.ic_spicy);
        }

        if (item.isVeg()) {
            mh.imgLabel.setVisibility(View.VISIBLE);
            mh.imgLabel.setImageResource(R.drawable.ic_veg);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
