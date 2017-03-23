package com.example.xmldesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ASUS on 2017/3/22.
 */

public class other extends Activity{
    Intent intent;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        Bundle bundle=this.getIntent().getExtras();
        String ans=bundle.getString("ans");
        String setText="";
        if (ans.equals("in")){
            setText="正确";
        } else{
            setText="错误";
        }
        TextView t1=(TextView)findViewById(R.id.textView);
        t1.setText("您选择的答案是："+setText);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){
         public void onClick(View v){
                other.this.setResult(RESULT_OK,intent);
             other.this.finish();
            }
        });
    }
}
