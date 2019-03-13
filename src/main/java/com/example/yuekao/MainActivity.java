package com.example.yuekao;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.yuekao.base.BaseActivity;
import com.example.yuekao.frag.Frag1;
import com.example.yuekao.frag.Frag2;
import com.example.yuekao.frag.Frag3;
import com.example.yuekao.frag.Frag4;
import com.example.yuekao.frag.Frag5;

public class MainActivity extends BaseActivity {


    private RadioGroup group;
    private FrameLayout layout;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;
    private FragmentManager supportFragmentManager;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        group = findViewById(R.id.radio_group);
        layout = findViewById(R.id.Fragment_layout);
    }

    @Override
    protected void initData() {
        //模拟数据
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        //获取Frag数据库
        supportFragmentManager = getSupportFragmentManager();
        //开启
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        //替换fragment
        transaction.add(R.id.Fragment_layout, frag1)
                .add(R.id.Fragment_layout, frag2)
                .add(R.id.Fragment_layout, frag3)
                .add(R.id.Fragment_layout, frag4)
                .add(R.id.Fragment_layout, frag5)
                .show(frag1)
                .hide(frag2)
                .hide(frag3)
                .hide(frag4)
                .hide(frag5).commit();
    }

    @Override
    protected void bindEvent() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                switch (i) {
                    case R.id.ra1:
                        transaction.show(frag1)
                                .hide(frag2)
                                .hide(frag3)
                                .hide(frag4)
                                .hide(frag5);
                        break;
                    case R.id.ra2:
                        transaction.show(frag2)
                                .hide(frag1)
                                .hide(frag3)
                                .hide(frag4)
                                .hide(frag5);
                        break;
                    case R.id.ra3:
                        transaction.show(frag3)
                                .hide(frag2)
                                .hide(frag1)
                                .hide(frag4)
                                .hide(frag5);
                        break;
                    case R.id.ra4:
                        transaction.show(frag4)
                                .hide(frag2)
                                .hide(frag3)
                                .hide(frag1)
                                .hide(frag5);
                        break;
                    case R.id.ra5:
                        transaction.show(frag5)
                                .hide(frag2)
                                .hide(frag3)
                                .hide(frag4)
                                .hide(frag1);
                        break;
                }
                transaction.commit();
            }
        });

    }
}
