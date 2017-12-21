package com.bawei.jingdongxiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bawei.jingdongxiangmu.fenlei.LeiSonYeAdapter;
import com.bawei.jingdongxiangmu.fenlei.LeiSonYeBean;
import com.bawei.jingdongxiangmu.fenlei.LeiSonYePresenter;
import com.bawei.jingdongxiangmu.fenlei.LeiSonYeView;
import com.bawei.jingdongxiangmu.xinjia.LeiXiangActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoDetailsActivity extends AppCompatActivity implements LeiSonYeView {
    private ListView lei_sonyerlv;
    private LeiSonYePresenter yePresenter;
    private LeiSonYeAdapter sonYeAdapter;
    List<LeiSonYeBean.DataBean> list=new ArrayList<LeiSonYeBean.DataBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_details);
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        Log.i("TAG",pscid+"s");
        lei_sonyerlv =(ListView)findViewById(R.id.lei_sonyerlv);
        yePresenter = new LeiSonYePresenter(this, this);
        HashMap<String, String> map = new HashMap<>();
        map.put("pscid",pscid);
        yePresenter.Lei3(map);
        lei_sonyerlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(InfoDetailsActivity.this, LeiXiangActivity.class);
                int pid = list.get(i).getPid();
                intent1.putExtra("pid", pid + "");
                startActivity(intent1);
            }
        });
    }
    @Override
    public void Leisuccess(final List<LeiSonYeBean.DataBean> list2) {
        list.addAll(list2);
        sonYeAdapter = new LeiSonYeAdapter(this, list2);
        lei_sonyerlv.setAdapter(sonYeAdapter);
        sonYeAdapter.notifyDataSetChanged();
    }

    @Override
    public void Leifailed(String tag, String e) {

    }
}
