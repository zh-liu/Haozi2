package com.jsecode.androidmvp.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;

import java.io.InputStreamReader;

public final class GsonUtils {

    private GsonUtils() {
    }

    private static Gson gson = new GsonBuilder()
            .setDateFormat(DateUtils.DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()).create();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return gson.fromJson(json, classOfT);
        } catch (Exception e) {
            Logger.e("Json格式转换错误",GsonUtils.class);
            Logger.e(e.getMessage(),GsonUtils.class);
            return null;
        }
    }

    public static <T> T fromJsonAssetFile(Context ctx, String fileName, Class<T> classOfT) {

        try {
            InputStreamReader reader = new InputStreamReader(ctx.getAssets().open(fileName));
            T obj = gson.fromJson(reader, classOfT);
            reader.close();
            return obj;
        } catch (Exception e) {
            Logger.e("Json格式转换错误",GsonUtils.class);
            Logger.e(e.getMessage(),GsonUtils.class);
            return null;
        }
    }

}
