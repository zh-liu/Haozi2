package com.jsecode.androidmvp.utils;

import android.annotation.SuppressLint;


import com.jsecode.androidmvp.Constants;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

   public static OkHttpUtils instance = null;


    public static synchronized OkHttpUtils getInstance() {
        if(null == instance){
            instance = new OkHttpUtils();
        }
        return instance;
    }


    public  void post(String json, Callback callback){

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().sslSocketFactory(createSSLSocketFactory()).hostnameVerifier(new HostnameVerifier() {

            @Override
            public boolean verify(String hostname, SSLSession session) {
                //强行返回true 即验证成功
                return true;
            }
        }).build();

        RequestBody body = RequestBody.create(JSON, json);


        final Request request = new Request.Builder()
                .url(Constants.SERVICE_URL)
                .post(body)
                .build();
        Call call = mOkHttpClient.newCall(request);

        call.enqueue(callback);

    }





    /**
     * 默认信任所有的证书
     * TODO 最好加上证书认证，主流App都有自己的证书
     *
     * @return
     */
    @SuppressLint("TrulyRandom")
    public   SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        return sSLSocketFactory;
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }



}
