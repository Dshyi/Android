package com.example.dialer1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText phoneNum=(EditText) findViewById(R.id.phoneNum);
        final Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View b){
                String call=phoneNum.getText().toString();
                if(PhoneNumberUtils.isGlobalPhoneNumber(call)){
                    //Intent I = new Intent(Intent.ACTION_CALL, Uri.parse("tel://" + call));
                    Intent I=new Intent(Intent.ACTION_DIAL,Uri.parse("tel://"+call));
                    startActivity(I);
                }
                else{
                    Toast.makeText(MainActivity.this,"您输入的号码不正确，请重新输入", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

