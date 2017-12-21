package com.bawei.jingdongxiangmu.model;

import com.bawei.jingdongxiangmu.bean.Catagory;
import com.bawei.jingdongxiangmu.bean.ProductCatagoryBean;
import com.bawei.jingdongxiangmu.net.OnNetListener;

/**
 * Created by wsq on 2017/11/9.
 */

public interface IClassModel {
    public void getCatagory(OnNetListener<Catagory> onNetListener);
    public void getProductCatagory(String cid, OnNetListener<ProductCatagoryBean> onNetListener);
}
