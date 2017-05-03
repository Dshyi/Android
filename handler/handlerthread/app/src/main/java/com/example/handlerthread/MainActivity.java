package com.example.handlerthread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startButton = null;
    private Button endButton = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.bt1);
        startButton.setOnClickListener(new StartButtonListener());
        endButton = (Button)findViewById(R.id.bt2);
        endButton.setOnClickListener(new EndButtonListener());
    }

    Handler handler  = new Handler();
    class StartButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            handler.post(updateThread);
        }
    }
    class EndButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            handler.removeCallbacks(updateThread);
        }
    }
    Runnable updateThread =  new Runnable(){
        @Override
        public void run() {
            System.out.println("UpdateThread");
            Log.v("tag", "UpdateThread");
            handler.postDelayed(updateThread, 2000);
        }

    };
}