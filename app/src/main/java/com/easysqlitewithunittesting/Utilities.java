package com.easysqlitewithunittesting;

import android.util.Log;

/**
 * Created by waleed on 27/07/2014.
 */
public class Utilities {

    public static final void Log(String message){
        Log("EasySQLite",message);
    }

    public static final void Log(String tag, String messgae){
        Log.d(tag,messgae);
    }
}
