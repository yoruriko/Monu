package com.ricogao.monu.Main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricogao.monu.Main.model.Restaurant;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
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

    @BindView(R.id.tv_location)
    TextView tvLocation;

    @BindView(R.id.tv_phone1)
    TextView tvPhone1;
    @BindView(R.id.tv_phone2)
    TextView tvPhone2;

    @BindView(R.id.tv_opentime1)
    TextView tvWorkHour1;
    @BindView(R.id.tv_opentime2)
    TextView tvWorkHour2;

    @BindView(R.id.tv_seats)
    TextView tvSeats;

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
        Intent it = new Intent(this, MenuActivity.class);
        startActivity(it);
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
        Restaurant item;

        SharedPreferencesUtil spUtil = new SharedPreferencesUtil(this);
        if (spUtil.getLanguage().equals("en")) {
            item = DataUtil.getRestaurant();
        } else {
            item = DataUtil.getCNRestaurant();
        }


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(item.getName());
        }

        tvInfo.setText(item.getInfo());
        btnLiked.setText(item.getLikes() + "");
        btnLiked.setSelected(item.isLiked());
        tvLocation.setText(item.getAddress());
        tvPhone1.setText(item.getPhone1());
        tvPhone2.setText(item.getPhone2());
        tvWorkHour1.setText(item.getWorkHour1());
        tvWorkHour2.setText(item.getWorkHour2());
        tvSeats.setText(item.getSeatsState() + "");

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
