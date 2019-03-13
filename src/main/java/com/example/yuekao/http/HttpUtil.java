package com.example.yuekao.http;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 8:43
 * @Description：描述信息
 */
public class HttpUtil {
    //判断网络是否可用
    public static boolean  isNetWork(Context context){
        if (context!=null){
            ConnectivityManager  mconnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mconnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo!=null){
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
    //接口回调
    public static void httpAsynTask(String strurl,final CallBackString backString){
        new AsyncTask<String, Intent, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return httpGet(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //接口回调的方法
                backString.getDate(s);
            }
        }.execute(strurl);

    }


    //接口
    public interface CallBackString {
        void getDate(String s);
    }
    //数据的方法
    public static String httpGet(String strurl){
        try {
            URL url=new URL(strurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //获取get请求
            connection.setRequestMethod("GET");
            //设置连接主机时间
            connection.setConnectTimeout(5000);
            //设置连接读取超时时间
            connection.setReadTimeout(5000);
            //得到数据
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            //拼接数据
            StringBuilder builder = new StringBuilder();
            String str="";
            while((str=reader.readLine())!=null){
                builder.append(str);
            }
            //关闭连接
            connection.disconnect();
            //返回数据
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
