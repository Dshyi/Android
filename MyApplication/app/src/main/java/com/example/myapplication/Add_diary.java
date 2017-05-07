package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cc.trity.floatingactionbutton.FloatingActionButton;

public class Add_diary extends AppCompatActivity {
        private Intent intent;
        private Bundle bundle;
        private TextView showdate;
        private int year;
        private int month;
        private int day;
        private ImageView mbutton;
        private FloatingActionButton diary_add;
        private FloatingActionButton diary_delete;
        private FloatingActionButton diary_back;
        private EditText title;
        private EditText con;
        private database base;
        private SQLiteDatabase db;



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

            diary_add = (FloatingActionButton)findViewById(R.id.add_diary_add);
            diary_delete = (FloatingActionButton)findViewById(R.id.add_diary_delete);
            diary_back = (FloatingActionButton)findViewById(R.id.add_diary_back);
            title=(EditText)findViewById(R.id.title_text);
            con=(EditText)findViewById(R.id.content_text) ;
            base=new database(this);

            diary_add.setOnClickListener(new FloatingActionButton.OnClickListener(){
                public void onClick(View v){
                    addDB();
                    finish();
                }
            });

            diary_back.setOnClickListener(new FloatingActionButton.OnClickListener(){
                public void onClick(View v){
                    title.setText("");
                    con.setText("");
                }
            });

            diary_delete.setOnClickListener(new FloatingActionButton.OnClickListener(){
                public void onClick(View v){

                }
            });




            mbutton=(ImageView)findViewById(R.id.back);
            mbutton.setOnClickListener(new ImageView.OnClickListener(){
                public void onClick(View v){
                    Add_diary.this.setResult(RESULT_OK,intent);
                    Add_diary.this.finish();
                }
            });
        }

    public void addDB() {
        db = base.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(database.TITLE, title.getText().toString());
        cv.put(database.CONTENT, con.getText().toString());
        cv.put(database.TIME, showdate.getText().toString());
        if (title.getText().toString().length() != 0 || con.getText().toString().length() != 0) {
            db.insert(database.table_name, null, cv);
            Toast.makeText(Add_diary.this, "添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Add_diary.this, "请输入你的内容！", Toast.LENGTH_SHORT).show();
        }
    }

}
