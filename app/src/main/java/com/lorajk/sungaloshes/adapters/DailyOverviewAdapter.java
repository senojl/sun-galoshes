package com.lorajk.sungaloshes.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.lorajk.sungaloshes.fragments.DailyOverviewFragment;
import com.lorajk.sungaloshes.models.ForecastResponse;

/**
 * Created by lorajones on 8/2/14.
 */
public class DailyOverviewAdapter extends FragmentPagerAdapter {

    // For Today, Tomorrow, and the Day After Tomorrow
    public static final int NUM_DAYS = 3;
    private ForecastResponse mForecastResponse;

    public DailyOverviewAdapter(FragmentManager fm, ForecastResponse forecastResponse) {
        super(fm);
        mForecastResponse = forecastResponse;
    }

    @Override
    public Fragment getItem(int i) {
        return new DailyOverviewFragment();
    }

    @Override
    public int getCount() {
        return NUM_DAYS;
    }
}
