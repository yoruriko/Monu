package com.ricogao.monu.Main.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricogao.monu.Main.fragments.HistoryFragment;
import com.ricogao.monu.Main.fragments.LikedFragment;
import com.ricogao.monu.Main.fragments.MainFragment;
import com.ricogao.monu.Main.model.CircleTransform;
import com.ricogao.monu.Main.model.User;
import com.ricogao.monu.Main.utils.DataUtil;
import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;

    private final static String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private Fragment mainFragment, likeFragment, historyFragment;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.mCoordinatorLayout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ImageView imgProfile;
    TextView tvName;
    TextView tvEmail;

    @BindString(R.string.request_scan_hint)
    String requestHint;
    @BindString(R.string.request_scan_fail_message)
    String failMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        imgProfile = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.img_profile);
        tvName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_name);
        tvEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_email);

        init();
    }

    private void init() {
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, mainFragment).commit();

        User user = DataUtil.getUser();

        tvName.setText(user.getUserName());
        tvEmail.setText(user.getEmail());

        Picasso.with(this)
                .load(user.getImgSrc())
                .placeholder(R.drawable.blank_profile)
                .fit()
                .centerCrop()
                .transform(new CircleTransform())
                .into(imgProfile);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_scan:
                showScanView();
                return true;
            case R.id.action_search:
                startActivity(new Intent(this, SearchActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_recommends:
                switchFragment(mainFragment);
                break;
            case R.id.nav_liked:
                if (likeFragment == null) {
                    likeFragment = new LikedFragment();
                }
                switchFragment(likeFragment);
                break;
            case R.id.nav_history:
                if (historyFragment == null) {
                    historyFragment = new HistoryFragment();
                }
                switchFragment(historyFragment);
                break;
            case R.id.nav_settings:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.nav_usage_and_terms:
                break;
            case R.id.nav_support_and_help:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showScanView() {
        if (!EasyPermissions.hasPermissions(this, perms)) {
            requestQRCodePermissions();
        } else {
            startActivity(new Intent(this, ScanActivity.class));
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (requestCode == REQUEST_CODE_QRCODE_PERMISSIONS) {
            showScanView();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (requestCode == REQUEST_CODE_QRCODE_PERMISSIONS) {
            Snackbar mySnackBar = Snackbar.make(mCoordinatorLayout, R.string.request_scan_fail_message, Snackbar.LENGTH_SHORT);
            mySnackBar.setAction(R.string.request, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requestQRCodePermissions();
                }
            });
            mySnackBar.show();
        }
    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestQRCodePermissions() {
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, requestHint, REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
