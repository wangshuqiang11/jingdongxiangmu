package com.bawei.jingdongxiangmu.model;

import com.bawei.jingdongxiangmu.bean.LoginBean;
import com.bawei.jingdongxiangmu.net.OnNetListener;

/**
 * Created by wsq on 2017/11/7.
 */

public interface ILoginModel {
    public void login(String account, String pwd, OnNetListener<LoginBean> onNetListener);
}
