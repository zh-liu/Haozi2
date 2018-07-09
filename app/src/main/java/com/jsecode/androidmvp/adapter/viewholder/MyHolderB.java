package com.jsecode.androidmvp.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jsecode.androidmvp.R;

public class MyHolderB extends RecyclerView.ViewHolder{
    public TextView text_b_l;
    public TextView text_b_r;

    public MyHolderB(View itemView) {
        super(itemView);
        text_b_l = itemView.findViewById(R.id.text_b_l);
        text_b_r = itemView.findViewById(R.id.text_b_r);
    }
}
