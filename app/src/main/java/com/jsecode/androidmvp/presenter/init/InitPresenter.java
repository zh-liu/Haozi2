package com.jsecode.androidmvp.presenter.init;

import android.os.Handler;

import com.jsecode.androidmvp.contract.init.InitContract;
import com.jsecode.androidmvp.entities.request.Init;
import com.jsecode.androidmvp.entities.response.InitResp;
import com.jsecode.androidmvp.listener.MVPListener;
import com.orhanobut.logger.Logger;

public class InitPresenter extends InitContract.InitPresenter  {
    private Handler mHandler = new Handler();

    @Override
    public void postInit() {

        final InitContract.IinitView mView = getView();

        if(mView==null){
            Logger.d("IInitView界面已经销毁");
            return;
        }

        mView.showLoading();

        mModel.postInit(mView.getInit(), new MVPListener<InitResp>() {
            @Override
            public void Success(final InitResp resp) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (null == getView()) {
                            Logger.d("IInitView界面已经销毁");
                            return;
                        }
                        mView.hideLoading();

                        mView.Success(resp);
                    }
                });
            }

            @Override
            public void Failed(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (null == getView()) {
                            Logger.d("IInitView界面已经销毁");
                            return;
                        }
                        mView.hideLoading();
                        mView.showMsg(msg);
                    }

                });
            }
        });

    }
}
