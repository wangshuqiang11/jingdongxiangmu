package com.bawei.jingdongxiangmu.xinjia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.R;

import java.util.List;

/**
 * Created by Liu xiong biao on 2017/11/28.
 */

public class LeiXiangAdapter extends RecyclerView.Adapter<LeiXiangAdapter.ViewHolder> {
    private Context context;
    private List<Leixiang> list;

    public LeiXiangAdapter(Context context, List<Leixiang> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.leixianguser, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (list== null) {
            return 0;
        }
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView img;
        private  TextView price;
        private  TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
