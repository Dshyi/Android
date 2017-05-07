package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
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
    private database base;
    private SQLiteDatabase dbreader;
    private ListView list;
    private MyAdapter adapter;
    private  Cursor cursor;

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
        showdate.setText("Today:"+year+"年"+(month+1)+"月"+day+"日");

        ADD = (FloatingActionButton)findViewById(R.id.bt_add);
        ADD.setOnClickListener(new ADD());

        list=(ListView) findViewById(R.id.show);
        base =new database(this);
        dbreader =base.getReadableDatabase();
        list.setOnItemClickListener(new list());


        }


    class ADD implements OnClickListener {
        public void onClick(View view){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Add_diary.class);
            MainActivity.this.startActivity(intent);
        }
    }
    public  void selectDB(){
        cursor=dbreader.query(database.table_name,null,null,null,
                null,null,null);
        adapter = new MyAdapter(this,cursor);
        list.setAdapter(adapter);
    }
    public void onResume(){
        super.onResume();
        selectDB();
    }

    class list implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            cursor.moveToPosition(position);
            Intent i=new Intent(MainActivity.this,select.class);
            i.putExtra(database.ID,cursor.getInt(cursor.getColumnIndex(database.ID)));
            i.putExtra(database.TITLE,cursor.getString(cursor.getColumnIndex(database.TITLE)));
            i.putExtra(database.CONTENT,cursor.getString(cursor.getColumnIndex(database.CONTENT)));
            i.putExtra(database.TIME,cursor.getString(cursor.getColumnIndex(database.TIME)));
            startActivity(i);
        }
    }

}
