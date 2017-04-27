package cn.com.xiaorenzi.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 1 on 2017/4/27.
 */

public class ToastUtils {

    private static Toast mToast;

    public synchronized static void showLong(Context mContext, String msg) {
        show(mContext, msg, Toast.LENGTH_LONG);
    }

    public synchronized static void showShort(Context mContext, String msg) {
        show(mContext, msg, Toast.LENGTH_SHORT);
    }

    public synchronized static void show(Context mContext, String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, duration);
        } else {
            mToast.setText(msg);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void onPause(){
        if(mToast != null){
            mToast.cancel();
        }
    }
}
