package com.lorajk.sungaloshes.models;

/**
 * Created by lorajones on 8/4/14.
 */
public class ForecastResponse {
    private double latitude;
    private double longitude;
    private String timezone;
    private int offset;

    private Currently currently;
    private Minutely minutely;
    private Hourly hourly;
    private Daily daily;
    private Flags flags;
}
