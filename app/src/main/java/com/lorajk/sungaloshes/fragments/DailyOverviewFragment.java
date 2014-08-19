package com.lorajk.sungaloshes.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lorajk.sungaloshes.R;

import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lorajones on 8/2/14.
 */
public class DailyOverviewFragment extends Fragment{
    @InjectView(R.id.icon)
    TextView mIconTextView;
    @InjectView(R.id.temperature)
    TextView mTempTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daily_overview_fragment, container, false);
        ButterKnife.inject(this, view);

        mIconTextView.setText("partly-cloudy-day");
        mTempTextView.setText("87.26");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
