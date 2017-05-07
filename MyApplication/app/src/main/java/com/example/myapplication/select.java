package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import cc.trity.floatingactionbutton.FloatingActionButton;

/**
 * Created by ASUS on 2017/5/7.
 */

public class select extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton select_back;
    private FloatingActionButton select_delete;
//  private FloatingActionButton select_change;
    private EditText select_title;
    private EditText select_content;
    private database base;
    private SQLiteDatabase dbwriter;
//  private SQLiteDatabase dbupdater;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        select_delete = (FloatingActionButton)findViewById(R.id.select_delete);
        select_back = (FloatingActionButton)findViewById(R.id.select_back);
        select_title=(EditText)findViewById(R.id.select_title);
        select_content=(EditText)findViewById(R.id.select_content);
        base=new database(this);
        dbwriter=base.getWritableDatabase();
//      dbupdater=base.getWritableDatabase();
        select_back.setOnClickListener(this);
        select_delete.setOnClickListener(this);
//      select_change.setOnClickListener(this);
        select_title.setText(getIntent().getStringExtra(database.TITLE));
        select_content.setText(getIntent().getStringExtra(database.CONTENT));
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.select_back:
                finish();
                break;

            case R.id.select_delete:
                deleteDate();
                finish();
                break;

            /**
            case R.id.select_change:
                update();
                finish();
                break;          */
        }
    }
    public void deleteDate(){
        dbwriter.delete(database.table_name,"_id="+getIntent().getIntExtra(database.ID,0),null);

    }
    /**
    public void update(){
        ContentValues cv = new ContentValues();
        cv.put(database.TITLE, select_title.getText().toString());
        cv.put(database.CONTENT, select_content.getText().toString());
        dbupdater.update(database.table_name,cv,"TITLE = ?", new String[]{select_title.getText().toString()});
        dbupdater.update(database.table_name,cv,"CONTENT = ?", new String[]{select_content.getText().toString()});
    } */
}
