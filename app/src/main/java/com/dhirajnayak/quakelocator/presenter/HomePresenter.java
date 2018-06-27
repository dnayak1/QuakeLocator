package com.dhirajnayak.quakelocator.presenter;

import android.content.Context;

import com.dhirajnayak.quakelocator.utility.Connection;
import com.dhirajnayak.quakelocator.view.HomeScreen.HomeView;

/**
 * Name: HomePresenter
 * Purpose: Handles the communication between HomeActivity and Connection
 */

public class HomePresenter {
    private HomeView mHomeView;
    private Context mContext;

    //parameterized constructor
    public HomePresenter(HomeView mHomeView, Context mContext) {
        this.mHomeView = mHomeView;
        this.mContext = mContext;
    }

    /**
     * method to check for active internet connection
     */
    public void isActiveConnection(){
        Connection connection = new Connection(mContext);
        if(connection.checkInternetConnection()){
            mHomeView.internetConnectionSuccess();
        }else{
            mHomeView.internetConnectionFailed();
        }
    }
}
