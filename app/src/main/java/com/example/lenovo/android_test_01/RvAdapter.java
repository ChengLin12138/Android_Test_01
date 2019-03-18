package com.example.lenovo.android_test_01;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.example.lenovo.android_test_01.M.FoodBean;

import java.util.List;
//TODO RecyclerView适配器
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    List<FoodBean.DataBean> list;

    public void setList(List<FoodBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        return new ViewHolder(inflater.inflate(R.layout.item_rv, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //TODO 往控件上赋值
        viewHolder.textView.setText(list.get(i).getTitle());
        //TODO Glide缓存图片
        Glide.with(viewHolder.itemView.getContext())
                .load(list.get(i).getPic())
                .into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO 拿到适配器控件
            imageView = itemView.findViewById(R.id.item_img);
            textView = itemView.findViewById(R.id.item_text);

        }
    }

}
