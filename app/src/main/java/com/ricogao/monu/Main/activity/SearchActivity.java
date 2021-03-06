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
import android.widget.Switch;
import android.widget.TextView;

import com.ricogao.monu.Main.adapter.SearchItemAdatper;
import com.ricogao.monu.Main.model.SearchItem;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.Main.utils.SharedPreferencesUtil;
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

    private List<String> searchHistory;

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


    @BindView(R.id.chip_1)
    View chip1;
    @BindView(R.id.chip_2)
    View chip2;
    @BindView(R.id.chip_3)
    View chip3;
    @BindView(R.id.tv_chip_1)
    TextView tvChip1;
    @BindView(R.id.tv_chip_2)
    TextView tvChip2;
    @BindView(R.id.tv_chip_3)
    TextView tvChip3;


    @OnClick(R.id.btn_chip_1)
    void onChip1Cancel() {
        searchHistory.remove(tvChip1.getText().toString());
        updateChips();
    }

    @OnClick(R.id.btn_chip_2)
    void onChip2Cancel() {
        searchHistory.remove(tvChip2.getText().toString());
        updateChips();
    }

    @OnClick(R.id.btn_chip_3)
    void onChip3Cancel() {
        searchHistory.remove(tvChip3.getText().toString());
        updateChips();
    }

    @OnClick(R.id.chip_1)
    void onChip1Click() {
        edtSearch.setText(tvChip1.getText());
        performSearch(tvChip1.getText().toString());
    }

    @OnClick(R.id.chip_2)
    void onChip2Click() {
        edtSearch.setText(tvChip2.getText());
        performSearch(tvChip1.getText().toString());
    }

    @OnClick(R.id.chip_3)
    void onChip3Click() {
        edtSearch.setText(tvChip3.getText());
        performSearch(tvChip1.getText().toString());
    }


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
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        searchHistory = new ArrayList<>();
        searchHistory.add("sushi");
        searchHistory.add("hamburger");
        searchHistory.add("steak");

        init();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void init() {

        updateChips();
        btnNearby.setSelected(true);
        setFilter(TYPE_NEARBY);

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

    private void updateChips() {
        if (searchHistory.size() >= 3) {
            tvChip3.setText(searchHistory.get(2));
            chip3.setVisibility(View.VISIBLE);
        } else {
            chip3.setVisibility(View.GONE);
        }

        if (searchHistory.size() >= 2) {
            tvChip2.setText(searchHistory.get(1));
            chip2.setVisibility(View.VISIBLE);
        } else {
            chip2.setVisibility(View.GONE);
        }

        if (searchHistory.size() >= 1) {
            tvChip1.setText(searchHistory.get(0));
            chip1.setVisibility(View.VISIBLE);
        } else {
            chip1.setVisibility(View.GONE);
        }
    }

    private void performSearch(String key) {
        startLoadingAnim();

        if (!searchHistory.contains(key)) {
            searchHistory.add(0, key);
        }

        updateChips();

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

        SharedPreferencesUtil spUtil = new SharedPreferencesUtil(this);

        if (key.equals("sushi") || key.equals("寿司")) {
            if (spUtil.getLanguage().equals("en")) {
                list = DataUtil.getSearchResult();
            } else {
                list = DataUtil.getCNSearchResult();
            }

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


    private void setFilter(int type) {
        switch (type) {
            case TYPE_NEARBY:
                break;
            case TYPE_TRENDING:
                break;
            case TYPE_AUTHENTIC:
                break;
        }
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
