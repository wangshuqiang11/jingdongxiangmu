package com.bawei.jingdongxiangmu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.bawei.jingdongxiangmu.widget.FindFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    private DrawerLayout dl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dl =(DrawerLayout)findViewById(R.id.dl);
        dl.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawerView.setClickable(true);

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(30,30)
                .setFontSize(8)
                .setTabPadding(2,3,5)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.mipmap.ic_nav_home,IndexFragment.class)
                .addTabItem("分类",R.mipmap.ic_normal_class, KindFragment.class)
                .addTabItem("发现",R.mipmap.ic_nav_class, FindFragment.class)
                .addTabItem("购物车",R.mipmap.ic_nav_cart, CartFragment.class)
                .addTabItem("我的",R.mipmap.ic_nav_user, MineFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }

}
