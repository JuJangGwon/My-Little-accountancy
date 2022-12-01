package com.example.mylittleassist;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Informpopup extends Dialog {
    TextView data_useable;
    TextView data_standard;
    TextView data_madein;
    TextView data_name;
    TextView data_fee;
    TextView data_date;
    TextView data_where;
    TextView data_transport_fee;
    private Button shutdownClick;
  //  private Button shutdownClick;

    public Informpopup(@NonNull Context context,String a, String b, String c, String d, String e,String f,String g,String h) {
        super(context);
        setContentView(R.layout.inform_popup);

        data_useable = findViewById(R.id.data_useable);
        data_standard = findViewById(R.id.data_standard);
        data_madein = findViewById(R.id.data_madein);
        data_name = findViewById(R.id.data_name);
        data_fee = findViewById(R.id.data_fee);
        data_date = findViewById(R.id.data_date);
        data_where = findViewById(R.id.data_where);
        data_transport_fee = findViewById(R.id.data_transport_fee);
        this.data_useable.setText(a);
        this.data_standard.setText(b);
        this.data_madein.setText(c);
        this.data_name.setText(d);
        this.data_fee.setText(e);
        this.data_date.setText(f);
        this.data_where.setText(g);
        this.data_transport_fee.setText(h);

        shutdownClick = findViewById(R.id.btn_shutdown);
        shutdownClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
