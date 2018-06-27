package com.jsecode.androidmvp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
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



    @OnShowRationale({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void whyPermission(final PermissionRequest request) {

        new AlertDialog.Builder(this)
                .setPositiveButton("打开", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2016/11/10 打开系统设置权限
                        request.proceed();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage("挑战需要存储权限，应用将要申请存储权限")
                .show();


    }

    @OnPermissionDenied({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onDenied() {
        SnackbarUtil.ShortSnackbar(rela_bg, "拒绝存储权限将无法进行挑战").show();
        finish();
    }

    @OnNeverAskAgain({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void prohibit() {

        new AlertDialog.Builder(this)
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2016/11/10 打开系统设置权限
                        dialog.cancel();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                })
                .setCancelable(false)
                .setMessage("您已经禁止了存储权限,是否现在去开启")
                .show();


    }





}
