package com.jsecode.androidmvp.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jsecode.androidmvp.R;

public class CircleView extends View{
    Paint paint;

    int myColor;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.CircleView);

        myColor =  a.getColor(R.styleable.CircleView_circle_color,Color.RED);

        a.recycle();

        init();
    }

    public void init(){
        paint = new Paint();
        paint.setColor(myColor);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingButtom = getPaddingBottom();

        int weidth = getWidth()-paddingLeft-paddingRight;
        int height = getHeight()-paddingTop-paddingButtom;

        int r = Math.min(weidth,height)/2;

        canvas.drawCircle(paddingRight+weidth/2,paddingButtom+height/2,r,paint);


    }
}
