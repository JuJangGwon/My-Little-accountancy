package com.example.mylittleassist;

import android.widget.TextView;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DataBase {

    public Boolean data_useable;
    public String data_standard;
    public String data_madein;
    public String data_madeday;
    public Boolean data_opt1 = false;
    public Boolean data_opt2 = false;
    public Boolean data_opt3 = false;
    public Boolean data_opt4 = false;
    public Boolean data_opt5 = false;
    public Boolean data_opt6 = false;
    public Boolean data_opt7 = false;
    public Boolean data_opt8 = false;

    public String data_company;
    public String data_phonenumber;
    public String data_name;
    public String data_fee;
    public String data_date;
    public String data_where;
    public String data_transport_fee;

    public DataBase() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public boolean getData_useable() {
        return data_useable;
    }

    public String getData_standard() {
        return data_standard;
    }
    public void setData_useable(boolean bo) {
        this.data_useable = bo;
    }

    public void setData_standard(String st) {
        this.data_standard = st;
    }
    public DataBase(String a, String b, String c,boolean d1, boolean d2, boolean d3,boolean d4,boolean d5,boolean d6,boolean d7,boolean d8,boolean e) {
        data_standard = a;
        data_madein = b;
        data_madeday = c;
        data_opt1 = d1;
        data_opt2 = d2;
        data_opt3 = d3;
        data_opt4 = d4;
        data_opt5 = d5;
        data_opt6 = d6;
        data_opt7 = d7;
        data_opt8 = d8;
        data_useable = e;
    }
    public void NoneUseable()
    {
         String data_company = null;
         String data_phonenumber= null;
         String data_name = null;
         String data_fee = null;
         String data_date = null;
         String data_where = null;
         String data_transport_fee = null;
    }

    public void SetData(String a,String b,String c,String d,String e,String f)
    {
        String data_company = a;
        String data_phonenumber= b;
        String data_name = c;
        String data_fee = d;
        String data_where = e;
        String data_transport_fee = f;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + data_standard + '\'' +
                ", email='" + data_madein + '\'' +
                '}';
    }
}