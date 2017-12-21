package com.bawei.jingdongxiangmu.net;

/**
 * Created by wsq on 2017/11/7.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onFailure(Exception e);
}
