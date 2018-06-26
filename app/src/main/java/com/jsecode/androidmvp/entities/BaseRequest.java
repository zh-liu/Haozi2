package com.jsecode.androidmvp.entities;


import com.jsecode.androidmvp.utils.GsonUtils;

public abstract class BaseRequest {
    private String cmd = getClass().getSimpleName();

    @Override
    public String toString() {
        return GsonUtils.toJson(this);
    }

    private String token;

    public String getToken() {
        return token;
    }

    public BaseRequest setToken(String token) {
        this.token = token;
        return this;
    }
}
