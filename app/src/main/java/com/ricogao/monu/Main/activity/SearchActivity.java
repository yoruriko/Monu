package com.ricogao.monu.Main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ricogao.monu.Main.adapter.SearchItemAdatper;
import com.ricogao.monu.Main.model.SearchItem;
import com.ricogao.monu.Main.widget.BounceBallView;
import com.ricogao.monu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ricogao on 2017/4/15.
 */

public class SearchActivity extends AppCompatActivity implements SearchItemAdatper.OnSearchItemClickListener {

    private final static String TAG = SearchActivity.class.getSimpleName();

    private final int SEARCH_FINISH = 123;

    private final int TYPE_NEARBY = 1;
    private final int TYPE_AUTHENTIC = 2;
    private final int TYPE_TRENDING = 3;

    private SearchItemAdatper adatper;
    private List<SearchItem> list;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SEARCH_FINISH) {
                stopLoadingAnim();
                showSearchResult((String) msg.obj);
            }
            super.handleMessage(msg);
        }
    };

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.panel_recent)
    LinearLayout panelRecent;
    @BindView(R.id.panel_filter)
    LinearLayout panelFilter;

    @BindView(R.id.btn_nearby)
    LinearLayout btnNearby;
    @BindView(R.id.btn_authentic)
    LinearLayout btnAuthentic;
    @BindView(R.id.btn_trending)
    LinearLayout btnTrending;

    @BindView(R.id.bounce_view)
    BounceBallView ballView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @OnClick({R.id.btn_nearby, R.id.btn_authentic, R.id.btn_trending})
    void onFilterClick(LinearLayout item) {

        btnNearby.setSelected(false);
        btnAuthentic.setSelected(false);
        btnTrending.setSelected(false);

        switch (item.getId()) {
            case R.id.btn_nearby:
                btnNearby.setSelected(true);
                setFilter(TYPE_NEARBY);
                break;
            case R.id.btn_authentic:
                btnAuthentic.setSelected(true);
                setFilter(TYPE_AUTHENTIC);
                break;
            case R.id.btn_trending:
                btnTrending.setSelected(true);
                setFilter(TYPE_TRENDING);
                break;
        }
    }


    @OnClick(R.id.btn_cancel)
    void onCancelClick() {
        clearSearch();
    }

    @OnClick(R.id.edt_search)
    void onEdtClick() {
        showPanel();
        loadRecent();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        init();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void init() {
        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(edtSearch.getText().toString());
                    return true;
                }

                return false;
            }
        });
    }

    private void performSearch(String key) {
        startLoadingAnim();

        mHandler.sendMessageDelayed(mHandler.obtainMessage(SEARCH_FINISH, key), 3000);
        hideKeyboard();
        hidePanel();
    }

    private void clearSearch() {

        stopLoadingAnim();

        edtSearch.setText("");
        recyclerView.setVisibility(View.INVISIBLE);
        hideKeyboard();
        showPanel();
    }

    private void showSearchResult(String key) {

        if (key.equals("sushi")) {
            list = new ArrayList<>();
            SearchItem item = new SearchItem();
            item.setName("Yamamoto");
            item.setKeywords("Traditional Japanese dish, Sushi");
            item.setDistance(21);
            item.setLikes(102);
            item.setSeats(22);
            item.setAvgCost(38.5f);
            item.setId(12);
            item.setImgSrc("https://s-media-cache-ak0.pinimg.com/564x/6b/2a/81/6b2a81e2466cca6db0d4d9ec8b328eaa.jpg");

            list.add(item);
            list.add(item);
            list.add(item);
        } else {
            list = new ArrayList<>();
        }

        if (adatper == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            adatper = new SearchItemAdatper(this, list);
            adatper.setListener(this);
            recyclerView.setAdapter(adatper);
        } else {
            adatper.setList(list);
            adatper.notifyDataSetChanged();
        }

        recyclerView.setVisibility(View.VISIBLE);
    }

    private void startLoadingAnim() {
        if (!ballView.isShown()) {
            ballView.setVisibility(View.VISIBLE);
        }

        if (!ballView.isAnimating()) {
            ballView.startAnim();
        }
    }

    private void stopLoadingAnim() {
        if (ballView.isShown()) {
            ballView.setVisibility(View.GONE);
        }

        if (ballView.isAnimating()) {
            ballView.stopAnim();
        }
    }

    private void loadRecent() {
        // TODO: 2017/4/16
    }

    private void setFilter(int type) {

        //// TODO: 2017/4/16
    }

    private void hidePanel() {
        if (panelRecent.isShown()) {
            panelRecent.setVisibility(View.GONE);
        }
        if (panelFilter.isShown()) {
            panelFilter.setVisibility(View.GONE);
        }
    }

    private void showPanel() {
        if (!panelRecent.isShown()) {
            panelRecent.setVisibility(View.VISIBLE);
        }

        if (!panelFilter.isShown()) {
            panelFilter.setVisibility(View.VISIBLE);
        }
    }

    private void hideKeyboard() {
        edtSearch.clearFocus();
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);
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
    public void onSearchItemClick(long id) {
        Intent it = new Intent(this, DetailActivity.class);
        startActivity(it);
    }
}
