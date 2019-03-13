package com.example.yuekao.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 9:04
 * @Description：基类的继承
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(bindLayout());
        initView();
        initData();
        bindEvent();
    }
    //绑定布局的方法
    public abstract int bindLayout();
    //绑定组件的方法
    protected abstract void initView();
    //绑定数据的方法
    protected abstract void initData();
    //设置监听
    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resid){
        return findViewById(resid);
    }
}
