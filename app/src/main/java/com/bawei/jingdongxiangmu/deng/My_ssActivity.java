package com.bawei.jingdongxiangmu.deng;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.R;
import com.bawei.jingdongxiangmu.xinjia.ImgApp2;

public class My_ssActivity extends AppCompatActivity {
    private ImageView my_back2;
    private Button my_tui;
    private TextView my_nickname2;
    private LinearLayout my_l;
    private String nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ss);
        my_back2 =(ImageView)findViewById(R.id.my_back2);
        my_nickname2 =(TextView)findViewById(R.id.my_nickname2);
        my_tui =(Button)findViewById(R.id.my_tui);
        my_l =(LinearLayout)findViewById(R.id.my_l);
        into();
        my_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //个人信息
        my_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(My_ssActivity.this, PopleActivity.class);
                startActivity(intent1);
            }
        });
        //退出登录
        my_tui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(My_ssActivity.this);
                //    设置Title的图标
                builder.setIcon(R.mipmap.ic_launcher_round);
                //    设置Title的内容
                builder.setTitle("退出操作");
                //    设置Content来显示一个信息
                builder.setMessage("确定退出登录吗？");
                //    设置一个PositiveButton
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        ImgApp2.edit.putBoolean("isLogin",false);
                        ImgApp2.edit.commit();
                        finish();
                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(My_ssActivity.this, "您取消了删除" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //    设置一个NeutralButton
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(My_ssActivity.this, "您忽略了该操作" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //    显示出该对话框
                builder.show();

            }
        });
    }
    public void into(){
        nickname = ImgApp2.sp.getString("nickname", "");
        my_nickname2.setText(nickname+"");
    }
    @Override
    protected void onResume() {
        super.onResume();
        into();
    }
}
