package com.example.cs_group.basiccalculato;

import android.widget.EditText;

import com.example.cs_group.basiccalculato.Culculator.Libarary;

public class OperationsOnClick extends Libarary {

    public void start(EditText et, String command) {
        switch (command) {
            case "plus":
                Operations(et, command, findSign(command));
                break;
            case "minus":
                Operations(et, command, findSign(command));
                break;
            case "multiple":
                Operations(et, command, findSign(command));
                break;
            case "division":
                Operations(et, command, findSign(command));
                break;
            case "equal":
                EqualCulculation(et);
                break;
            case "clear":
                ClearCulculation(et);
                break;
            case "LongDel":
                DelLongClickCulculation(et);
                break;
            case "Del":
                DelCulculation(et);
                break;
            default:
                Error = true;
                break;
        }
    }

    public void Operations(EditText et, String command, String sign) {
        operatorAfterEqual(et, equalEffect);
        if (variables.size() == 0 && TempVariable.equals("") && !equalEffect) {
            if (command.equals("minus")) {
                et.setText(et.getText() + sign);
                TempVariable += sign;
            }
        } else {
            if (variables.size() == operations.size() && TempVariable.equals("")) {
                et.setText(shrink(et.getText(), sign));
                operations.set(operations.size() - 1, command);
            } else {
                variables.add(TempVariable);
                et.setText(et.getText() + sign);
                operations.add(command);
            }
            TempVariable = "";
            equalEffect = false;
        }
    }

    public void EqualCulculation(EditText et) {
        CheckForErrors();
        EqualMethodConditions(et);
        int priority = 1;

        while (priority <= 2 && !Error) {
            int pos = 0;
            boolean check;
            for (; pos < operations.size(); pos++) {
                switch (priority) {
                    case 1:
                        check = CulculateForPriorityOne(pos, operations.get(pos));
                        if (check) {
                            pos--;
                        }
                        break;
                    case 2:
                        check = CulculateForPriorityTwo(pos, operations.get(pos));
                        if (check) {
                            pos--;
                        }
                        break;
                }
            }
            priority++;
        }
        if (Error) {
            Clear(et);
            et.setText("Error");
        } else {
            equalEffect = true;
            TempVariable = variables.get(0);
            et.setText(variables.get(0));
        }
    }

    public void ClearCulculation(EditText et) {
        Clear(et);

    }

    public void DelLongClickCulculation(EditText et) {
        Clear(et);
    }

    public void DelCulculation(EditText et) {
        if (!et.getText().toString().isEmpty()) {
            char lastChar = et.getText().charAt(et.getText().length() - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '×' || lastChar == '÷') {
                operations.remove((operations.size() - 1));
            } else {
                if (TempVariable.isEmpty() && !variables.isEmpty()) {
                    if (variables.get(variables.size() - 1).length() == 1 || variables.get(variables.size() - 1).length() == 0) {
                        variables.remove(variables.size() - 1);
                    } else {
                        String replaceString = variables.get(variables.size() - 1).substring(0, variables.get(variables.size() - 1).length() - 1);
                        variables.set((variables.size() - 1), replaceString);
                    }
                }
            }
            et.setText(et.getText().toString().substring(0, et.getText().length() - 1));
        }
        if (!TempVariable.isEmpty()) {
            TempVariable = TempVariable.substring(0, TempVariable.length() - 1);
        }
    }

    public String findSign(String command) {
        String sign = "";
        switch (command) {
            case "plus":
                sign = "+";
                return sign;
            case "minus":
                sign = "-";
                return sign;
            case "multiple":
                sign = "×";
                return sign;
            case "division":
                sign = "÷";
                return sign;
            default:
                return sign;
        }
    }

}
