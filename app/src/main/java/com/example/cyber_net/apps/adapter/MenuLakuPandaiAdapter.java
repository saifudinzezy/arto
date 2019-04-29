package com.example.cyber_net.apps.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cyber_net.apps.R;
import com.example.cyber_net.apps.model.MenuModel;

import java.util.List;

public class MenuLakuPandaiAdapter extends RecyclerView.Adapter<MenuLakuPandaiAdapter.ViewHolder> {
    private Context context;
    private List<MenuModel> list;
    private OnSelect listener;


    public MenuLakuPandaiAdapter(Context context, List<MenuModel> list) {
        this.context = context;
        this.list = list;
    }

    public MenuLakuPandaiAdapter(Context context, List<MenuModel> list, OnSelect listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_menu_pop_up, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.ivGambarMenu.setImageResource(list.get(position).getIconMenu());
        holder.tvNamaMenu.setText(list.get(position).getNamaMenu());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarMenu;
        TextView tvNamaMenu;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGambarMenu = itemView.findViewById(R.id.img_menu);
            tvNamaMenu = itemView.findViewById(R.id.txt_menu);
        }
    }

    public interface OnSelect{
        public void select();
    }
}
