package com.bawei.jingdongxiangmu.xinjia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeiXiangActivity extends AppCompatActivity implements LeiXiangView,PlusShopView {

    private RecyclerView lei_xiangrlv;
    private LeiXiangPresenter xiangPresenter;
    private LeiXiangAdapter adapter;

    List<Leixiang> list=new ArrayList<Leixiang>();
    List<PlusBeanuser> Pluslist=new ArrayList<PlusBeanuser>();
    private Button lei_xiangbutton;
    private String pid;
    private ImageView img;
    private TextView price;
    private TextView name;
    private String pid2;
    private ImageView lei_xiangback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lei_xiang);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        Intent intent1 = getIntent();
        pid2 = intent1.getStringExtra("pid");
        img =(ImageView)findViewById(R.id.lei_xiangimg);
        price =(TextView)findViewById(R.id.lei_xiangprice);
        name =(TextView)findViewById(R.id.lei_xiangname);
        lei_xiangback =(ImageView)findViewById(R.id.lei_xiangback);
        //加入购物车的按钮
        lei_xiangbutton =(Button)findViewById(R.id.lei_xiangbutton);
        xiangPresenter = new LeiXiangPresenter(this,this,list,this);
        HashMap<String, String> map = new HashMap<>();
         map.put("pid",pid2);
        map.put("source","android");
        xiangPresenter.LeiXiang(map);
        lei_xiangbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLogin = ImgApp2.sp.getBoolean("isLogin", false);
                if(isLogin){
                    int uid = ImgApp2.sp.getInt("uid", 0);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("pid",pid);
                    map.put("uid",uid+"");
                    map.put("source","android");
                    xiangPresenter.PlusShop(map);
                    Toast.makeText(LeiXiangActivity.this,"加购成功",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(LeiXiangActivity.this,"请登录....",Toast.LENGTH_SHORT).show();
                }
            }
        });
        lei_xiangback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void Leisuccess(Object o) {
        LeiXiangBean bean=(LeiXiangBean)o;
        String images = bean.getData().getImages();
        double price2 = bean.getData().getPrice();
        String title = bean.getData().getTitle();

        name.setText(title);
        price.setText("¥:"+price2+"");
        String[] split = images.split("\\|");

        Glide.with(this).load(split[0]).into(img);

    }

    @Override
    public void Leifailed(String tag, String e) {

    }

    @Override
    public void success(String tag, Object news) {
        PlusShopBean oo=(PlusShopBean)news;
        String msg = oo.getMsg();
        Pluslist.add(new PlusBeanuser(msg));

    }

    @Override
    public void failed(String tag, String e) {

    }
}
