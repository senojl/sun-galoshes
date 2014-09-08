package com.lorajk.sungaloshes.api;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lorajones on 8/4/14.
 */
public class WeatherAPI {
    private URL mUrl;

    public WeatherAPI(String urlString) {
        try {
            mUrl = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public JSONObject httpGet(){
        HttpURLConnection urlConnection = null;

        JSONObject jsonObject = null;
        try {
            urlConnection = (HttpURLConnection) mUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String responseString = readStream(in);
            try {
                jsonObject = new JSONObject(responseString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e){
            e.printStackTrace();
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return jsonObject;
    }

    private String readStream(InputStream in){
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(is);
        String responseString = "";
        String currentLine = null;
        try {
            currentLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (currentLine != null) {
            responseString += currentLine;
            try {
                currentLine = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return responseString;
    }
}
