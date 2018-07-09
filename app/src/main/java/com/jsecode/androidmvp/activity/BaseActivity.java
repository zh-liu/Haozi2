package com.jsecode.androidmvp.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jsecode.androidmvp.R;
import com.jsecode.androidmvp.model.IBaseModel;
import com.jsecode.androidmvp.presenter.BasePresenter;
import com.jsecode.androidmvp.utils.CreateUtil;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public abstract class BaseActivity <T extends BasePresenter, M extends IBaseModel>extends AppCompatActivity {

    public T mPresenter;

    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out);

        ButterKnife.bind(this);



        //内部获取第一个类型参数的真实类型  ，反射new出对象

        mPresenter = CreateUtil.getT(this, 0);


        //内部获取第二个类型参数的真实类型  ，反射new出对象
        mModel = CreateUtil.getT(this, 1);

        //使得P层绑定M层和V层，持有M和V的引用
        if(null!=mModel){
            mPresenter.attachModelView(mModel, this);

        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDettach();
    }

//    //子类Activity实现
//    public abstract void  initView();
//    //子类Activity实现
    public abstract int getLayoutResId() ;

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out);
    }
    // 设置app字体不随系统字体设置改变
    @Override
    public Resources getResources() {
        Resources mResources = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        mResources.updateConfiguration(config, mResources.getDisplayMetrics());
        return mResources;
    }
}
