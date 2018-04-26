package com.kangear.cheji;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import cn.trinea.android.common.util.FileUtils;
import cn.trinea.android.common.util.ShellUtils;

public class MediaYuyinReceiver extends BroadcastReceiver {

    public void onReceive(Context paramContext, Intent paramIntent) {
        int value = paramIntent.getIntExtra("value", 0);
        int state = paramIntent.getIntExtra("state", 0);
        String msg = "value: " + value + " state: " + state;
        ToastShow.getInstance(paramContext).show(msg);

        if (state != 2) {
            return;
        }

        String cmd = null;
        String key = "KEYCODE_MEDIA_NEXT";

        switch (value) {
            case 14:
                key = "KEYCODE_MEDIA_PLAY";
                break;
            case 19:
                key = "KEYCODE_MEDIA_PREVIOUS";
                break;
            case 20:
                key = "KEYCODE_MEDIA_NEXT";
                break;
            default:
                return;
        }

        // am broadcast -a com.spd.system.key --ei value 14 --ei state 2
        cmd = "input keyevent " + key;

        ShellUtils.CommandResult cr;
        if (ShellUtils.checkRootPermission()) {
            cr = ShellUtils.execCommand(cmd, true);
            if(cr.result != 0) {
                ToastShow.getInstance(paramContext).show("发送键值失败");
            }
        } else {
            ToastShow.getInstance(paramContext).show("没有root权限");
        }
    }
}
