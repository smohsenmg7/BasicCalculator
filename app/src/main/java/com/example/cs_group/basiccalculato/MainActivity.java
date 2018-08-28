package com.example.cs_group.basiccalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,btPoint,btClear;
    Button btAddition,btSubtraction,btMultiplication,btDivision,btEqual;

    /**
     * @fMaghami
     * Declare each view of activity_main.xml like buttons and editText
     * name of each view should be ths same as its ID;
     */


    /**
     * @param mValueOne
     * first number of functions
     * @param mValueTwo
     * second number of functions
     */
    float mValueOne, mValueTwo;

    /**
     * @param mAddition
     * if user click Add button the mAddition value is set True on the click listener of Add button.
     */
    boolean mAddition, mSubtract, mMultiplication, mDivision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * @fMaghami
         * Initialize each view of activity_main.xml like buttons and editText
         * set OnClickListener for buttonClear
         * set OnClickListener for buttonPoint
         */
        et = findViewById(R.id.editTextView);
        bt0= findViewById(R.id.button0);
        bt1= findViewById(R.id.button1);
        bt2= findViewById(R.id.button2);
        bt3= findViewById(R.id.button3);
        bt4= findViewById(R.id.button4);
        bt5= findViewById(R.id.button5);
        bt6= findViewById(R.id.button6);
        bt7= findViewById(R.id.button7);
        bt8= findViewById(R.id.button8);
        bt9= findViewById(R.id.button9);
        btEqual= findViewById(R.id.buttonEqual);
        btClear= findViewById(R.id.buttonClear);
        btPoint= findViewById(R.id.buttonPoint);
        btDivision= findViewById(R.id.buttonDivision);
        btAddition= findViewById(R.id.buttonAddiction);
        btSubtraction= findViewById(R.id.buttonSubtraction);
        btMultiplication= findViewById(R.id.buttonMultiplication);

        /**
         * @mKarimian
         * set OnClickListener for button button0 to button 9
         * set OnClickListener for buttonAddiction, buttonSubtraction, buttonMultiplication, buttonDivision
         */

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"1");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"2");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"3");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"4");
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"5");
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"6");
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"7");
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"8");
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"9");
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"0");
            }
        });

        btAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mValueOne = Float.parseFloat(et.getText() + "");
                    mAddition = true;
                    et.setText(null);
            }
        });

        btSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(et.getText() + "");
                mSubtract = true ;
                et.setText(null);
            }
        });

        btMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(et.getText() + "");
                mMultiplication = true ;
                et.setText(null);
            }
        });

        btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(et.getText()+"");
                mDivision = true ;
                et.setText(null);
            }
        });

        /**
         * @sMarshi
         * set OnClickListener for buttonEqual
         */
    }
}
