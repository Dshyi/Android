package com.example.alertdialog;



import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setTitle("欢迎");
        dialog.setMessage("欢迎使用本程序");
        dialog.setPositiveButton("退出", new OnClickListener() {
            public void onClick(DialogInterface a0, int a1) {
                System.exit(0);
            }
        });
        dialog.setNegativeButton("确定", new OnClickListener() {
            public void onClick(DialogInterface a0, int a1) {
            }
        });
        dialog.create();
        dialog.show();
    }
}
