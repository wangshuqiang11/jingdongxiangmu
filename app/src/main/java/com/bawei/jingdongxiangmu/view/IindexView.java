package com.bawei.jingdongxiangmu.view;

import com.bawei.jingdongxiangmu.bean.Catagory;
import com.bawei.jingdongxiangmu.bean.ProductCatagoryBean;

import java.util.List;

/**
 * Created by wsq on 2017/12/5.
 */

public interface IindexView {
    public void showData(List<Catagory.DataBean> list);
    public void showElvData(List<ProductCatagoryBean.DataBean> list);
}
