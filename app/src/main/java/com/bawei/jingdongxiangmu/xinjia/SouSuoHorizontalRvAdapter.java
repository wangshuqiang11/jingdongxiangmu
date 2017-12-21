package com.bawei.jingdongxiangmu.xinjia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.R;

import java.util.List;

/**
 * Created by Liu xiong biao on 2017/12/10.
 */

public class SouSuoHorizontalRvAdapter  extends RecyclerView.Adapter<SouSuoHorizontalRvAdapter.ViewHolder> {
    private Context context;
    private List<String> list;

    public SouSuoHorizontalRvAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sousuoitem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = list.get(position);
        holder.tv.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.sousuohorizontaltv);
        }
    }
}
