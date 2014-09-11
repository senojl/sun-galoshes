package com.lorajk.sungaloshes.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.lorajk.sungaloshes.R;
import com.lorajk.sungaloshes.adapters.DailyOverviewAdapter;
import com.lorajk.sungaloshes.api.WeatherAPIConstants;
import com.lorajk.sungaloshes.interfaces.ForecastInterface;
import com.lorajk.sungaloshes.models.forecast.Currently;
import com.lorajk.sungaloshes.models.forecast.ForecastResponse;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SunGaloshesActivity extends Activity implements ForecastInterface{
    private static final String TAG = SunGaloshesActivity.class.getSimpleName() ;
    @InjectView(R.id.daily_overview_pager)
    ViewPager mDailyOverviewPager;

    DailyOverviewAdapter mDailyOverviewAdapter;

    String url = "https://"
            + WeatherAPIConstants.FORECAST_IO_URL
            + "/" + WeatherAPIConstants.FORECAST_IO_RELATIVE
            + "/" + WeatherAPIConstants.FORECAST_API_KEY
            + "/" + WeatherAPIConstants.LAT_AUSTIN
            + "," + WeatherAPIConstants.LONG_AUSTIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_galoshes);
        ButterKnife.inject(this);

        mDailyOverviewAdapter = new DailyOverviewAdapter(getFragmentManager());

        mDailyOverviewPager.setAdapter(mDailyOverviewAdapter);

        getForecast();
    }

    public void getForecast() {
        ForecastTask task = new ForecastTask(url, this);
        task.execute();
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

    @Override
    public void onForecastFinished(JSONObject result) {
        ForecastResponse forecastResponse = new ForecastResponse();
        Currently currently = new Currently();

        try {
            JSONObject currentlyJobject = result.getJSONObject("currently");

            currently.setTemperature(currentlyJobject.getDouble("temperature"));
            currently.setIcon(currentlyJobject.getString("icon"));
        } catch (JSONException e){
            Log.e(TAG, "Yo dawg, Couldn't parse forecastresponse", e);
        }
        forecastResponse.setCurrently(currently);
        mDailyOverviewAdapter.setData(forecastResponse);
    }
}
