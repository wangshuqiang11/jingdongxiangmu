package com.bawei.jingdongxiangmu.faxian;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by wsq on 2017/12/9.
 */

public interface UtilsPost {
    @GET("front/columns/getVideoList.do")
    Flowable<My_VideoBean<My_RetBean<List<My_ListBean>>>> getVideo(@QueryMap Map<String, String> map);

}
