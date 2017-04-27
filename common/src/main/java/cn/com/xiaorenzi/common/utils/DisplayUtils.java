package cn.com.xiaorenzi.common.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by 1 on 2017/4/27.
 */

public class DisplayUtils {

    /**
     * 获取屏幕宽度
     * @param mContext
     * @return
     */
    public static int getScreenWidth(Context mContext) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param mContext
     * @return
     */
    public static int getScreenHeight(Context mContext) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
