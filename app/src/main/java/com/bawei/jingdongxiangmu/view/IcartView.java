package com.bawei.jingdongxiangmu.view;

import com.bawei.jingdongxiangmu.bean.GoodBean;

import java.util.List;

/**
 * Created by wsq on 2017/12/7.
 */

public interface IcartView {
    public void showList(List<GoodBean.DataBean> groupList, List<List<GoodBean.DataBean.DatasBean>> childList);
}
