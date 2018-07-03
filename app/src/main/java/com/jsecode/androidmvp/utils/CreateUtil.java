package com.jsecode.androidmvp.utils;

import com.orhanobut.logger.Logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class CreateUtil {

   public static <T> T getT(Object o, int i) {

        try {

      //      return ((Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
            Type genType = o.getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params.length > 0) {
                return ((Class<T>) params[i]).newInstance();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
