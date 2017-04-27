package cn.com.xiaorenzi.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.com.xiaorenzi.common.utils.ToastUtils;

/**
 * Created by 1 on 2017/4/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = this.getClass().getSimpleName();
    protected Context mContext = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams();
        initSysConfiguration();
        setContentView(initContentLayout());
        initData();
        initView();
        initListener();
        loadData();
    }

    protected abstract void initView();

    protected abstract int initContentLayout();

    protected void initParams() {

    }

    protected void initSysConfiguration() {

    }

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void loadData() {

    }

    protected void showToastLong(String msg) {
        ToastUtils.showLong(this, msg);
    }

    protected void showToastShort(String msg) {
        ToastUtils.showShort(this, msg);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ToastUtils.onPause();//视图不可见时，取消吐司的显示
    }
}
