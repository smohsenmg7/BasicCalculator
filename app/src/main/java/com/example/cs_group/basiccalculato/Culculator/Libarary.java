package com.example.cs_group.basiccalculato.Culculator;

import android.text.Editable;
import android.widget.EditText;

import com.example.cs_group.basiccalculato.MainActivity;

import java.util.ArrayList;

public class Libarary extends MainActivity {

    //     when an variable get completed will save in this ArrayList
    public static ArrayList<String> variables = new ArrayList<>();

    //     operator commands will save in this ArrayList ( usage : Equal method )
    public static ArrayList<String> operations = new ArrayList<>();

    public static boolean equalEffect = false, Error = false;

    //     this variable get updated till user input an operator
    public static String TempVariable = "";

    public boolean containPoint(String number) {
        if( number.equals("") ) { return false; }
        char[] charNumber = number.toCharArray();
        for (char c : charNumber) {
            if (c == '.')
                return true;
        }
        return false;
    }

    public Editable shrink(Editable text, String sign) {
        text.delete(text.length() - 1, text.length());
        return text.insert(text.length(), sign);
    }

    public void EqualMethodConditions(EditText et) {
        if (variables.size() == operations.size() && variables.size() == 0 && TempVariable.equals("")) { Error = true ; }
        if (!TempVariable.equals("")) {
            variables.add(TempVariable);
            TempVariable = "";
        }
        if (variables.size() == operations.size() && variables.size() != 0) {
            operations.remove(operations.size() - 1);
        }
        if (variables.size() == 0)
            et.setText("");

        if (variables.size() == 1)
            et.setText(variables.get(0));
    }

    public void CheckForErrors() {
        for (String num : variables) {
            if (unrecognizable_NumberFormat(num))
                Error = true;
        }
    }

    public boolean unrecognizable_NumberFormat(String number) {
        return number.equals(".");
    }

    public void Clear(EditText et) {
        variables.clear();
        operations.clear();
        et.setText("");
        TempVariable = "";
        equalEffect = false;
    }

    public void numberAfterEqual(EditText editText, boolean key) {
        if (key || Error) {
            Error = false;
            editText.setText("");
            variables.clear();
            operations.clear();
            TempVariable = "";
            equalEffect = false;
        }
    }

    public void operatorAfterEqual(EditText et, boolean key) {
        if (Error) {
            et.setText("");
            Error = false;
            Clear(et);
        }
        if (key) {
            variables.clear();
            operations.clear();
            equalEffect = false;
        }
    }

    public boolean CulculateForPriorityOne(int position, String Operation) {
        switch (Operation) {
            case "multiple":
                OperationsDeclaration.Multiple(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            case "division":
                if (variables.get(position).equals("0"))
                    Error = true;
                OperationsDeclaration.Division(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            default:
                return false;
        }
    }

    public boolean CulculateForPriorityTwo(int position, String Operation) {
        switch (Operation) {
            case "plus":
                OperationsDeclaration.Plus(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            case "minus":
                OperationsDeclaration.Minus(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            default:
                return false;
        }
    }

}
