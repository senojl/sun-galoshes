package com.lorajk.sungaloshes.models;

/**
 * Created by lorajones on 8/4/14.
 */
public class Daily {

    private String summary;
    private String icon;
    private DailyDetail[] data;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public DailyDetail[] getData() {
        return data;
    }

    public void setData(DailyDetail[] data) {
        this.data = data;
    }
}
