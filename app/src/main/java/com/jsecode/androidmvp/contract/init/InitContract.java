package com.jsecode.androidmvp.contract.init;

import com.jsecode.androidmvp.contract.IBaseView;
import com.jsecode.androidmvp.entities.request.Init;
import com.jsecode.androidmvp.entities.response.InitResp;
import com.jsecode.androidmvp.listener.MVPListener;
import com.jsecode.androidmvp.model.IBaseModel;
import com.jsecode.androidmvp.presenter.BasePresenter;

public interface InitContract {


    interface IinitModel extends  IBaseModel{
        void postInit(Init init, MVPListener<InitResp> listener);
    }


    interface IinitView extends IBaseView{
        //获取参数
        Init getInit();
        //从persenter回调数据给view
        void Success(InitResp resp);
    }


    abstract class InitPresenter extends BasePresenter<IinitModel,IinitView> {

        public abstract void postInit();
    }

}
