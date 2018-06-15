package com.example.gmt_006.example.ServerUtil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class CheckConnection {
    public static boolean haveNetWorkConnection(Context context){
            boolean haveConnectWifi = false;
            boolean haveConnectMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
        for(NetworkInfo ni: networkInfos){
            if(ni.getTypeName().equalsIgnoreCase("WIFI"))
                if(ni.isConnected())
                    haveConnectWifi=true;

            if(ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if(ni.isConnected())
                    haveConnectMobile = true;
        }
        return haveConnectWifi || haveConnectMobile;
    }
    public static void thongbao(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
