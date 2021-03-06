package com.ricogao.monu.Main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.ricogao.monu.Main.adapter.MenuItemAdapter;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
import com.ricogao.monu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements MenuItemAdapter.OnMenuItemClickListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @BindView(R.id.recycler_view)
    RecyclerView recycler;

    private MenuItemAdapter adapter;

    private SharedPreferencesUtil spUtil;
    private List<com.ricogao.monu.Main.model.MenuItem> list;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    if (spUtil.getLanguage().equals("en")) {
                        list = DataUtil.getMenu();
                    } else {
                        list = DataUtil.getCNMenu();
                    }
                    init();
                    return true;
                case R.id.navigation_sides:
                    if (spUtil.getLanguage().equals("en")) {
                        list = DataUtil.getSides();
                    } else {
                        list = DataUtil.getCNSides();
                    }
                    init();
                    return true;
                case R.id.navigation_dessert:
                    if (spUtil.getLanguage().equals("en")) {
                        list = DataUtil.getDessert();
                    } else {
                        list = DataUtil.getCNDessert();
                    }
                    init();
                    return true;
                case R.id.navigation_drink:
                    if (spUtil.getLanguage().equals("en")) {
                        list = DataUtil.getDrinks();
                    } else {
                        list = DataUtil.getCNDrinks();
                    }
                    init();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.menu);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        spUtil = new SharedPreferencesUtil(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        init();
    }

    private void init() {


        if (adapter == null) {

            if (spUtil.getLanguage().equals("en")) {
                list = DataUtil.getMenu();
            } else {
                list = DataUtil.getCNMenu();
            }


        }

        adapter = new MenuItemAdapter(this, list);
        adapter.setListener(this);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMenuItemClick(long id) {
        Intent it = new Intent(this, DishActivity.class);
        startActivity(it);
    }
}
