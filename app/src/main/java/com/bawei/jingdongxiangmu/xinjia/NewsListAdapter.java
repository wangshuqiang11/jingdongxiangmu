package com.bawei.jingdongxiangmu.xinjia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Liu xiong biao on 2017/11/9.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
   private Context context;
    private List<RelvBean> list2;

    public NewsListAdapter(Context context, List<RelvBean> list2) {
        this.context = context;
        this.list2 = list2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recyclerview, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list2.get(position).img).into(holder.rimg);
        holder.name.setText(list2.get(position).name);
    }

    @Override
    public int getItemCount() {
        if (list2 == null) {
            return 0;
        }
        return list2.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView rimg;
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            rimg = (ImageView)itemView.findViewById(R.id.Rimg);
            name = (TextView)itemView.findViewById(R.id.Rname);
        }
    }
}

