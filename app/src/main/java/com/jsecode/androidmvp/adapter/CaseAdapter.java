package com.jsecode.androidmvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsecode.androidmvp.R;
import com.jsecode.androidmvp.adapter.viewholder.MyHolderA;
import com.jsecode.androidmvp.adapter.viewholder.MyHolderB;
import com.jsecode.androidmvp.bean.MyBean;

import java.util.List;

import static com.jsecode.androidmvp.adapter.CaseAdapter.Item_Type.RECYCLERVIEW_ITEM_TYPE_1;
import static com.jsecode.androidmvp.adapter.CaseAdapter.Item_Type.RECYCLERVIEW_ITEM_TYPE_2;

public class CaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public Context context;
    public LayoutInflater inflater;
    public List<MyBean> beans;

    public CaseAdapter(Context con,List<MyBean> list){
        this.inflater = LayoutInflater.from(con);
        this.beans = list;
    }


    public enum Item_Type{
        RECYCLERVIEW_ITEM_TYPE_1,
        RECYCLERVIEW_ITEM_TYPE_2,

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == RECYCLERVIEW_ITEM_TYPE_1.ordinal()){
            View view = inflater.inflate(R.layout.activity_list_itmea,null);
            MyHolderA holderA = new MyHolderA(view);
            return holderA;
        }else if(viewType == RECYCLERVIEW_ITEM_TYPE_2.ordinal()){
            View view = inflater.inflate(R.layout.activity_list_itmeb,null);
            MyHolderB myHolderB = new MyHolderB(view);
            return myHolderB;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyHolderA){
            ((MyHolderA)holder).textView.setText(beans.get(position).getName());
        }else if(holder instanceof MyHolderB){
            ((MyHolderB)holder).text_b_l.setText(beans.get(position).getName());
            ((MyHolderB)holder).text_b_r.setText(beans.get(position).getAge());
        }
    }




    @Override
    public int getItemCount() {
        if(null!=beans){
            return beans.size();
        }
        return 0;
    }


    @Override
    public int getItemViewType(int position) {

        if("0".equals(beans.get(position).getType())){
            return RECYCLERVIEW_ITEM_TYPE_1.ordinal();
        }else if("1".equals(beans.get(position).getType())){
            return RECYCLERVIEW_ITEM_TYPE_2.ordinal();
        }

        return -1;
    }
}
