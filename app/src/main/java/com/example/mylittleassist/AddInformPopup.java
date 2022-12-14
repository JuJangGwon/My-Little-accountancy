package com.example.mylittleassist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import java.util.ArrayList;
import java.util.List;

public class AddInformPopup extends Dialog {


    private Button btnDialog;
    private Button btnDialog2;

    private Button shutdownClick;
  //  private Button shutdownClick;

    @SuppressLint("MissingInflatedId")
    public AddInformPopup(@NonNull Context context) {
        super(context);
        setContentView(R.layout.addinform_popup);

        btnDialog = (Button)findViewById(R.id.button5);
        btnDialog2 = (Button)findViewById(R.id.button4);

        final List selectedItems = new ArrayList();

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"It/Computer", "Game", "Fassion", "VR", "Kidult", "Sports", "Music", "Movie"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("관심분야를 선택하세요.")
                        .setMultiChoiceItems(
                                items,
                                new boolean[]{false, false, false, false, false, false, false, false},
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if(isChecked){
                                            Toast.makeText(context, items[which], Toast.LENGTH_SHORT).show();
                                            selectedItems.add(items[which]);
                                        }
                                        else {
                                            selectedItems.remove(items[which]);
                                        }
                                    }
                                })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(selectedItems.size()==0){
                                    Toast.makeText(context, "선택된 옵션이 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    String items = "";
                                    for(int i = 0; i < selectedItems.size();i++){
                                        items += (selectedItems.get(i) + ", ");
                                    }
                                    selectedItems.clear();

                                    items = items.substring(0, items.length()-2);
                                    Toast.makeText(context, items, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
            }
        });
        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"3-3형", "3-4형", "3-6 A형", "3-6 산업형", "3-6 기본형", "3-7형", "3-8형", "3-9 A형","3-9 산업형", "3-9 기본형"};
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
                            }
                        }).create().show();
            }
        });
    }
}
