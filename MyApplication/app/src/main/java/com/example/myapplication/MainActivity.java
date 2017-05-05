package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton ADD;
    private TextView showdate;
    private int year;
    private int month;
    private int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showdate=(TextView) this.findViewById(R.id.today);
        Calendar c=Calendar.getInstance(Locale.CHINA);
        Date mydate=new Date(); //获取当前日期Date对象
        c.setTime(mydate);////为Calendar对象设置时间为当前日期
        year=c.get(Calendar.YEAR); //获取Calendar对象中的年
        month=c.get(Calendar.MONTH);//获取Calendar对象中的月
        day=c.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        showdate.setText(year+"年"+(month+1)+"月"+day+"日");

        ADD = (FloatingActionButton)findViewById(R.id.bt_add);
        ADD.setOnClickListener(new ADD());

    }

    class ADD implements OnClickListener {
        public void onClick(View view){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Add_diary.class);
            MainActivity.this.startActivity(intent);
        }
    }
}
