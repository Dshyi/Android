package com.example.progressdialog;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar firstBar = null;
    private ProgressBar secondBar = null;
    private Button myButton = null;
    private int i = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBar = (ProgressBar) findViewById(R.id.progressBar);
        secondBar = (ProgressBar) findViewById(R.id.progressBar2);
        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            if (i == 0) {
                // 设置进度条处于可见的状态
                firstBar.setVisibility(View.VISIBLE);
                secondBar.setVisibility(View.VISIBLE);
                firstBar.setMax(150);
            } else if (i < firstBar.getMax()) {
                // 设置主进度条的当前值
                firstBar.setProgress(i);
                // 设置第二进度条的当前值
                secondBar.setProgress(i + 10);
            } else {
                // 设置进度条处于不可见状态
                firstBar.setVisibility(View.GONE);
                secondBar.setVisibility(View.GONE);
            }
            i = i + 10;
        }
    }
}
