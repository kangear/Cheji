package com.kangear.cheji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.trinea.android.common.util.ShellUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShellUtils.CommandResult cr;
        if (ShellUtils.checkRootPermission()) {
            cr = ShellUtils.execCommand("ls", true);
            if(cr.result != 0) {
                ToastShow.getInstance(this).show("获取ROOT权限失败");
            }
        } else {
            ToastShow.getInstance(this).show("没有root权限");
        }
    }
}
