package com.bawei.jingdongxiangmu.model;


import com.bawei.jingdongxiangmu.bean.BaseBean;
import com.bawei.jingdongxiangmu.net.OnNetListener;

/**
 * Created by wsq on 2017/11/7.
 */

public interface IRegisterModel {
    public void register(String account, String pwd, OnNetListener<BaseBean> onNetListener);
}
