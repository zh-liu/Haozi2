package com.jsecode.androidmvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jsecode.androidmvp.model.IBaseModel;
import com.jsecode.androidmvp.presenter.BasePresenter;
import com.jsecode.androidmvp.utils.CreateUtil;

import butterknife.ButterKnife;

public abstract class BaseActivity <T extends BasePresenter, M extends IBaseModel>extends AppCompatActivity  {

    public T mPresenter;

    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        ButterKnife.bind(this);

        //内部获取第一个类型参数的真实类型  ，反射new出对象
        mPresenter = CreateUtil.getT(this, 0);
        //内部获取第二个类型参数的真实类型  ，反射new出对象
        mModel = CreateUtil.getT(this, 1);
        //使得P层绑定M层和V层，持有M和V的引用
        mPresenter.attachModelView(mModel, this);
        initView();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDettach();
    }

    //子类Activity实现
    public abstract void  initView();
    //子类Activity实现
    public abstract int getLayoutResId() ;

}
