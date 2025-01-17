package com.example.backpackerlk.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.backpackerlk.Domains.AdventureDomain;
import com.example.backpackerlk.R;

import java.util.ArrayList;

public class AdventureAdapter extends RecyclerView.Adapter<AdventureAdapter.ViewHolder> {

    ArrayList<AdventureDomain> items;

    public AdventureAdapter(ArrayList<AdventureDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicPath()
                ,"drawable",holder.itemView.getContext().getPackageName());


               Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picImg);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView picImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.advntitle1);
            picImg=itemView.findViewById(R.id.advnimage);
        }
    }
}