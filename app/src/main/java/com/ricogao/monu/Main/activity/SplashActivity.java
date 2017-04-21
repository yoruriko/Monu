package com.ricogao.monu.Main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ricogao.monu.R;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ricogao on 2017/4/21.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int FORWARD_TO_MAIN = 12;
    private static final int DELAY_TIME = 3000;

    private final SplashHandler mHandler = new SplashHandler(this);

    @BindView(R.id.img_splash)
    ImageView imgSplash;

    //avoid memory leak in handler
    private static class SplashHandler extends Handler {
        WeakReference<SplashActivity> activityWeakReference;

        SplashHandler(SplashActivity activity) {
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashActivity activity = activityWeakReference.get();
            if (msg.what == FORWARD_TO_MAIN && activity != null) {
                activity.toMainActivity(activity);
                activity.finish();
            }
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        Picasso.with(this)
                .load(R.drawable.monu_splash)
                .fit()
                .centerCrop()
                .into(imgSplash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(FORWARD_TO_MAIN);
            }
        }, DELAY_TIME);

    }

    public void toMainActivity(Activity activity) {
        Intent it = new Intent(activity, MainActivity.class);
        activity.startActivity(it);
    }
}
