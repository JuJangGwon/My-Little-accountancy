package com.example.mylittleassist;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

public class FragMusicSheet extends Fragment {

    RecyclerView recyclerView;
    ItemSheetAdapter adapter;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context != null) {
            context = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_frag_music_sheet, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemSheetAdapter();

        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));

        recyclerView.setAdapter(adapter);
    }
}