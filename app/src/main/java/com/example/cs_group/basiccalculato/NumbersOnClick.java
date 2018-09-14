package com.example.cs_group.basiccalculato;

import android.util.Log;
import android.widget.EditText;

import com.example.cs_group.basiccalculato.Culculator.Libarary;

public class NumbersOnClick extends Libarary {

    public void start(EditText et, String number) {
        if (containPoint(TempVariable) && number.equals(".")) {
            Log.v("Button Point", "prevent adding point");
        } else {
            numberAfterEqual(et, equalEffect);
            et.setText(et.getText() + number);
            TempVariable += number;
        }
    }

}
