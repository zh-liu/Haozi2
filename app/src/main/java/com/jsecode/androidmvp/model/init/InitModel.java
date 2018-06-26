package com.jsecode.androidmvp.model.init;

import com.jsecode.androidmvp.contract.init.InitContract;
import com.jsecode.androidmvp.entities.request.Init;
import com.jsecode.androidmvp.entities.response.InitResp;
import com.jsecode.androidmvp.listener.MVPListener;
import com.jsecode.androidmvp.utils.GsonUtils;
import com.jsecode.androidmvp.utils.OkHttpUtils;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class InitModel implements InitContract.IinitModel {
    @Override
    public void postInit(Init init,final MVPListener<InitResp> listener) {

        Logger.d(init.toString(),this);


        OkHttpUtils.getInstance().post(init.toString(),new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.Failed(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();

                InitResp resp= GsonUtils.fromJson(str, InitResp.class);

                if(null!=resp){
                    if(resp.getResult()==1){
                        listener.Success(resp);
                    }else{
                        listener.Failed(resp.getNote());
                    }

                    Logger.d(resp.toString(),this);
                }else{
                    listener.Failed("解析错误");
                }

            }

        });
    }


}
