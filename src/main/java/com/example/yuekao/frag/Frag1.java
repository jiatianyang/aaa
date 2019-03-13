package com.example.yuekao.frag;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuekao.R;
import com.example.yuekao.adapter.ListAdapter;
import com.example.yuekao.base.BaseFragment;
import com.example.yuekao.bean.Datas;
import com.example.yuekao.bean.Datass;
import com.example.yuekao.bean.Json1;
import com.example.yuekao.http.HttpUtil;
import com.example.yuekao.sqlite.SqHelp;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 9:39
 * @Description：描述信息
 */
public class Frag1 extends BaseFragment{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> list;
    private PullToRefreshListView pull_list;
    private String str="http://365jia.cn/news/api3/365jia/news/categories/hotnews?page=1";
    private List<Datass> data1;
    private ListAdapter adapter;
    private SQLiteDatabase db;

    @Override
    protected int bindLayout() {
        return R.layout.frag01;
    }

    @Override
    protected void initView() {
        pull_list = bindView(R.id.pull_list);
        pull_list.setMode(PullToRefreshListView.Mode.BOTH);
        pull_list.setPullToRefreshOverScrollEnabled(true);
        pull_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pull_list.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                pull_list.onRefreshComplete();
            }
        });
        SqHelp help=new SqHelp(getActivity());
        db = help.getReadableDatabase();
    }

    @Override
    protected void initData() {
        if (HttpUtil.isNetWork(getActivity())) {
            HttpUtil.httpAsynTask(str, new HttpUtil.CallBackString() {
                @Override
                public void getDate(String s) {
                    Toast.makeText(getActivity(),"有网",Toast.LENGTH_LONG).show();
                    Gson gson = new Gson();
                    Json1 json1 = gson.fromJson(s, Json1.class);
                    Datas data = json1.getData();
                    data1 = data.getData();
                    adapter = new ListAdapter(getActivity(), data1);
                    pull_list.setAdapter(adapter);
                    Cursor cursor=db.query("person",null,null,null,null,null,null);
                    ContentValues values = new ContentValues();
                    values.put("title",s);
                    db.insert("person",null,values);
                }
            });
        }else{
            Toast.makeText(getActivity(),"没网",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void bindEvent() {
        pull_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtil.httpAsynTask(str, new HttpUtil.CallBackString() {
                    @Override
                    public void getDate(String s) {
                        Gson gson=new Gson();
                        Json1 json1 = gson.fromJson(s, Json1.class);
                        Datas data = json1.getData();
                        List<Datass> data1 = data.getData();
                        ListAdapter adapter=new ListAdapter(getActivity(),data1);
                        pull_list.setAdapter(adapter);
                        pull_list.onRefreshComplete();
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                HttpUtil.httpAsynTask(str, new HttpUtil.CallBackString() {
                    @Override
                    public void getDate(String s) {
                        Gson gson=new Gson();
                        Json1 json1 = gson.fromJson(s, Json1.class);
                        Datas data = json1.getData();
                        List<Datass> al = data.getData();
                        data1.addAll(al);
                        ListAdapter adapter=new ListAdapter(getActivity(),data1);
                        adapter.notifyDataSetChanged();
                        pull_list.setAdapter(adapter);
                        pull_list.onRefreshComplete();

                    }
                });
            }
        });
    }
}
