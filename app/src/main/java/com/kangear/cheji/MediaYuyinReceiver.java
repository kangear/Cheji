package com.kangear.cheji;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MediaYuyinReceiver extends BroadcastReceiver {

    public void onReceive(Context paramContext, Intent paramIntent) {
        int value = paramIntent.getIntExtra("value", 0);
        int state = paramIntent.getIntExtra("state", 0);
        String msg = "value: " + value + " state: " + state;
        Toast.makeText(paramContext.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
