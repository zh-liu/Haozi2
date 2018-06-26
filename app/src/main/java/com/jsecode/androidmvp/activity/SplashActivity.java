package com.jsecode.androidmvp.activity;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.widget.RelativeLayout;

import com.jsecode.androidmvp.BuildConfig;
import com.jsecode.androidmvp.Data;
import com.jsecode.androidmvp.R;
import com.jsecode.androidmvp.contract.init.InitContract;
import com.jsecode.androidmvp.entities.request.Init;
import com.jsecode.androidmvp.entities.response.InitResp;
import com.jsecode.androidmvp.model.init.InitModel;
import com.jsecode.androidmvp.presenter.init.InitPresenter;
import com.jsecode.androidmvp.utils.SnackbarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class SplashActivity extends BaseActivity<InitPresenter,InitModel> implements InitContract.IinitView {


    @BindView(R.id.rela_bg)
    RelativeLayout rela_bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SplashActivityPermissionsDispatcher.initWithPermissionCheck(this);


    }

    public void initData() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);



        String deviceId = tm.getDeviceId();

        String imsi = tm.getSubscriberId();
        String model = Build.MODEL;

        String phoneNumber = tm.getLine1Number();
        String sdkVersion = Build.VERSION.RELEASE;
        int sdkInt = Build.VERSION.SDK_INT;
        String versionName = BuildConfig.VERSION_NAME;
        int versionCode = BuildConfig.VERSION_CODE;

        Data.init = new Init(deviceId, imsi, model, phoneNumber, sdkVersion, sdkInt, versionName, versionCode);

    }


    @Override
    public Init getInit() {
        initData();
        return Data.init;
    }

    @Override
    public void Success(InitResp resp) {
        SnackbarUtil.ShortSnackbar(rela_bg,resp.toString()).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg(String msg) {
        SnackbarUtil.ShortSnackbar(rela_bg,msg).show();
    }




    @Override
    public void initView() {



    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @NeedsPermission({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void init() {
        mPresenter.postInit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
