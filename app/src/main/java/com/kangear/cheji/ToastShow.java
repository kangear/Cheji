package com.kangear.cheji;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastShow {
	private final Context context;
	private Toast toast = null;

	/**
	 * 单例模式: http://coolshell.cn/articles/265.html
	 */
	private volatile static ToastShow singleton = null;
	private static Context mContext;

	public static ToastShow getInstance(Context context)   {
		if (singleton == null)  {
			synchronized (ToastShow.class) {
				if (singleton == null)  {
					singleton = new ToastShow(context.getApplicationContext());
					mContext = context;
				}
			}
		}
		return singleton;
	}

	public void setGravity(int gravity, int xOffset, int yOffset) {
		toast.setGravity(Gravity.CENTER, 0, 0);
	}

	public ToastShow(Context context) {
		this.context = context;
		toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
	}

	public void show(String text) {
		if (toast == null) {
			toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			toast.setText(text);
		}
		toast.show();
	}

	public void showLong(String text) {
		if (toast == null) {
			toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			toast.setText(text);
		}
		toast.show();
	}
}
