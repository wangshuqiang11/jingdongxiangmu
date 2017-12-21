package com.bawei.jingdongxiangmu.widget;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.R;
import com.bawei.jingdongxiangmu.faxian.Iview;
import com.bawei.jingdongxiangmu.faxian.My_ListBean;
import com.bawei.jingdongxiangmu.faxian.VidoPresenter;
import com.bumptech.glide.Glide;
import com.stone.card.library.CardAdapter;
import com.stone.card.library.CardSlidePanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wsq on 2017/12/12.
 */

public class FindFragment extends Fragment implements Iview {
    private CardSlidePanel.CardSwitchListener cardSwitchListener;
    private CardAdapter cardAdapter;
    List<My_ListBean> dataList = new ArrayList<>();
    private VidoPresenter presenter;
    Unbinder unbinder;
    @BindView(R.id.image_slide_panel)
    CardSlidePanel slidePanel;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faxian, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 1. 左右滑动监听

        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
                //Log.d("Card", "正在显示-" + dataList.get(index).userName);
            }

            @Override
            public void onCardVanish(int index, int type) {
                //Log.d("Card", "正在消失-" + dataList.get(index).userName + " 消失type=" + type);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        //适配器
        cardAdapter = new CardAdapter() {
            @Override
            public int getLayoutId() {
                // layout文件
                return R.layout.card_item;
            }

            @Override
            public int getCount() {
                // 卡片个数
                return dataList.size();
            }

            @Override
            public Rect obtainDraggableArea(View view) {
                // 可滑动区域定制，仅调用一次
                // 可滑动区域定制，该函数只会调用一次
                View contentView = view.findViewById(R.id.card_item_content);
                View topLayout = view.findViewById(R.id.card_top_layout);
                View bottomLayout = view.findViewById(R.id.card_bottom_layout);
                int left = view.getLeft() + contentView.getPaddingLeft() + topLayout.getPaddingLeft();
                int right = view.getRight() - contentView.getPaddingRight() - topLayout.getPaddingRight();
                int top = view.getTop() + contentView.getPaddingTop() + topLayout.getPaddingTop();
                int bottom = view.getBottom() - contentView.getPaddingBottom() - bottomLayout.getPaddingBottom();
                return new Rect(left, top, right, bottom);
            }

            @Override
            public void bindView(View view, int index) {
                // 数据绑定，参看demo
                Object tag = view.getTag();
                ViewHolder viewHolder;
                if (null != tag) {
                    viewHolder = (ViewHolder) tag;
                } else {
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                }

                viewHolder.bindData(dataList.get(index));
            }

            @Override
            public Object getItem(int index) {
                return dataList.get(index);
            }

            class ViewHolder {

                ImageView imageView;
                View maskView;
                TextView userNameTv;
                TextView imageNumTv;
                TextView likeNumTv;

                public ViewHolder(View view) {
                    imageView = (ImageView) view.findViewById(R.id.card_image_view);
                    maskView = view.findViewById(R.id.maskView);
                    userNameTv = (TextView) view.findViewById(R.id.card_user_name);
                    imageNumTv = (TextView) view.findViewById(R.id.card_pic_num);
                    likeNumTv = (TextView) view.findViewById(R.id.card_like);
                }

                public void bindData(My_ListBean itemData) {
                    Glide.with(getActivity()).load(itemData.getPic()).into(imageView);
                    userNameTv.setText(itemData.getTitle());
                    /*imageNumTv.setText(itemData.imageNum + "");
                    likeNumTv.setText(itemData.likeNum + "");*/
                }
            }
        };
        slidePanel.setAdapter(cardAdapter);

        presenter = new VidoPresenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("catalogId", "402834815584e463015584e539330016");
        int randomNumber = getRandomNumber(1, 108);
        map.put("pnum", randomNumber + "");
        presenter.getData(map);

    }


    //换一批点击事件
    @OnClick(R.id.btn_next)
    public void onViewClicked() {

        dataList.clear();

        Map<String, String> map = new HashMap<>();
        map.put("catalogId", "402834815584e463015584e539330016");
        int randomNumber = getRandomNumber(1, 108);
        map.put("pnum", randomNumber + "");
        //Log.e(TAG, "数字: " + randomNumber);
        presenter.getData(map);
    }
    //随机数
    public int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
        unbinder.unbind();
    }

    @Override
    public void onSuccess(Object o) {
        if (o != null) {
            if (o instanceof List) {
                List<My_ListBean> list = (List<My_ListBean>) o;
                //Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
                //Log.e(TAG, "Onsuccess: " + list.toString());
                dataList.addAll(list);
            }
        }

        cardAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed(Exception e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
