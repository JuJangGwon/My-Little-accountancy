package com.example.mylittleassist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalanderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalanderFragment extends Fragment {

    TextView monthYearText; //년월 텍스트뷰

    LocalDate selectedDate; //년월 변수

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CalanderFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static CalanderFragment newInstance(String param1, String param2) {
        CalanderFragment fragment = new CalanderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_calander, container, false);

        monthYearText = v.findViewById(R.id.monthYearText);
        ImageButton prevBtn = v.findViewById(R.id.pre_btn);
        ImageButton nextBtn = v.findViewById(R.id.next_btn);

        //현재 날짜
        selectedDate = LocalDate.now();

        //화면 설정
        setMonthView();

        //이전달 버튼 이벤트
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //현재 월-1 변수에 담기
                selectedDate = selectedDate.minusMonths(1);
                setMonthView();
            }
        });

        //다음달 버튼 이벤트
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 월+1 변수에 담기
                selectedDate = selectedDate.plusMonths(1);
                setMonthView();
            }
        });
        return v;
    }
    private String monthYearFromDate(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 yyyy");
        return date.format(formatter);
    }

    private void setMonthView() {

        //년월 텍스트뷰 셋팅
        monthYearText.setText(monthYearFromDate(selectedDate));
    }
}