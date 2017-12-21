package com.bawei.jingdongxiangmu.xinjia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdongxiangmu.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by DangByMySide on 2017/12/5.
 */

public class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.ViewHolder> {

    private Context context;
    private List<Tui> list;
    private View view;

    public TuiAdapter(Context context, List<Tui> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.tuijian, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String img = list.get(position).img;
        String[] split = img.split("\\!");
        Glide.with(context).load(split[0]).into(holder.img);
        holder.tilte.setText(list.get(position).title);
        holder.price.setText(list.get(position).price+"");
        holder.img.setOnClickListener(new View.OnClickListener() {

            private int pid;

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LeiXiangActivity.class);
                for (int i=0;i<list.size();i++){
                    pid = list.get(i).pid;
                }
                intent.putExtra("pid", pid +"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView price;
        private  TextView tilte;
        private  ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            img=(ImageView)itemView.findViewById(R.id.shou_xrv_img);
            tilte =(TextView)itemView.findViewById(R.id.shou_xrv_title);
            price =(TextView)itemView.findViewById(R.id.shou_xrv_price);

        }
    }
}
