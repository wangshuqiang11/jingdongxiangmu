package com.bawei.jingdongxiangmu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bawei.jingdongxiangmu.adapter.LeftAdapter;
import com.bawei.jingdongxiangmu.adapter.RightAdapter;
import com.bawei.jingdongxiangmu.bean.Catagory;
import com.bawei.jingdongxiangmu.bean.ProductCatagoryBean;
import com.bawei.jingdongxiangmu.presenter.Classpresenter;
import com.bawei.jingdongxiangmu.utils.GlideImageLoader;
import com.bawei.jingdongxiangmu.view.IindexView;
import com.bawei.jingdongxiangmu.widget.MyExpanableListView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsq on 2017/12/5.
 */

public class KindFragment extends Fragment implements IindexView {

    private Classpresenter classpresenter;
    private ListView mLvLeft;
    private LeftAdapter adapter;
    private List<String> groupList = new ArrayList<>();//一级列表数据
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList = new ArrayList<>();//二级列表
    private Banner banner;
    private MyExpanableListView mElv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.kind, container, false);
        classpresenter = new Classpresenter(this);
        mLvLeft = view.findViewById(R.id.lv_left);
        banner =view.findViewById(R.id.banner);
        mElv =view.findViewById(R.id.elv);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        List<String> images=new ArrayList<>();
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-11-05/2ed8cfc1c818161770678fd25d3b1c6d.jpeg");
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-12-12/dd545bba5609c095d8f9a1c8c0cc2880.jpeg");
        images.add("http://omsproductionimg.yangkeduo.com/images/2017-11-25/32bde96f23c38839f1b4ea2514682a78.jpeg");
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        classpresenter.getCatagory();
        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.press(position);
                //请求对应右侧的数据
                //获取cid
                Catagory.DataBean dataBean= (Catagory.DataBean) parent.getItemAtPosition(position);
                int cid=dataBean.getCid();
                classpresenter.getProductCatagory(cid+"");
            }
        });
        return view;
    }

    @Override
    public void showData(List<Catagory.DataBean> list) {
        adapter = new LeftAdapter(getActivity(), list);
        mLvLeft.setAdapter(adapter);
        Log.e("mylog","进来了");
    }

    @Override
    public void showElvData(List<ProductCatagoryBean.DataBean> list) {
        groupList.clear();
        childList.clear();
        //给二级列表封住数据
        for(int i=0;i<list.size();i++){
            ProductCatagoryBean.DataBean dataBean=list.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        //创建适配器
        RightAdapter rightAdapter = new RightAdapter(getActivity(), childList, groupList);
        mElv.setAdapter(rightAdapter);
        //设置默认全部展开
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }
    }
}
