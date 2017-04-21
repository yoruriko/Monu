package com.ricogao.monu.Main.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
import com.ricogao.monu.R;

import java.util.Locale;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ricogao on 2017/4/15.
 */

public class SettingActivity extends AppCompatActivity {

    @BindString(R.string.en_us)
    String enUs;
    @BindString(R.string.cn_zh)
    String cnZh;

    private SharedPreferencesUtil spUtil;

    @BindView(R.id.switch_deals_and_reward)
    Switch switchDeal;

    @BindView(R.id.switch_occasional_promos)
    Switch switchPromos;

    @BindView(R.id.switch_recommended_restaurant)
    Switch switchRecommend;

    @BindView(R.id.tv_language)
    TextView tvLanguage;

    @OnClick(R.id.panel_language)
    void onLanguageClick() {
        String items[] = new String[]{enUs, cnZh};

        new AlertDialog.Builder(this)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        changeLanguage(i);
                    }
                })
                .setTitle(R.string.language_title)
                .show();
    }

    @OnClick(R.id.panel_clear_image_cache)
    void onClearImageCache() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.clear_img_cache_title)
                .setMessage(R.string.clear_img_message)
                .setPositiveButton(R.string.confirm, null)
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    @OnClick(R.id.panel_clear_search_history)
    void onClearSearch() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.clear_history_title)
                .setMessage(R.string.clear_history_message)
                .setPositiveButton(R.string.confirm, null)
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void changeLanguage(int i) {

        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();

        Configuration config = resources.getConfiguration();

        if (i == 0) {
            config.setLocale(new Locale("en"));
            spUtil.saveLanguage("en");
        } else {
            config.setLocale(new Locale("zh"));
            spUtil.saveLanguage("zh");
        }
        resources.updateConfiguration(config, dm);

        restartActivities();

    }

    private void restartActivities() {
        Intent intent = new Intent(this, MainActivity.class);
        Intent intent1 = new Intent(this, SettingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        Intent intents[] = new Intent[]{intent, intent1};

        startActivities(intents);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.action_settings);
        }

        spUtil = new SharedPreferencesUtil(this);
        init();
    }

    private void init() {

        switchDeal.setChecked(spUtil.isDealAndReward());
        switchPromos.setChecked(spUtil.isPromos());
        switchRecommend.setChecked(spUtil.isRecommend());

        if (spUtil.getLanguage().equals("en")) {
            tvLanguage.setText(R.string.en_us);
        } else if (spUtil.getLanguage().equals("zh")) {
            tvLanguage.setText(R.string.cn_zh);
        }

        switchDeal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                spUtil.saveDealAndReward(b);
            }
        });

        switchPromos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                spUtil.savePromos(b);
            }
        });

        switchRecommend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                spUtil.saveRecommend(b);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
