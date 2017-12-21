package com.bawei.jingdongxiangmu.deng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.R;

public class PopleActivity extends AppCompatActivity {
    private LinearLayout my_nickname3;
    private LinearLayout my_yhuname;
    private ImageView my_back3;
    private LinearLayout my_tou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pople);
        my_yhuname =(LinearLayout)findViewById(R.id.my_yhuname);
        my_nickname3 =(LinearLayout)findViewById(R.id.my_nickname3);
        my_back3 =(ImageView)findViewById(R.id.my_back3);
        my_tou =(LinearLayout)findViewById(R.id.my_tou);
        my_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        my_yhuname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopleActivity.this, "用户名不支持修改哟~", Toast.LENGTH_SHORT).show();
            }
        });
        my_nickname3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PopleActivity.this, My_xiuActivity.class);
                startActivity(intent);
            }
        });
    }
}
