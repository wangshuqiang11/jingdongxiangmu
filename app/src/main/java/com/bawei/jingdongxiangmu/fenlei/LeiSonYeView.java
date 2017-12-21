package com.bawei.jingdongxiangmu.fenlei;

import java.util.List;

/**
 * Created by wsq on 2017/11/28.
 */

public interface LeiSonYeView {
    void Leisuccess(List<LeiSonYeBean.DataBean> list);
    void Leifailed(String tag, String e);
}
