package com.example.mylittleassist;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

public class FragMusicSheet extends Fragment {

    private List<ItemSheetList> userList;
    private List<ItemSheetList> saveList;

    Informpopup informpopup;
    RecyclerView recyclerView;
    ItemSheetAdapter adapter;

    Context context;

    Button addinform_b;

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

        addinform_b = (Button)rootView.findViewById(R.id.addinform);
        addinform_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddInformFragment addinformFragment = new AddInformFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.frag_container, addinformFragment).commit();
            }
        });
        Button btn1 = (Button)rootView.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initUI2(rootView);
                ActionBar actionBar;
            }
        });

        adapter.setOnItemClickListener(new ItemSheetAdapter.OnItemClickListener () {

            //아이템 클릭시 토스트메시지
            @Override
            public void onItemClick(View v, int position) {
              //  String name = adapter.getItem(position).song_name;
              //  String number = adapter.getItem(position).song_name;
              //  Toast.makeText (context, "이름 : "+name+"\n전화번호 : "+number, Toast.LENGTH_SHORT).show ();
                informpopup = new Informpopup(context, adapter.getItem(position).data_useable, adapter.getItem(position).data_standard, adapter.getItem(position).data_madein, adapter.getItem(position).data_name, adapter.getItem(position).data_fee, adapter.getItem(position).data_where, adapter.getItem(position).data_date, adapter.getItem(position).data_date);
                informpopup.show();

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

        //saveList.add(new ItemSheetList("3-3형", "1호"));
        // 사용중인지, 규격 / 어디서 만들었는지 / 이름 / 요금 / 기간 / 위치 / 운송료 /
        adapter.addItem(new ItemSheetList("사용 중","3-3형","2022년 10월 24일 | 광주","홍길동","월 15만원","2022.01.14~2022.02.14","서울 구로구 연동로 320","왕복 지불 "));
        adapter.addItem(new ItemSheetList("사용 가능","3-6형","2022년 11월 11일 | 광주","홍길동","월 15만원","2022.01.14~2022.02.14","서울 구로구 연동로 320","왕복 지불 "));
        adapter.addItem(new ItemSheetList("사용 가능","3-6형","2022년 3월 22일 | 광주","홍길동","월 15만원","2022.01.14~2022.02.14","서울 구로구 연동로 320","왕복 지불 "));
        adapter.addItem(new ItemSheetList("사용 기능","3-7형","2022년 1월 24일 | 광주","홍길동","월 15만원","2022.01.14~2022.02.14","서울 구로구 연동로 320","왕복 지불 "));
        adapter.addItem(new ItemSheetList("사용 가능","3-7형","2022년 5월 2일 | 광주","홍길동","월 15만원","2022.01.14~2022.02.14","서울 구로구 연동로 320","왕복 지불 "));

        recyclerView.setAdapter(adapter);
    }

    private void initUI2(ViewGroup rootView) {
        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemSheetAdapter();

        recyclerView.setAdapter(adapter);
    }
}