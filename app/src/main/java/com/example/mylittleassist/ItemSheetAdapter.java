package com.example.mylittleassist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylittleassist.ItemSheetList;
import com.example.mylittleassist.R;

import java.util.ArrayList;

public class ItemSheetAdapter extends RecyclerView.Adapter<ItemSheetAdapter.ViewHolder> {

    ArrayList<ItemSheetList> items = new ArrayList<ItemSheetList>();

    @Override
    public ItemSheetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.listviewlayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSheetAdapter.ViewHolder holder, int position) {
        ItemSheetList item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ItemSheetList item) {
        items.add(item);
    }

    public void setItems(ArrayList<ItemSheetList> items) {
        this.items = items;
    }

    public ItemSheetList getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView song_name;
        TextView singer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

         //   song_name = itemView.findViewById(R.id.txv_song_name);
         //   singer    = itemView.findViewById(R.id.txv_singer);
        }

        public void setItem(ItemSheetList item) {
            song_name.setText(item.song_name);
            singer.setText(item.singer);
        }
    }
}