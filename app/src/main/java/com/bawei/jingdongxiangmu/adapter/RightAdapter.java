package com.bawei.jingdongxiangmu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.InfoDetailsActivity;
import com.bawei.jingdongxiangmu.R;
import com.bawei.jingdongxiangmu.bean.ProductCatagoryBean;

import java.util.List;

/**
 * Created by wsq on 2017/11/11.
 * 二级列表适配器
 */

public class RightAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> groupList;//一级列表数据
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList;//二级列表数据
    private LayoutInflater inflater;

    public RightAdapter(Context context, List<List<ProductCatagoryBean.DataBean.ListBean>> childList, List<String> groupList) {
        this.context = context;
        this.childList = childList;
        this.groupList = groupList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        View view;
        if (convertView == null) {
            holder = new GroupViewHolder();
            view = inflater.inflate(R.layout.elv_item1, null);
            holder.tv = (TextView) view.findViewById(R.id.tv01);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (GroupViewHolder) view.getTag();
        }
        String str = groupList.get(groupPosition);
        holder.tv.setText(str);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        View view;
        if (convertView == null) {
            holder = new ChildViewHolder();
            view = inflater.inflate(R.layout.elv_item2, null);
            holder.rv = (RecyclerView) view.findViewById(R.id.rv);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ChildViewHolder) view.getTag();
        }
        List<ProductCatagoryBean.DataBean.ListBean> listBeen = childList.get(groupPosition);
        //1.给RecyclerView设置布局管理器
        holder.rv.setLayoutManager(new GridLayoutManager(context, 3));//这个布局管理器，是类似gridcview的效果
        //2.设置适配器
        ElvRvAdapter elvRvAdapter = new ElvRvAdapter(context, listBeen);
        holder.rv.setAdapter(elvRvAdapter);
        elvRvAdapter.setOnItemClickListener(new ElvRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ProductCatagoryBean.DataBean.ListBean listBean) {
                //就是跳转
                Intent intent = new Intent(context, InfoDetailsActivity.class);
                intent.putExtra("pscid", listBean.getPscid()+"");
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    class GroupViewHolder {
        TextView tv;
    }

    class ChildViewHolder {
        RecyclerView rv;
    }
}
