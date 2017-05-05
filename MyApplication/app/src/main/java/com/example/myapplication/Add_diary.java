package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Add_diary extends AppCompatActivity {
        private Intent intent;
        private Bundle bundle;
        private TextView showdate;
        private int year;
        private int month;
        private int day;
        private ImageView mbutton;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add);

            showdate=(TextView) this.findViewById(R.id.thisday);
            Calendar c=Calendar.getInstance(Locale.CHINA);
            Date mydate=new Date(); //获取当前日期Date对象
            c.setTime(mydate);////为Calendar对象设置时间为当前日期
            year=c.get(Calendar.YEAR); //获取Calendar对象中的年
            month=c.get(Calendar.MONTH);//获取Calendar对象中的月
            day=c.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
            showdate.setText(year+"年"+(month+1)+"月"+day+"日");

            mbutton=(ImageView)findViewById(R.id.back);
            mbutton.setOnClickListener(new ImageView.OnClickListener(){
                public void onClick(View v){
                    Add_diary.this.setResult(RESULT_OK,intent);
                    Add_diary.this.finish();
                }
            });
        }
}
