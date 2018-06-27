package com.dhirajnayak.quakelocator.view.DashboardScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;

import com.bakerj.infinitecards.InfiniteCardView;
import com.bakerj.infinitecards.transformer.DefaultTransformerToBack;
import com.bakerj.infinitecards.transformer.DefaultTransformerToFront;
import com.bakerj.infinitecards.transformer.DefaultZIndexTransformerCommon;
import com.dhirajnayak.quakelocator.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    InfiniteCardView mInfiniteCardView;
    DashboardAdapter mDashboardAdapter;
    List<Integer> mCardImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //set the UI components
        setupView();

        //set the card images
        setupImages();

        mDashboardAdapter = new DashboardAdapter(this, mCardImages);

        //set the card View
        setInfiniteCardView();


    }

    public void setupView(){
        mInfiniteCardView = findViewById(R.id.cardView);
    }

    public void setupImages(){
        mCardImages.add(R.drawable.one);
        mCardImages.add(R.drawable.twelve);
        mCardImages.add(R.drawable.twentyfour);
        mCardImages.add(R.drawable.customize);
    }

    public void setInfiniteCardView(){
        mInfiniteCardView.setClickable(true);
        mInfiniteCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT);
        mInfiniteCardView.setAnimInterpolator(new LinearInterpolator());
        mInfiniteCardView.setTransformerToFront(new DefaultTransformerToFront());
        mInfiniteCardView.setTransformerToBack(new DefaultTransformerToBack());
        mInfiniteCardView.setZIndexTransformerToBack(new DefaultZIndexTransformerCommon());
        mInfiniteCardView.setAdapter(mDashboardAdapter);
    }
}
