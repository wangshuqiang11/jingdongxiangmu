package com.bawei.jingdongxiangmu.presenter;

import com.bawei.jingdongxiangmu.bean.Catagory;
import com.bawei.jingdongxiangmu.bean.ProductCatagoryBean;
import com.bawei.jingdongxiangmu.model.ClassModel;
import com.bawei.jingdongxiangmu.net.OnNetListener;
import com.bawei.jingdongxiangmu.view.IindexView;

import java.util.List;

/**
 * Created by wsq on 2017/12/5.
 */

public class Classpresenter {
    private IindexView iindexView;
    private ClassModel iClassModel;

    public Classpresenter(IindexView iindexView) {
        this.iindexView = iindexView;
        iClassModel=new ClassModel();
    }
    public void getProductCatagory(String cid){
//        Log.e("mylog","进来了");
        iClassModel.getProductCatagory(cid + "", new OnNetListener<ProductCatagoryBean>() {
            @Override
            public void onSuccess(ProductCatagoryBean productCatagoryBean) {
                //给二级列表设置数据
                iindexView.showElvData(productCatagoryBean.getData());

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    //获取分类
    public void getCatagory(){

        iClassModel.getCatagory(new OnNetListener<Catagory>() {
            @Override
            public void onSuccess(final Catagory catagory) {

                iindexView.showData(catagory.getData());
                List<Catagory.DataBean> dataBeen=catagory.getData();
                int cid=dataBeen.get(0).getCid();
                iClassModel.getProductCatagory(cid + "", new OnNetListener<ProductCatagoryBean>() {
                    @Override
                    public void onSuccess(ProductCatagoryBean productCatagoryBean) {
                        iindexView.showData(catagory.getData());
                        //拿到右侧第一条数据
                        List<Catagory.DataBean> dataBean = catagory.getData();
                        int cid = dataBean.get(0).getCid();
                        //获取右侧的数据
                        getProductCatagory(cid + "");
                    }
                    @Override
                    public void onFailure(Exception e) {

                    }
                });
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
