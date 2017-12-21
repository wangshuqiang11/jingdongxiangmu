package com.bawei.jingdongxiangmu.deng;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bawei.jingdongxiangmu.xinjia.AllBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wsq on 2017/11/9.
 */

public class OkHttp {
    private  static   Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    //单例模式
    private static volatile OkHttp instance;

    public static OkHttp getinstance() {
        if (instance == null) {
            synchronized (OkHttp.class) {
                if (instance == null) {
                    instance = new OkHttp();
                }
            }
        }
        return instance;
    }
    //post请求
    public void postData(String url, Map<String, String> map, final AllBack allback, final Class clazz, final String tag) {
    //对参数做拼接处理
        StringBuffer buffer = new StringBuffer();
        buffer.append(url);
        //如果存在?
        if (buffer.indexOf("?") != -1) {
            //如果?不在最后一位
            if (buffer.indexOf("?") != buffer.length() - 1) {
                buffer.append("&");
            }
        }else{
            buffer.append("?");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buffer.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        buffer.deleteCharAt(buffer.lastIndexOf("&"));
        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .get()
                .url(buffer.toString())
                .build();
        Log.i("yyy",buffer.toString());
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                allback.onFailed(tag,e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("ttt",string.toString());
                Gson gson = new Gson();
                final Object o = gson.fromJson(string, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                       allback.onSuccess(tag,o);
                    }
                });
            }
        });
    }
    //get请求
    public  void getData(String url, final AllBack allback,final Class clazz,final String tag){
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                allback.onFailed(tag,e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(string, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                            allback.onSuccess(tag,o);
                    }
                });
            }
        });
    }

}

