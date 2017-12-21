package com.bawei.jingdongxiangmu.deng;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.R;
import com.bawei.jingdongxiangmu.xinjia.ImgApp2;

import java.util.HashMap;

public class My_xiuActivity extends AppCompatActivity implements NicknameView{
    private ImageView my_back4;
    private nicknamePresenter nicknamePresenter;
    private String nickname;
    private TextView updata_nickname;
    private TextView my_ok;
    private String nicknames;
    private HashMap<String,String> map;
    private EditText my_nicknames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_xiu);
        my_back4 =(ImageView)findViewById(R.id.my_back4);
        my_nicknames =(EditText)findViewById(R.id.my_nicknames);
        my_ok =(TextView)findViewById(R.id.my_ok);
        my_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        nicknamePresenter = new nicknamePresenter(this,this);
        my_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(My_xiuActivity.this);
                //    设置Title的图标
                builder.setIcon(R.mipmap.ic_launcher_round);
                //    设置Title的内容
                builder.setTitle("修改操作");
                //    设置Content来显示一个信息
                builder.setMessage("确定修改吗？");
                //    设置一个PositiveButton
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        nicknames = my_nicknames.getText().toString().trim();
                        map = new HashMap<>();
                        int uid = ImgApp2.sp.getInt("uid", 0);
                        map.put("",uid+"");
                        Toast.makeText(My_xiuActivity.this,uid+"", Toast.LENGTH_SHORT).show();
                        map.put("nickname", nicknames);
                        ImgApp2.edit.putString("nickname", nicknames);
                        ImgApp2.edit.commit();
                        nicknamePresenter.Nicknames(map);
                        finish();
                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(My_xiuActivity.this, "您取消了删除" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //    设置一个NeutralButton
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(My_xiuActivity.this, "您忽略了该操作" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //    显示出该对话框
                builder.show();
            }
        });
    }
    @Override
    public void success(String tag, Object news) {
        niackanmebean hh=(niackanmebean)news;
        String code = hh.getCode();
        Toast.makeText(My_xiuActivity.this,hh.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed(String tag, String e) {

    }
}
