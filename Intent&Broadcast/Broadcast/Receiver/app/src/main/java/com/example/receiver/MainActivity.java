package com.example.receiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    private Button myButton = null;
    private final String listen ="jump";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button)findViewById(R.id.button);
        myButton.setOnClickListener(new MyButtonListener());
    }
    class MyButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(listen);
            intent.putExtra("testIntent", "abcdefg");
            sendBroadcast(intent);
        }
    }
}
