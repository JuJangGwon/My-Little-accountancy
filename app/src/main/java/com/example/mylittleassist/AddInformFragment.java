package com.example.mylittleassist;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class AddInformFragment extends Fragment {

    FragMusicSheet fragMusicSheet;

    private DatabaseReference mDatabase;

    private Button btnDialog;
    private Button btnDialog2;

    private Button addbutton;
    private Button dismissbutton;


    private Button shutdownClick;

    public EditText standard;
    public EditText madein;
    public EditText madeday;
    public EditText option;

    public boolean useable = false;

    public EditText company;
    public EditText fee;
    public EditText transport_fee;
    public EditText where;
    public EditText manager;
    public EditText phonenumber;
    public RadioGroup radioGroup;

    public TextView startday;
    public TextView endday;

    final List selectedItems = new ArrayList();
    Boolean[] selecctedB = new Boolean[9];

    DataBase dataBase;

    void MakeDataBase()
    {
        DataBase ndb;
        ndb = new DataBase(standard.getText().toString(),madein.getText().toString(),madeday.getText().toString(),selecctedB[0],selecctedB[1],selecctedB[2],selecctedB[3],selecctedB[4],selecctedB[5],selecctedB[6],selecctedB[7],useable);
        if (useable == true)
        {
            ndb.SetData(company.getText().toString(),phonenumber.getText().toString(),manager.getText().toString(),fee.getText().toString(),where.getText().toString(),transport_fee.getText().toString());
        }
        else
        {
            ndb.NoneUseable();
        }
        HashMap result = new HashMap<>();
        result.put("name", ndb.data_madein); //키, 값
        result.put("email", ndb.data_standard);
        result.put("age", ndb.data_madein);

        writeUser(ndb);

    }
    private void writeUser(DataBase ndb) {

        //데이터 저장
        mDatabase.child("jjg").child("userId").setValue(ndb)
                .addOnSuccessListener(new OnSuccessListener<Void>() { //데이터베이스에 넘어간 이후 처리
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext().getApplicationContext(),"저장을 완료했습니다", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext().getApplicationContext(),"저장에 실패했습니다" , Toast.LENGTH_LONG).show();
                    }
                });
    }

    void settings(View v)
    {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Arrays.fill(selecctedB,false);
        startday = (TextView)v.findViewById(R.id.inform_startday);
        endday = (TextView)v.findViewById(R.id.inform_endday);
        standard = (EditText) v.findViewById(R.id.inform_standard);
        option = (EditText) v.findViewById(R.id.inform_option);
        madein =  (EditText)v.findViewById(R.id.inform_madein);
        madeday =  (EditText)v.findViewById(R.id.inform_madeday);
        fee = (EditText) v.findViewById(R.id.inform_fee);
        transport_fee =  (EditText)v.findViewById(R.id.inform_transportfee);
        where =  (EditText)v.findViewById(R.id.inform_where);
        phonenumber =  (EditText)v.findViewById(R.id.inform_phonnumber);
        company =  (EditText)v.findViewById(R.id.inform_company);
        manager =  (EditText)v.findViewById(R.id.inform_mangername);

        madein.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //키패드 내리기
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(madein.getWindowToken(), 0);    //hide keyboard
                    return true;
                }
                return true;
            }
        });
        radioGroup = v.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.inform_useyes:
                        useable = true;
                        break;
                    case  R.id.inform_useno:
                        useable = false;
                        break;

                }
            }
        });
        addbutton =  (Button) v.findViewById(R.id.button7);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeDataBase();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragMusicSheet f = new FragMusicSheet();
                transaction.replace(R.id.frag_container, f);
                transaction.commit();
            }
        });
        dismissbutton =  (Button) v.findViewById(R.id.button8);
        dismissbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragMusicSheet f = new FragMusicSheet();
                transaction.replace(R.id.frag_container, f);
                transaction.commit();
            }
        });

    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.addinform_popup, container, false);

        Context context;
        context = container.getContext();
        btnDialog = (Button) v.findViewById(R.id.button5);
        btnDialog2 = (Button) v.findViewById(R.id.button4);

        settings(v);

        Button Startdate = (Button)v.findViewById(R.id.button);

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                startday.setText(year + "/" + (month+1) + "/" + dayOfMonth);
            }
        }, mYear, mMonth, mDay);

        Startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Startdate.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });
        Button endb = (Button)v.findViewById(R.id.button2);

        Calendar c1 = Calendar.getInstance();
        int mYear1 = c.get(Calendar.YEAR);
        int mMonth1 = c.get(Calendar.MONTH);
        int mDay1 = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog2 = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endday.setText(year + "/" + (month+1) + "/" + dayOfMonth);

            }
        }, mYear1, mMonth1, mDay1);

        endb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (endb.isClickable()) {
                    datePickerDialog2.show();
                }
            }
        });

        //ActionBar actionbar = ((MainActivity)getActivity()).getActionBar();
        //actionbar.setTitle("컨테이너 추가하기");


        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"에어컨","냉난방기","바닥 전기판넬","스틸 도출배관","불연재 합판","바닥 철판","철재 환풍기", "아크 누전기"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("옵션들을 선택해주세요")
                        .setMultiChoiceItems(
                                items,
                                new boolean[]{false, false, false, false, false, false, false, false},
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            Toast.makeText(context, items[which], Toast.LENGTH_SHORT).show();
                                            selectedItems.add(items[which]);
                                            selecctedB[which] = true;
                                        } else {
                                            selectedItems.remove(items[which]);
                                            selecctedB[which] = false;
                                        }
                                    }
                                })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (selectedItems.size() == 0) {
                                    Toast.makeText(context, "선택된 옵션이 없습니다.", Toast.LENGTH_SHORT).show();
                                } else {
                                    String items = "";
                                    for (int i = 0; i < selectedItems.size(); i++) {
                                        items += (selectedItems.get(i) + ", ");
                                    }
                                    selectedItems.clear();

                                    items = items.substring(0, items.length() - 2);
                                    option.setText(items);
                                    Toast.makeText(context, items, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
            }
        });
        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"3-3형", "3-4형", "3-6 A형", "3-6 산업형", "3-6 기본형", "3-7형", "3-8형", "3-9 A형", "3-9 산업형", "3-9 기본형"};
                final int[] selectedIndex = {0};

                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("규격을 선택하세요.")
                        .setSingleChoiceItems(
                                items,
                                0,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex[0] = which;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context, items[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                                standard.setText(items[selectedIndex[0]]);
                            }
                        }).create().show();
            }
        });
        return v;
    }
}
