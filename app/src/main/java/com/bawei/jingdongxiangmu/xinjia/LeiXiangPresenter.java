package com.bawei.jingdongxiangmu.xinjia;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * Created by Liu xiong biao on 2017/11/28.
 */

public class LeiXiangPresenter {
    private Context context;
    private LeiXiangView leiXiangView;
    private List<Leixiang> list;
    private PlusShopView plusShopView;

    public LeiXiangPresenter(Context context, LeiXiangView leiXiangView, List<Leixiang> list,PlusShopView plusShopView) {
        this.context = context;
        this.leiXiangView = leiXiangView;
        this.list = list;
        this.plusShopView = plusShopView;
    }

    public void LeiXiang(Map<String,String> map){

        OkHttp.getinstance().postData("http://120.27.23.105/product/getProductDetail", map, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
               leiXiangView.Leisuccess(o);
            }

            @Override
            public void onFailed(String tag, String e) {
               leiXiangView.Leifailed("",e);
            }
        }, LeiXiangBean.class,"");

    }

    public void PlusShop(Map<String,String> map){
        OkHttp.getinstance().postData("http://120.27.23.105/product/addCart", map, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                plusShopView.success(tag,o);

            }

            @Override
            public void onFailed(String tag, String e) {

            }
        }, PlusShopBean.class,"");

    }


}
