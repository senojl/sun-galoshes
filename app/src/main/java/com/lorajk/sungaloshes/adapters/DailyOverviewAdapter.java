package com.lorajk.sungaloshes.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.lorajk.sungaloshes.fragments.DailyOverviewFragment;
import com.lorajk.sungaloshes.models.Currently;
import com.lorajk.sungaloshes.models.ForecastResponse;

/**
 * Created by lorajones on 8/2/14.
 */
public class DailyOverviewAdapter extends FragmentPagerAdapter {

    // For Today, Tomorrow, and the Day After Tomorrow
    public static final int NUM_DAYS = 3;
    private ForecastResponse mForecastResponse;
    public static final String ARG_ICON = "arg_icon";
    public static final String ARG_TEMP = "arg_temp";

    public DailyOverviewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        DailyOverviewFragment frag = new DailyOverviewFragment();
        if(mForecastResponse != null) {
            Bundle args = new Bundle();
            Currently currently = mForecastResponse.getCurrently();
            if(currently != null) {
                args.putString(ARG_ICON, currently.getIcon());
                args.putDouble(ARG_TEMP, currently.getTemperature());
                frag.setArguments(args);
            }
        }
        return frag;
    }

    public void setData(ForecastResponse forecastResponse){
        mForecastResponse = forecastResponse;
        notifyDataSetChanged();
    }

    public int getItemPosition(Object object){
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return NUM_DAYS;
    }
}
