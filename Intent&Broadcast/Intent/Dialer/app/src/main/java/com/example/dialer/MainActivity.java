package com.example.dialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button=(Button)findViewById(R.id.btn1);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View b){
                Intent I=new Intent(Intent.ACTION_DIAL,Uri.parse("tel://114"));
                startActivity(I);
            }

        }
        );
    }
}
