package com.example.cs_group.basiccalculato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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

        /**
         * @mKarimian
         * set OnClickListener for button button0 to button 9
         * set OnClickListener for buttonAddiction, buttonSubtraction, buttonMultiplication, buttonDivision
         */

        /**
         * @sMarshi
         * set OnClickListener for buttonEqual
         */
    }
}
