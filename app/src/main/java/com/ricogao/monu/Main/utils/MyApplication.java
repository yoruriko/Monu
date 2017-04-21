package com.ricogao.monu.Main.utils;

import android.app.Application;
import android.content.res.Resources;

import java.util.Locale;

/**
 * Created by ricogao on 2017/4/21.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Locale locale = new Locale(new SharedPreferencesUtil(this).getLanguage());
        Resources resources = getResources();
        resources.getConfiguration().setLocale(locale);
        resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
    }
}
