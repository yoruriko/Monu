package com.ricogao.monu.Main.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by ricogao on 2017/4/21.
 */

public class SharedPreferencesUtil {

    private Context context;
    private String spName = "MonuSharedPrefences";

    private SharedPreferences sp;

    private String tokenLanguage = "language";
    private String tokenDealAndReward = "dealAndReward";
    private String tokenPromo = "promo";
    private String tokenRecommend = "recommend";


    public SharedPreferencesUtil(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    public void saveLanguage(String locale) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(tokenLanguage, locale);
        editor.apply();
    }

    public String getLanguage() {
        return sp.getString(tokenLanguage, "en");
    }

    public void saveDealAndReward(boolean isShow) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(tokenDealAndReward, isShow);
        editor.apply();
    }

    public boolean isDealAndReward() {
        return sp.getBoolean(tokenDealAndReward, true);
    }

    public void savePromos(boolean isShow) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(tokenPromo, isShow);
        editor.apply();
    }

    public boolean isPromos() {
        return sp.getBoolean(tokenPromo, true);
    }

    public void saveRecommend(boolean isShow) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(tokenRecommend, isShow);
        editor.apply();
    }

    public boolean isRecommend() {
        return sp.getBoolean(tokenRecommend, true);
    }
}
