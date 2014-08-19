package com.lorajk.sungaloshes.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lorajk.sungaloshes.R;
import com.lorajk.sungaloshes.adapters.DailyOverviewAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SunGaloshesActivity extends Activity {
    @InjectView(R.id.daily_overview_pager)
    ViewPager mDailyOverviewPager;

    DailyOverviewAdapter mDailyOverviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_galoshes);
        ButterKnife.inject(this);

        mDailyOverviewAdapter = new DailyOverviewAdapter(getFragmentManager());

        mDailyOverviewPager.setAdapter(mDailyOverviewAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sun_galoshes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
