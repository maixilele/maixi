package com.example.day02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private int count = 15;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("欢迎页面（" + count + "）");
                        if (count % 5 == 0) {
                            Toast.makeText(MainActivity.this, "已经过了5秒了", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                count--;
                if (count <= 0) {
                    timer.cancel();
                }

            }
        }, 0, 1000);


    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                finish();
                break;
        }
    }
}
