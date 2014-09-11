package com.lorajk.sungaloshes.activities;

import android.os.AsyncTask;
import android.util.Log;

import com.lorajk.sungaloshes.api.WeatherAPI;
import com.lorajk.sungaloshes.interfaces.ForecastInterface;

import org.json.JSONObject;

/**
 * Created by lorajones on 8/21/14.
 */
public class ForecastTask extends AsyncTask<Void, Void, JSONObject> {

    private static final String TAG = ForecastTask.class.getSimpleName();
    WeatherAPI mWeatherAPI;

    private ForecastInterface mListener;

    public ForecastTask (String url, ForecastInterface listener) {
        mWeatherAPI = new WeatherAPI(url);
        mListener = listener;
    }

    protected JSONObject doInBackground(Void...JSONObject){
        JSONObject forecastJsonObject = mWeatherAPI.httpGet();
        return forecastJsonObject;
    }

    protected void onPostExecute(JSONObject result) {
        mListener.onForecastFinished(result);
    }
}