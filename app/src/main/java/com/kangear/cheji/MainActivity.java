package com.kangear.cheji;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.trinea.android.common.util.ShellUtils;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_SPD_KEY = "com.spd.system.key";
    public static final String ACTION_SPD_STRING_VALUE = "value";
    public static final String ACTION_SPD_STRING_STATE = "state";
    public static final int SPD_KEY_VALUE_14   = 14;
    public static final int SPD_KEY_VALUE_19   = 19;
    public static final int SPD_KEY_VALUE_20   = 20;
    public static final int SPD_KEY_STATE_DOWN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ShellUtils.CommandResult cr;
        if (ShellUtils.checkRootPermission()) {
            cr = ShellUtils.execCommand("ls", true);
            if(cr.result != 0) {
                ToastShow.getInstance(this).show("获取ROOT权限失败");
            }
        } else {
            ToastShow.getInstance(this).show("没有root权限");
        }

        // 发送广播，解决需要再次按下的问题
        Intent intent = new Intent(ACTION_SPD_KEY);
        intent.putExtra(ACTION_SPD_STRING_VALUE, SPD_KEY_VALUE_14);
        intent.putExtra(ACTION_SPD_STRING_STATE, SPD_KEY_STATE_DOWN);
        sendBroadcast(intent);

        finish();
    }
}
