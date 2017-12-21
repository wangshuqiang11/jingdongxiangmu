package com.bawei.jingdongxiangmu.xinjia;

/**
 * Created by Liu xiong biao on 2017/11/10.
 */

public interface INewsView {
    void success(String tag, Object news);
    void failed(String tag, String e);
}
