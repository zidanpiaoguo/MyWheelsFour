/*
 * The author is bullet
 */

package com.lzy.mywheelsfour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lzy.sdk.widgets.CountDownTimerView;



public class MainActivity extends AppCompatActivity {

    TextView textView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.time_btn);
        CountDownTimerView countDownTimerView =
                new CountDownTimerView(textView,60000,1000);

        countDownTimerView.start();

    }

}
