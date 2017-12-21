package com.bawei.jingdongxiangmu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.adapter.MyAdapter;
import com.bawei.jingdongxiangmu.bean.GoodBean;
import com.bawei.jingdongxiangmu.eventbusevent.MessageEvent;
import com.bawei.jingdongxiangmu.eventbusevent.PriceAndCountEvent;
import com.bawei.jingdongxiangmu.presenter.CartPresenter;
import com.bawei.jingdongxiangmu.view.IcartView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by wsq on 2017/12/5.
 */

public class CartFragment extends Fragment implements IcartView{
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private CartPresenter cartPresenter;
    private MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.cart, container, false);
        EventBus.getDefault().register(this);
        mElv = view.findViewById(R.id.elv);
        mCheckbox2 = view.findViewById(R.id.checkbox2);
        mTvPrice = view.findViewById(R.id.tv_price);
        mTvNum = view.findViewById(R.id.tv_num);
        cartPresenter = new CartPresenter(this);
        cartPresenter.getGoods();
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showList(List<GoodBean.DataBean> groupList, List<List<GoodBean.DataBean.DatasBean>> childList) {
        myAdapter = new MyAdapter(getActivity(), groupList, childList);
        mElv.setAdapter(myAdapter);
        mElv.setGroupIndicator(null);
        //默认其他全部展开
        for (int i = 0; i < groupList.size(); i++) {
            mElv.expandGroup(i);
        }
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }
}
