package com.bawei.jingdongxiangmu.fenlei;

/**
 * Created by wsq con 2017/11/9.
 */

public interface AllBack {
    void onSuccess(String tag, Object o);
    void onFailed(String tag, String e);
}
