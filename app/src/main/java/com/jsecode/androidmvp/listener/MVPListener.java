package com.jsecode.androidmvp.listener;

public interface MVPListener<E> {
    /**
     * 成功的时候回调

     */
    void  Success(E pJoke);

    /**
     * 失败的时候回调
     */
    void  Failed(String msg);
}
