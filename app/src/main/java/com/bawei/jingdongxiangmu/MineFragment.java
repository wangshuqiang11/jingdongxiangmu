package com.bawei.jingdongxiangmu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.deng.My_ssActivity;
import com.bawei.jingdongxiangmu.xinjia.ImgApp2;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by wsq on 2017/12/5.
 */

public class MineFragment extends Fragment{
    private TextView my_login;
    private TextView my_nickname;
    private SimpleDraweeView my_ximg;
    private ImageView my_img;
    private String nickname;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.mine, container, false);
        //获取到登录注册的控件
        my_nickname =(TextView)view.findViewById(R.id.my_nickname);
        my_login =(TextView)view.findViewById(R.id.my_login);
        my_ximg =(SimpleDraweeView)view.findViewById(R.id.my_ximg);
        my_img =(ImageView)view.findViewById(R.id.my_img);
        info();
        into();
        return view;
    }
    public void into(){
        boolean isLogin = ImgApp2.sp.getBoolean("isLogin", false);
        if(isLogin){
            nickname = ImgApp2.sp.getString("nickname", "");
            my_nickname.setText(nickname+"");
        }
    }
    public void info(){
        boolean isLogin = ImgApp2.sp.getBoolean("isLogin", false);

        Log.e("-----",isLogin+"");
        if(isLogin){
            my_login.setVisibility(View.GONE);
            my_img.setVisibility(View.GONE);
            my_nickname.setVisibility(View.VISIBLE);
            my_ximg.setVisibility(View.VISIBLE);
            my_ximg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), My_ssActivity.class);
                    intent.putExtra("nickname",nickname);
                    startActivity(intent);
                }
            });
            my_nickname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), My_ssActivity.class);
                    intent.putExtra("nickname",nickname);
                    startActivity(intent);
                }
            });

        }else{
            my_login.setVisibility(View.VISIBLE);
            my_img.setVisibility(View.VISIBLE);
            my_nickname.setVisibility(View.GONE);
            my_ximg.setVisibility(View.GONE);
            my_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
            my_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        into();
        info();
    }
}
