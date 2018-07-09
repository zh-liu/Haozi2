package com.jsecode.androidmvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jsecode.androidmvp.R;
import com.jsecode.androidmvp.adapter.CaseAdapter;
import com.jsecode.androidmvp.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public  class CaseListActvity extends BaseActivity{
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    CaseAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_list);
        initView();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_list;
    }


    public void initView() {
        List<MyBean> list = new ArrayList<>();
        MyBean bean = new MyBean();
        bean.setType("0");
        bean.setName("haozi0");

        MyBean bean1 = new MyBean();
        bean1.setType("1");
        bean1.setName("haozi1");
        bean1.setAge("1");

        MyBean bean2 = new MyBean();
        bean2.setType("1");
        bean2.setName("haozi2");
        bean2.setAge("2");

        MyBean bean3 = new MyBean();
        bean3.setType("0");
        bean3.setName("haozi3");

        MyBean bean4 = new MyBean();
        bean4.setType("0");
        bean4.setName("haozi4");

        MyBean bean5 = new MyBean();
        bean5.setType("1");
        bean5.setName("haozi5");
        bean5.setAge("5");


        MyBean bean6 = new MyBean();
        bean6.setType("0");
        bean6.setName("haozi6");

        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);

        adapter = new CaseAdapter(this,list);
    //设置适配器管理器：LinearLayoutManager GridLayoutManager StaggeredGridLayoutManager(瀑布流)，
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

      //  recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //添加分割线
      //  recyclerView.addItemDecoration(new RecycleItemDecoration(context, RecycleItemDecoration.VERTICAL_LIST));

        recyclerView.setAdapter(adapter);



    }


}
