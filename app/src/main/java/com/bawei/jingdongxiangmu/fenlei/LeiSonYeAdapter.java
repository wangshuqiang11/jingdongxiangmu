package com.bawei.jingdongxiangmu.fenlei;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by wsq on 2017/11/28.
 */

public class LeiSonYeAdapter extends BaseAdapter {
    private Context context;
    private List<LeiSonYeBean.DataBean> list;
    private ViewHolder holder;

    public LeiSonYeAdapter(Context context, List<LeiSonYeBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            holder =new ViewHolder();
            view = View.inflate(context, R.layout.lei_sonyeuser, null);
            holder.lei_sonyeimg=view.findViewById(R.id.lei_sonyeimg);
            holder.lei_sonyename=view.findViewById(R.id.lei_sonyename);
            holder.lei_sonyeprice=view.findViewById(R.id.lei_sonyeprice);
            view.setTag(holder);
        }else{
            holder=(ViewHolder)view.getTag();
        }
        holder.lei_sonyename.setText(list.get(i).getTitle());
        holder.lei_sonyeprice.setText(list.get(i).getPrice() + "");
        String images = list.get(i).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder.lei_sonyeimg);
        return view;
    }

     class ViewHolder  {

        private ImageView lei_sonyeimg;
        private TextView lei_sonyename;
        private TextView lei_sonyeprice;

        }

}
