package com.bawei.jingdongxiangmu.model;

import com.bawei.jingdongxiangmu.bean.GoodBean;
import com.bawei.jingdongxiangmu.net.OnNetListener;

/**
 * Created by wsq on 2017/12/7.
 */

public interface IcartModel {
    public void getGoods(OnNetListener<GoodBean> onNetListener);
}
