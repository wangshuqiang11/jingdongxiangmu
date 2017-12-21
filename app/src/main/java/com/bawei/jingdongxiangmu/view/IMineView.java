package com.bawei.jingdongxiangmu.view;

/**
 * Created by wsq on 2017/12/7.
 */

public interface IMineView {
    public String getAccount();
    public String getPwd();
    public void show(String str);
    public void toRegisterAc();
    public void toClassAc(int uid,String nickname);
    public void shibai();
}
