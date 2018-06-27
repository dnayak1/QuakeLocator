package com.dhirajnayak.quakelocator.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * implementation to check active internet connection
 */

public class Connection{

    private Context context;

    public Connection(Context context) {
        this.context = context;
    }

    //check active internet connection
    public boolean checkInternetConnection() {
        boolean wifiAvailable = false;
        boolean mobileAvailable = false;
        ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conManager!=null){
            NetworkInfo[] networkInfo = conManager.getAllNetworkInfo();
            for (NetworkInfo netInfo : networkInfo) {
                if (netInfo.getTypeName().equalsIgnoreCase("WIFI"))
                    if (netInfo.isConnected())
                        wifiAvailable = true;
                if (netInfo.getTypeName().equalsIgnoreCase("MOBILE"))
                    if (netInfo.isConnected())
                        mobileAvailable = true;
            }
            return (wifiAvailable || mobileAvailable);
        }
        return false;

    }


}
