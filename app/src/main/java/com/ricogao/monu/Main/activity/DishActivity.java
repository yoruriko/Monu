package com.ricogao.monu.Main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.ricogao.monu.Main.adapter.DishHolderView;
import com.ricogao.monu.Main.model.DishItem;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
import com.ricogao.monu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DishActivity extends AppCompatActivity {

    @BindView(R.id.banner)
    ConvenientBanner banner;
    @BindView(R.id.tv_calories)
    TextView tvCalories;
    @BindView(R.id.tv_dish_name)
    TextView tvName;
    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_ingredients)
    TextView tvIngredients;
    @BindView(R.id.tv_allergens)
    TextView tvAllergens;
    @BindView(R.id.tv_best_goes_with)
    TextView tvBestGoesWith;
    @BindView(R.id.tv_dish_facts)
    TextView tvDishFacts;

    private DishItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.dishes);
        }

        init();
    }

    private void init() {

        SharedPreferencesUtil spUtil = new SharedPreferencesUtil(this);
        if (spUtil.getLanguage().equals("en")) {
            item = DataUtil.getDish();
        } else {
            item = DataUtil.getCNDish();
        }

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new DishHolderView();
            }
        }, item.getImgSrcs());

        tvName.setText(item.getName());

        tvCalories.setText(String.format("%.1f", item.getCalories()) + " Cal");
        tvPrice.setText("$ " + String.format(" % .2f", item.getPrice()));

        tvDescription.setText(item.getDescription());
        tvIngredients.setText(item.getIngredients());
        tvAllergens.setText(item.getAllergens());
        tvBestGoesWith.setText(item.getBestGoWith());
        tvDishFacts.setText(item.getDishFacts());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
