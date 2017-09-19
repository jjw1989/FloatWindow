package com.sundy.floatutil.util;

import android.content.Context;

/**
 * Created by sundy on 17-9-19.
 */

public class Utils {
    private static float mDensity=-1;
    public static boolean isSet(int flags,int flag){
        return (flags & flag) ==flag;
    }

    public static int dp2px(Context context,float dpValue){
        float scale=getScreenDensity(context);
        return (int)(dpValue*scale+0.5f);
    }

    public static float getScreenDensity(Context context){
        if (mDensity==-1){
            mDensity=context.getResources().getDisplayMetrics().density;
        }
        return mDensity;
    }
}
