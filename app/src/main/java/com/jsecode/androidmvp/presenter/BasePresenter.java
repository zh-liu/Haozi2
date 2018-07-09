package com.jsecode.androidmvp.presenter;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <M, V>{
    public M mModel;

    private V mView;

    public WeakReference<V> mViewRef;


    public void attachModelView(M pModel, V pView) {

        mViewRef = new WeakReference<V>(pView);

        this.mModel = pModel;
    }


    public V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
             return null;
        }
    }

    public boolean isAttach() {
        return null != mViewRef && null != mViewRef.get();
    }


    /**
     * 释放引用，防止内存泄露
     */

    public void onDettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
            System.gc();
        }
    }
}
