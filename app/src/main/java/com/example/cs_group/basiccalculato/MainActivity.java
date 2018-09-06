package com.example.cs_group.basiccalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //     when an variable get completed will save in this ArrayList
    public static ArrayList<String> variables = new ArrayList<>();

    //     operator commands will save in this ArrayList ( usage : Equal method )
    public static ArrayList<String> operations = new ArrayList<>();

    //    Declare All of views
    EditText et;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btPoint, btClear,
            btAddition, btSubtraction, btMultiplication, btDivision, btEqual, btDelete;

    boolean equalEffect = false, Error = false;// button effect on reaction of buttons when tapping them

    String TempVariable = "";// this variable get updated till user input an operator
    boolean isNegative; // is number negative or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllOfViews();// initialize All Of Buttons, editText
        setListenerForNumbersButton();//set OnClickListener method for bt0 to bt 9 and btPoint

        //set OnClickListener method for btAddiction,btSubtraction, btMultiplication, btDivision,btClear, btEqual
        setListenerForOperationButton();
    }

    private void setListenerForOperationButton() {
        btAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorAfterEqual(equalEffect);
                if (variables.size() == 0 && TempVariable.equals("") && !equalEffect) {
                    // pass Division Button
                } else {
                    if (variables.size() == operations.size() && TempVariable.equals("")) {
                        et.setText(shrink(et.getText(), "+"));
                        operations.set(operations.size() - 1, "plus");
                    } else {
                        variables.add(TempVariable);
                        et.setText(et.getText() + "+");
                        operations.add("plus");
                    }
                    TempVariable = "";
                    equalEffect = false;
                }
            }
        });

        btSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorAfterEqual(equalEffect);
                if (variables.size() == 0 && TempVariable.equals("")) {
                    et.setText(et.getText() + "-");
                    TempVariable += "-";
                } else {
                    if (equalEffect) {
                        variables.add(et.getText().toString());
                    } else {
                        if (variables.size() == operations.size() && TempVariable.equals("")) {
                            et.setText(shrink(et.getText(), "-"));
                            operations.set(operations.size() - 1, "minus");
                        } else {
                            variables.add(TempVariable);
                            et.setText(et.getText() + "-");
                            operations.add("minus");
                        }
                    }
                    TempVariable = "";
                    equalEffect = false;
                }
            }
        });

        btMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorAfterEqual(equalEffect);
                if (variables.size() == 0 && TempVariable.equals("")) {
                    // pass Division Button
                } else {
                    if (equalEffect) {
                        variables.add(et.getText().toString());
                    } else {
                        if (variables.size() == operations.size() && TempVariable.equals("")) {
                            et.setText(shrink(et.getText(), "×"));
                            operations.set(operations.size() - 1, "multiple");
                        } else {
                            variables.add(TempVariable);
                            et.setText(et.getText() + "×");
                            operations.add("multiple");
                        }
                    }
                    TempVariable = "";
                    equalEffect = false;
                }
            }
        });
        //÷
        btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operatorAfterEqual(equalEffect);
                if (variables.size() == 0 && TempVariable.equals("")) {
                    // pass Division Button
                } else {
                    if (equalEffect) {
                        variables.add(et.getText().toString());
                    } else {
                        if (variables.size() == operations.size() && TempVariable.equals("") && !equalEffect) {
                            et.setText(shrink(et.getText(), "÷"));
                            operations.set(operations.size() - 1, "division");
                        } else {
                            variables.add(TempVariable);
                            et.setText(et.getText() + "÷");
                            operations.add("division");
                        }
                    }
                    TempVariable = "";
                    equalEffect = false;
                }
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clear();
                equalEffect = false;
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
        btDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Clear();
                return false;
            }
        });

        btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckForErrors();
                EqualMethodConditions();
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
                    Clear();
                    et.setText("Error");
                } else {
                    equalEffect = true;
                    TempVariable = variables.get(0);
                    et.setText(variables.get(0));
                }
            }
        });
    }

    public void Plus(int pos) {
        if (variables.get(pos + 1) == null) {
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) + Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    public void Minus(int pos) {
        if (variables.get(pos + 1) == null) {
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) - Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    public void Multiple(int pos) {
        if (variables.get(pos + 1) == null) {
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) * Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    public void Division(int pos) {
        if (variables.get(pos + 1) == null) {
            if (variables.get(pos).equals("0"))
                et.setText("Error");
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) / Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    private void setListenerForNumbersButton() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "1");
                TempVariable += "1";

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "2");
                TempVariable += "2";

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "3");
                TempVariable += "3";

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "4");
                TempVariable += "4";

            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "5");
                TempVariable += "5";

            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "6");
                TempVariable += "6";

            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "7");
                TempVariable += "7";

            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "8");
                TempVariable += "8";

            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "9");
                TempVariable += "9";

            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberAfterEqual(equalEffect, et);
                et.setText(et.getText() + "0");
                TempVariable += "0";
            }
        });

        btPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (containPoint(TempVariable))
                    Log.v("Button Point", "prevent adding point");
                else {
                    et.setText(et.getText() + ".");
                    TempVariable += ".";
                }
            }
        });

    }

    private void initializeAllOfViews() {
        et = findViewById(R.id.editTextView);
        bt0 = findViewById(R.id.button0);
        bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        bt7 = findViewById(R.id.button7);
        bt8 = findViewById(R.id.button8);
        bt9 = findViewById(R.id.button9);
        btEqual = findViewById(R.id.buttonEqual);
        btClear = findViewById(R.id.buttonClear);
        btPoint = findViewById(R.id.buttonPoint);
        btDelete = findViewById(R.id.buttonDelete);
        btDivision = findViewById(R.id.buttonDivision);
        btAddition = findViewById(R.id.buttonAddiction);
        btSubtraction = findViewById(R.id.buttonSubtraction);
        btMultiplication = findViewById(R.id.buttonMultiplication);
    }

    public boolean containPoint(String number) {
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

    public void EqualMethodConditions() {
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

    public void Clear() {
        variables.clear();
        operations.clear();
        et.setText("");
        TempVariable = "";
        equalEffect = false;
    }

    // reaction for number button after Equal operation
    public void numberAfterEqual(boolean key, EditText editText) {
        if (key || Error) {
            Error = false;
            editText.setText("");
            variables.clear();
            operations.clear();
            TempVariable = "";
            this.equalEffect = false;
        }
    }

    //  reaction for operation button after Equal operation
    public void operatorAfterEqual(boolean key) {
        if (Error) {
            et.setText("");
            Error = false;
            Clear();
        }
        if (key) {
            variables.clear();
            operations.clear();
            this.equalEffect = false;
        }
    }

    public boolean CulculateForPriorityOne(int position, String Operation) {
        switch (Operation) {
            case "multiple":
                Multiple(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            case "division":
                if (variables.get(position).equals("0"))
                    Error = true;
                Division(position);
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
                Plus(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            case "minus":
                Minus(position);
                variables.remove(position + 1);
                operations.remove(position);
                return true;
            default:
                return false;
        }
    }

}
