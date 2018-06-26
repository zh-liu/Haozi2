package com.jsecode.androidmvp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.jsecode.androidmvp.R;


public class SnackbarUtil {

    public static  int blue = 0xff2195f3;

    public static  int white = 0xffffffff;

    /**
     * 短显示Snackbar，自定义颜色
     * @param view
     * @param message
     * @param messageColor
     * @param backgroundColor
     * @return
     */
    public static Snackbar ShortSnackbar(View view, String message){
        Snackbar snackbar = Snackbar.make(view,message, Snackbar.LENGTH_SHORT);
        setSnackbarColor(snackbar,white,blue);
        return snackbar;
    }


    public static void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();//获取Snackbar的view
        if(view!=null){
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextSize(14);
        }
    }

}
