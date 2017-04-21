package com.ricogao.monu.Main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.ricogao.monu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;

/**
 * Created by ricogao on 2017/4/15.
 */

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private static final String TAG = ScanActivity.class.getSimpleName();

    @BindView(R.id.zxingview)
    QRCodeView mQRCodeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.scan_qr_code);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mQRCodeView.setDelegate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.showScanRect();
        mQRCodeView.startSpot();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
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
    public void onScanQRCodeSuccess(String result) {
        Log.i(TAG, "result:" + result);
        Intent it = new Intent(this, DetailActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "Open Camera Error");
    }

}
