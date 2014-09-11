package com.lorajk.sungaloshes.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.lorajk.sungaloshes.fragments.DailyOverviewFragment;
import com.lorajk.sungaloshes.models.HomePage;
import com.lorajk.sungaloshes.models.forecast.Currently;
import com.lorajk.sungaloshes.models.forecast.ForecastResponse;

/**
 * Created by lorajones on 8/2/14.
 */
public class DailyOverviewAdapter extends FragmentStatePagerAdapter {

    // For Today, Tomorrow, and the Day After Tomorrow
    public static final int NUM_DAYS = 3;
    private static final String TAG = DailyOverviewAdapter.class.getSimpleName();
    private ForecastResponse mForecastResponse;
    public static final String ARG_ICON = "arg_icon";
    public static final String ARG_TEMP = "arg_temp";
    public static final String ARG_HOME_PAGE_INDEX = "arg_home_page_index";

    public DailyOverviewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment frag;
        switch (i) {
            case HomePage.TODAY:
                frag = setupDailyFragment(i);
                break;
            case HomePage.TOMORROW:
                frag = setupDailyFragment(i);
                break;
            case HomePage.WEEKLY:
                // TODO: Change this to setup a different type of fragment
                frag = setupDailyFragment(i);
                break;
            default:
                // TODO: Handle this case. Should never get to this in production
                // TODO: May just want to throw an exception to help the developer
                frag = setupDailyFragment(i);
                break;
        }

        return frag;
    }

    private Fragment setupDailyFragment(int index) {
        Fragment frag = new DailyOverviewFragment();
        if(mForecastResponse != null) {
            Bundle args = new Bundle();
            Currently currently = mForecastResponse.getCurrently();
            if(currently != null) {
                args.putString(ARG_ICON, currently.getIcon());
                args.putDouble(ARG_TEMP, currently.getTemperature());
                args.putInt(ARG_HOME_PAGE_INDEX, index);
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
