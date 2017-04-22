package com.ricogao.monu.Main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.ricogao.monu.Main.adapter.DishHolderView;
import com.ricogao.monu.Main.model.CircleTransform;
import com.ricogao.monu.Main.model.Comment;
import com.ricogao.monu.Main.model.DishItem;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

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


    @BindView(R.id.img_profile1)
    ImageView imgProfile1;
    @BindView(R.id.img_profile2)
    ImageView imgProfile2;
    @BindView(R.id.img_profile3)
    ImageView imgProfile3;

    @BindView(R.id.tv_comment_name1)
    TextView tvCommentName1;
    @BindView(R.id.tv_comment_name2)
    TextView tvCommentName2;
    @BindView(R.id.tv_comment_name3)
    TextView tvCommentName3;

    @BindView(R.id.tv_comment1)
    TextView tvComment1;
    @BindView(R.id.tv_comment2)
    TextView tvComment2;
    @BindView(R.id.tv_comment3)
    TextView tvComment3;


    private DishItem item;
    private List<Comment> comments;

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
            comments = DataUtil.getComments();
        } else {
            item = DataUtil.getCNDish();
            comments = DataUtil.getCNComments();
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

        loadComments();
    }

    private void loadComments() {
        Picasso.with(this)
                .load(comments.get(0).getImgSrc())
                .placeholder(R.drawable.blank_profile)
                .fit()
                .centerCrop()
                .transform(new CircleTransform())
                .into(imgProfile1);

        Picasso.with(this)
                .load(comments.get(1).getImgSrc())
                .placeholder(R.drawable.blank_profile)
                .fit()
                .centerCrop()
                .transform(new CircleTransform())
                .into(imgProfile2);

        Picasso.with(this)
                .load(comments.get(2).getImgSrc())
                .placeholder(R.drawable.blank_profile)
                .fit()
                .centerCrop()
                .transform(new CircleTransform())
                .into(imgProfile3);

        tvCommentName1.setText(comments.get(0).getName());
        tvCommentName2.setText(comments.get(1).getName());
        tvCommentName3.setText(comments.get(2).getName());
        tvComment1.setText(comments.get(0).getComment());
        tvComment2.setText(comments.get(1).getComment());
        tvComment3.setText(comments.get(2).getComment());

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
