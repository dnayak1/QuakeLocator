package com.dhirajnayak.quakelocator.view.DashboardScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.dhirajnayak.quakelocator.R;

import java.util.List;

public class DashboardAdapter extends BaseAdapter {

    private Context mContext;
    private List<Integer> mCardImages;

    public DashboardAdapter(Context mContext, List<Integer> mCardImages) {
        this.mContext = mContext;
        this.mCardImages = mCardImages;
    }

    @Override
    public int getCount() {
        return mCardImages.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(R.layout.card_item,viewGroup,false);
        view.setBackgroundResource(mCardImages.get(i));
        return view;
    }
}
