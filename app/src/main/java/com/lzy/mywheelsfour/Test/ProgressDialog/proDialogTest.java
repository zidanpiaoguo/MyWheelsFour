package com.lzy.mywheelsfour.Test.ProgressDialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.lzy.mywheelsfour.R;

/**
 * Created by 刘振远 on 2017/12/8.
 */

public class proDialogTest extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_test);


        Button button1 = findViewById(R.id.bt_1);
        Button button2 = findViewById(R.id.bt_2);
        Button button3 = findViewById(R.id.bt_3);
        Button button4 = findViewById(R.id.bt_4);
        Button button5 = findViewById(R.id.bt_5);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog =new ProgressDialog(proDialogTest.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setCancelable(true);
                dialog.setMessage("谢谢观看");
                dialog.setTitle("提示");

                dialog.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog =new ProgressDialog(proDialogTest.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setCancelable(true);

                dialog.show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog =new ProgressDialog(proDialogTest.this);
                dialog.setProgressStyle(ProgressDialog.BUTTON_POSITIVE);
                dialog.setCancelable(true);

                dialog.show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog =new ProgressDialog(proDialogTest.this);
                dialog.setProgressStyle(ProgressDialog.BUTTON_NEGATIVE);
                dialog.setCancelable(true);

                dialog.show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog =new ProgressDialog(proDialogTest.this);
                dialog.setProgressStyle(ProgressDialog.BUTTON_NEUTRAL);
                dialog.setCancelable(true);

                dialog.show();
            }
        });





    }
}
