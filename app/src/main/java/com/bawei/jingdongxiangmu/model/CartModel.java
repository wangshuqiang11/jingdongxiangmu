package com.bawei.jingdongxiangmu.model;

import com.bawei.jingdongxiangmu.bean.GoodBean;
import com.bawei.jingdongxiangmu.net.Api;
import com.bawei.jingdongxiangmu.net.HttpUtils;
import com.bawei.jingdongxiangmu.net.OnNetListener;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by wsq on 2017/12/7.
 */

public class CartModel extends BaseModel implements IcartModel{

    @Override
    public void getGoods(final OnNetListener<GoodBean> onNetListener) {
        HttpUtils.getHttpUtils().doGet(Api.url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final GoodBean goodBean = new Gson().fromJson(string, GoodBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(goodBean);
                    }
                });
            }
        });
    }
}
