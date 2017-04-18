package com.ricogao.monu.Main.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricogao.monu.Main.model.Restaurant;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    private final static String TAG = DetailActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.img_restaurant)
    ImageView imgRestaurant;

    @BindView(R.id.tv_info)
    TextView tvInfo;

    @BindView(R.id.btn_liked)
    Button btnLiked;

    @OnClick(R.id.btn_liked)
    void onLickClick(Button button) {
        if (button.isSelected()) {
            button.setSelected(false);
        } else {
            button.setSelected(true);
        }
    }

    @OnClick(R.id.fab)
    void onFabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

    }

    private void init() {
        Restaurant item = new Restaurant();
        item.setId(123);
        item.setLiked(false);
        item.setLikes(142);
        item.setName("Yamamoto");
        item.setInfo("Sushi bar,Ealing Broadway,London");
        item.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(item.getName());
        }

        tvInfo.setText(item.getInfo());
        btnLiked.setText(item.getLikes() + " Likes");
        btnLiked.setSelected(item.isLiked());

        Picasso.with(this)
                .load(item.getImgSrc())
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(imgRestaurant);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
