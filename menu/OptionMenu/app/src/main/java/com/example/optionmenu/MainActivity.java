package com.example.optionmenu;

import android.app.Activity;
        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
        import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stubme
        menu.add(0,1,1,"保存");
        menu.add(0,2,2,"退出");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getItemId()==2){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}