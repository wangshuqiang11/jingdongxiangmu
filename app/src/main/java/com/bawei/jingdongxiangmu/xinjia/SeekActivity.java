package com.bawei.jingdongxiangmu.xinjia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.jingdongxiangmu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeekActivity extends AppCompatActivity {
    @BindView(R.id.ssfinish)
    Button ssfinish;
    @BindView(R.id.ssedit)
    EditText ssedit;
    @BindView(R.id.ssbutton)
    Button ssbutton;
    @BindView(R.id.sousuohorizontalrv)
    RecyclerView sousuohorizontalrv;
    @BindView(R.id.sousuoverticalrv)
    RecyclerView sousuoverticalrv;
    private List<String> strlist = new ArrayList<>();
    private SouSuoVerticalRvAdapter souSuoVerticalRvAdapter;
    private static final String TAG = "SouSuoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        initData();

        souSuoVerticalRvAdapter = new SouSuoVerticalRvAdapter(SeekActivity.this, strlist);

        LinearLayoutManager tManager = new LinearLayoutManager(SeekActivity.this, LinearLayoutManager.VERTICAL, true);

        sousuoverticalrv.setLayoutManager(tManager);

        sousuoverticalrv.setAdapter(souSuoVerticalRvAdapter);

    }
    private void initData() {

        List<String> horizontallist = new ArrayList<>();

        horizontallist.add("雷朋镜架");
        horizontallist.add("耐克 新品");
        horizontallist.add("9分裤 新品");
        horizontallist.add("青年套装");
        horizontallist.add("电脑支架");
        horizontallist.add("匡威板鞋 新品");
        horizontallist.add("背包新品");
        horizontallist.add("笔记本电脑");
        horizontallist.add("邮差包 新品");
        horizontallist.add("钳子");
        horizontallist.add("无人机");


        SouSuoHorizontalRvAdapter souSuoHorizontalRvAdapter = new SouSuoHorizontalRvAdapter(SeekActivity.this, horizontallist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SeekActivity.this, LinearLayoutManager.HORIZONTAL, false);

        sousuohorizontalrv.setLayoutManager(linearLayoutManager);

        sousuohorizontalrv.setAdapter(souSuoHorizontalRvAdapter);
    }
    @OnClick({R.id.ssfinish, R.id.ssbutton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ssfinish:

                finish();
                break;
            case R.id.ssbutton:

                String sseditstr = ssedit.getText().toString().trim();

                if (sseditstr != null && !sseditstr.equals("")) {
                    strlist.add(sseditstr);
                }
                souSuoVerticalRvAdapter.notifyDataSetChanged();
                if (sseditstr.equals("笔记本")){
                    Intent intent = new Intent(SeekActivity.this, Leisonye_Activity.class);
                    intent.putExtra("pscid","40");
                    startActivity(intent);
                }else if(sseditstr.equals("手机")){
                    Intent intent = new Intent(SeekActivity.this, Leisonye_Activity.class);
                    intent.putExtra("pscid","39");
                    startActivity(intent);
                }
                break;


        }
    }

    @OnClick(R.id.clearbtn)
    public void onViewClicked() {
        strlist.clear();
        souSuoVerticalRvAdapter.notifyDataSetChanged();
    }
}
