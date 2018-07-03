package com.jsecode.androidmvp.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.widget.RelativeLayout;

import com.jsecode.androidmvp.BuildConfig;
import com.jsecode.androidmvp.bean.Data;
import com.jsecode.androidmvp.R;
import com.jsecode.androidmvp.contract.init.InitContract;
import com.jsecode.androidmvp.entities.request.Init;
import com.jsecode.androidmvp.entities.response.InitResp;
import com.jsecode.androidmvp.model.init.InitModel;
import com.jsecode.androidmvp.presenter.init.InitPresenter;
import com.jsecode.androidmvp.utils.SnackbarUtil;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

/**
 * 如果有混 可以使用如下权限申请。
 * */

public class SplashActivity extends BaseActivity<InitPresenter,InitModel> implements InitContract.IinitView {



    public static final int CAMERA_REQUEST_CODE = 110;

    @BindView(R.id.rela_bg)
    RelativeLayout rela_bg;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this, Manifest.permission.CAMERA)) {
//                            当某条权限之前已经请求过，并且用户已经拒绝了该权限时，shouldShowRequestPermissionRationale ()方法返回的是true


                    new AlertDialog.Builder(this)
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 2016/11/10 打开系统设置权限
                        dialog.cancel();

                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", SplashActivity.this.getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);

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
                .setMessage("您已经禁止了使用摄像头权限,是否现在去开启")
                .show();

                } else {
//                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
                }
            }else{
                initData();
            }
        } else {
            initData();
        }


    }

    public void initData() {
        Data.init = null;
        try{
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String deviceId = tm.getDeviceId();
            String imsi = tm.getSubscriberId();
            String model = Build.MODEL;

            String phoneNumber = tm.getLine1Number();
            String sdkVersion = Build.VERSION.RELEASE;
            int sdkInt = Build.VERSION.SDK_INT;
            String versionName = BuildConfig.VERSION_NAME;
            int versionCode = BuildConfig.VERSION_CODE;

            Data.init  = new Init(deviceId, imsi, model, phoneNumber, sdkVersion, sdkInt, versionName, versionCode);

            SnackbarUtil.ShortSnackbar(rela_bg,"初始化").show();
        }catch (SecurityException e){
            e.printStackTrace();
            Logger.e(e.getMessage(),SplashActivity.class);
        }


    }


    @Override
    public Init getInit() {
        if(null == Data.init){
            initData();
        }
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    SnackbarUtil.ShortSnackbar(rela_bg,"返回通过").show();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    //弹出申请 拒绝后走这里。  //记住，拒绝后 也走这里！


                    new AlertDialog.Builder(this)
                            .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO: 2016/11/10 打开系统设置权限
                                    dialog.cancel();

                                    Intent intent = new Intent();
                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", SplashActivity.this.getPackageName(), null);
                                    intent.setData(uri);
                                    startActivity(intent);
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
                            .setMessage("您已经禁止了使用摄像头权限,是否现在去开启")
                            .show();



                   // SnackbarUtil.ShortSnackbar(rela_bg,"返回不通过").show();
                }
                return;
                // other 'case' lines to check for other
                // permissions this app might request
            }
        }
    }
    //
//    @NeedsPermission({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    void init() {
//        mPresenter.postInit();
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
//    }
//
//
//
//    @OnShowRationale({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    void whyPermission(final PermissionRequest request) {
//
//        new AlertDialog.Builder(this)
//                .setPositiveButton("打开", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // TODO: 2016/11/10 打开系统设置权限
//                        request.proceed();
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        request.cancel();
//                    }
//                })
//                .setCancelable(false)
//                .setMessage("挑战需要存储权限，应用将要申请存储权限")
//                .show();
//
//
//    }
//
//    @OnPermissionDenied({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    void onDenied() {
//        SnackbarUtil.ShortSnackbar(rela_bg, "拒绝存储权限将无法进行挑战").show();
//        finish();
//    }
//
//    @OnNeverAskAgain({Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
//    void prohibit() {
//
//        new AlertDialog.Builder(this)
//                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // TODO: 2016/11/10 打开系统设置权限
//                        dialog.cancel();
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                        finish();
//                    }
//                })
//                .setCancelable(false)
//                .setMessage("您已经禁止了存储权限,是否现在去开启")
//                .show();
//
//
//    }
//




}
