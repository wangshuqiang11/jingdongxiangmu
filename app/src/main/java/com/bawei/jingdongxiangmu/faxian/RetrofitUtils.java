package com.bawei.jingdongxiangmu.faxian;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wsq on 2017/12/9.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private final Retrofit retrofit;

    private RetrofitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.svipmovie.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance(){
        if(instance==null){
            synchronized (RetrofitUtils.class){
                if(instance==null){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
    }


    public UtilsPost getApiservise(){
        return retrofit.create(UtilsPost.class);
    }
}
