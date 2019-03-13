package com.example.yuekao.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 9:13
 * @Description：描述信息
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(),container,false);
    }
    //绑定视图
   protected abstract int bindLayout();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        bindEvent();
    }
    //绑定组件
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void bindEvent();
    protected <T extends View> T bindView(int resid){
        return (T) getView().findViewById(resid);
    }
}
