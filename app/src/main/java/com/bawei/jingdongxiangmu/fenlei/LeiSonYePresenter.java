package com.bawei.jingdongxiangmu.fenlei;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2017/11/28.
 */

public class LeiSonYePresenter {
    private Context context;
    private LeiSonYeView leiSonYeView;

    public LeiSonYePresenter(Context context, LeiSonYeView leiSonYeView) {
        this.context = context;
        this.leiSonYeView = leiSonYeView;
    }
    public void Lei3(Map<String,String> map){
        OkHttp.getinstance().postData("http://120.27.23.105/product/getProducts", map, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                LeiSonYeBean bean=(LeiSonYeBean)o;
                List<LeiSonYeBean.DataBean> data = bean.getData();
                leiSonYeView.Leisuccess(data);
            }
            @Override
            public void onFailed(String tag, String e) {
                leiSonYeView.Leifailed("",e);
            }
        }, LeiSonYeBean.class,"");

    }
}
