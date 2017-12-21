package com.bawei.jingdongxiangmu.deng;

/**
 * Created by wsq on 2017/11/9.
 */

public interface AllBack {
    void onSuccess(String tag, Object o);
    void onFailed(String tag, String e);
}
