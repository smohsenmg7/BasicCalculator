package com.example.cs_group.basiccalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //    Declare All of views
    private EditText et;
    public Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btPoint, btClear,
            btAddition, btSubtraction, btMultiplication, btDivision, btEqual, btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllOfViews();

        final NumbersOnClick Nclick = new NumbersOnClick();
        final OperationsOnClick OpsClick = new OperationsOnClick();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "1");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "2");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "3");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "4");
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "5");
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "6");
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "7");
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "8");
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "9");
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, "0");
            }
        });

        btPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nclick.start(et, ".");
            }
        });

        btAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpsClick.start(et, "plus");
            }
        });

        btSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpsClick.start(et, "minus");
            }
        });

        btMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { OpsClick.start(et, "multiple");
            }
        });

        btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpsClick.start(et, "division");
            }
        });

        btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpsClick.start(et, "equal");
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpsClick.start(et, "Del");
            }
        });

//        btClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpsClick.start(et, "clear");
//            }
//        });

        btDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                OpsClick.start(et, "LongDel");
                return false;
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
//        btClear = findViewById(R.id.buttonClear);
        btPoint = findViewById(R.id.buttonPoint);
        btDelete = findViewById(R.id.buttonDelete);
        btDivision = findViewById(R.id.buttonDivision);
        btAddition = findViewById(R.id.buttonAddiction);
        btSubtraction = findViewById(R.id.buttonSubtraction);
        btMultiplication = findViewById(R.id.buttonMultiplication);
    }

}
