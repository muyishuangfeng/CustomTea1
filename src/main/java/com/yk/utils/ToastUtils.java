package com.yk.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Silence on 2016/11/19.
 */

public class ToastUtils {
    public static Toast toast;

    public static void showToast(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}
