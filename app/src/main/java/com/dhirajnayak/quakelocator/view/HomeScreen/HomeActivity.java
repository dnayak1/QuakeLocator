package com.dhirajnayak.quakelocator.view.HomeScreen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dhirajnayak.quakelocator.R;
import com.dhirajnayak.quakelocator.presenter.HomePresenter;
import com.dhirajnayak.quakelocator.view.DashboardScreen.DashboardActivity;
import com.wang.avi.AVLoadingIndicatorView;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private HomePresenter mHomePresenter;
    private AVLoadingIndicatorView mProgressLoading;
    private Snackbar mSnackbar;
    private View mParentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //setting up view components
        setUpView();

        mHomePresenter = new HomePresenter(this,this);

        //check internet connection
        performInit();
    }

    //on invalid internet connection
    @Override
    public void internetConnectionFailed() {
        mSnackbar=Snackbar.make(mParentView,"No Internet Connection!",Snackbar.LENGTH_INDEFINITE);
        mSnackbar.setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performInit();
            }
        });
        mSnackbar.setActionTextColor(Color.RED);
        mSnackbar.show();
        mProgressLoading.setVisibility(View.INVISIBLE);
    }

    //onValid internet connection
    @Override
    public void internetConnectionSuccess() {
        Intent intent=new Intent(HomeActivity.this,DashboardActivity.class);
        startActivity(intent);
    }

    //set up the view components
    public void setUpView(){
        mProgressLoading = findViewById(R.id.progressLoading);
        mParentView = findViewById(android.R.id.content);
    }

    //called for showing the home screen for 3 seconds
    public void performInit(){
        mProgressLoading.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                mHomePresenter.isActiveConnection();
            }
        }, 3000);
    }
}
