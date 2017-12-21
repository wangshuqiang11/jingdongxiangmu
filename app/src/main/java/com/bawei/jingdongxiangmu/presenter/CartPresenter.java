package com.bawei.jingdongxiangmu.presenter;

import com.bawei.jingdongxiangmu.bean.GoodBean;
import com.bawei.jingdongxiangmu.model.CartModel;
import com.bawei.jingdongxiangmu.net.OnNetListener;
import com.bawei.jingdongxiangmu.view.IcartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsq on 2017/12/7.
 */

public class CartPresenter {
    private IcartView icartView;
    private CartModel cartModel;

    public CartPresenter(IcartView icartView) {
        this.icartView = icartView;
        cartModel=new CartModel();
    }
    public void getGoods(){
        cartModel.getGoods(new OnNetListener<GoodBean>() {
            @Override
            public void onSuccess(GoodBean goodBean) {
                List<GoodBean.DataBean> dataBean = goodBean.getData();
                List<List<GoodBean.DataBean.DatasBean>> childList=new ArrayList<List<GoodBean.DataBean.DatasBean>>();
                for (int i = 0; i < dataBean.size(); i++) {
                    List<GoodBean.DataBean.DatasBean> datas=dataBean.get(i).getDatas();
                    childList.add(datas);
                }
                icartView.showList(dataBean,childList);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
