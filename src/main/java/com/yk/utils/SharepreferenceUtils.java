package com.yk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Silence on 2016/11/19.
 */

public class SharepreferenceUtils {
    public static SharedPreferences.Editor mEditor;
    public static SharedPreferences mPreference;

    /**
     * 初始化
     *
     * @param context
     */
    public SharepreferenceUtils(Context context) {
        if (mPreference == null && context != null) {
            mPreference = context.getSharedPreferences("cmcc_omp",
                    Context.MODE_PRIVATE);
            mEditor = mPreference.edit();
        }

    }

    /**
     * 记住是否是第一次，1是第一次，否则不是第一次
     */
    public void saveIsFirst(String str) {
        mEditor.putString("isfirst", str);
        mEditor.commit();
    }

    /**
     * 获取是否是第一次进入应用
     *
     * @return
     */
    public String getIsFirst() {
        return mPreference.getString("isfirst", "1");
    }

    public void saveString(String key, String values) {
        mEditor.putString(key, values);
        mEditor.commit();
    }
    public String getString(String str) {
        return mPreference.getString(str, "");
    }
    public void saveLong(String key, long values) {
        mEditor.putLong(key, values);
        mEditor.commit();
    }

}
