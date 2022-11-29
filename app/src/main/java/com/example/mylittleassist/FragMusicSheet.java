package com.example.mylittleassist;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class FragMusicSheet extends Fragment {

    private List<ItemSheetList> userList;
    private List<ItemSheetList> saveList;

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


        Button btn1 = (Button)rootView.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initUI2(rootView);
            }
        });

     /*
        EditText search = rootView.findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Text가 바뀔때마다 함수가 실행되는 함수
              //  searchUser(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        */
        return rootView;
    }
    /*
    public void searchUser(String search){
        userList.clear();
        for(int i= 0; i< saveList.size();i++){
            if(saveList.get(i).getUserID().contains(search)){
                userList.add(saveList.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }

     */
    private void initUI(ViewGroup rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemSheetAdapter();

        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("dd", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("ff", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));

        recyclerView.setAdapter(adapter);
    }

    private void initUI2(ViewGroup rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemSheetAdapter();

        adapter.addItem(new ItemSheetList("oio", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("dd", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("ff", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));
        adapter.addItem(new ItemSheetList("내 손을 잡아", "아이유(IU)"));

        recyclerView.setAdapter(adapter);
    }
}