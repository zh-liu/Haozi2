package com.jsecode.androidmvp.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jsecode.androidmvp.R;

public class MyHolderA extends RecyclerView.ViewHolder{
    public TextView textView;

    public MyHolderA(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_a);
    }
}
