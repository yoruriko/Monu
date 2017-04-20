package com.ricogao.monu.Main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/20.
 */

public class DishHolderView implements Holder<String> {
    @BindView(R.id.img_banner)
    ImageView imgBanner;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dish_banner_item_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        Picasso.with(context)
                .load(data)
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(imgBanner);
    }
}
