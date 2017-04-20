package com.ricogao.monu.Main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.ricogao.monu.Main.adapter.DishHolderView;
import com.ricogao.monu.Main.model.DishItem;
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

        item = new DishItem();

        item.setId(123);
        item.setName("Inari Sushi");
        item.setCalories(102f);
        item.setPrice(1.8f);

        item.setDescription("Sweet parcels of soft beancurd filled with sticky rice.");
        item.setIngredients("Sweet beancurd, sticky rice");
        item.setAllergens("Gluten, Soya, Wheat");
        item.setBestGoWith("Soy sauce, wasabi");
        item.setDishFacts("Inari is named for the shinto (A Japanese ethnic religion) god of fertility, rice and agriculture.");

        List<String> paths = new ArrayList<>();
        ;
        paths.add("http://www.allaboutsushiguide.com/images/inari-sushi-1.jpg");
        paths.add("http://www.delectablebakehouse.com/wp-content/uploads/2013/09/IMG_9798.jpg");
        paths.add("http://www.allaboutsushiguide.com/images/bigstock-Inari-Sushi-29945882-150.jpg");

        item.setImgSrcs(paths);


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
