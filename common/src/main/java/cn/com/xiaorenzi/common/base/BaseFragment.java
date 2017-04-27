package cn.com.xiaorenzi.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 1 on 2017/4/27.
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected View mContentView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mContentView == null){
            mContentView = inflater.inflate(initContentLayout(),container,true);
            initView();
        }else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if(parent != null){
                parent.removeAllViews();
            }
        }
        return mContentView;
    }

    public abstract int initContentLayout();

    public abstract void initView();

}
