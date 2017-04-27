package com.example.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class other extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String value = intent.getStringExtra("testIntent");
        Log.e("IntentReceiver-->Test", value);
    }

}