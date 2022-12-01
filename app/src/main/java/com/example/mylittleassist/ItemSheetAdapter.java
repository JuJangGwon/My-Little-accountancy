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

    //아이템 클릭 리스너 인터페이스
    public interface OnItemClickListener {
        public void onItemClick(View v, int position); //뷰와 포지션값
    }

    //리스너 객체 참조 변수
    public OnItemClickListener mListener = null;

    //리스너 객체 참조를 어댑터에 전달 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ItemSheetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_sheet_list, parent, false);
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

    class ViewHolder extends RecyclerView.ViewHolder {

       // TextView data_num;
        TextView data_useable;
        TextView data_standard;
        TextView data_madein;
        TextView data_name;
        TextView data_fee;
        TextView data_date;
        TextView data_where;
        TextView data_transport_fee;
        TextView data_now;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // data_num = itemView.findViewById(R.id.data_num);
            data_useable = itemView.findViewById(R.id.data_useable);
            data_standard = itemView.findViewById(R.id.data_standard);
            data_madein = itemView.findViewById(R.id.data_madein);
            data_name = itemView.findViewById(R.id.data_name);
            data_fee = itemView.findViewById(R.id.data_fee);
            data_date = itemView.findViewById(R.id.data_date);
            data_where = itemView.findViewById(R.id.data_where);
            data_transport_fee = itemView.findViewById(R.id.data_transport_fee);
            data_now = itemView.findViewById(R.id.data_now);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(view, position);
                        }
                    }
                }
            });
        }
        public void setItem(ItemSheetList item) {
            data_standard.setText(item.data_standard);
            data_useable.setText(item.data_useable);
            data_where.setText(item.data_where);


            // singer.setText(item.singer);
        }
        public void setPopupItem(ItemSheetList item) {

            data_useable.setText((item.data_useable));
            data_standard.setText((item.data_standard));
            data_madein.setText((item.data_madein));
            data_name.setText((item.data_name));
            data_fee.setText((item.data_fee));
            data_date.setText((item.data_date));
            data_where.setText((item.data_where));
            data_transport_fee.setText((item.data_transport_fee));
            data_now.setText((item.data_now));
            //   song_name.setText(item.song_name);
            //   singer.setText(item.singer);
        }
    }
}
