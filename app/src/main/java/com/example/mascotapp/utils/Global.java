package com.example.mascotapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class Global {

    public static String BASE_URL="http://192.168.0.165:85";
    public static String userId;

    public static String receivedamage;
    public static String missingleg;
    public static String damageby;
    public static String missingby;

    public static boolean isOnline(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
