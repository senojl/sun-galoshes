package com.lorajk.sungaloshes.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lorajk.sungaloshes.R;
import com.lorajk.sungaloshes.adapters.DailyOverviewAdapter;
import com.lorajk.sungaloshes.models.HomePage;

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

    private HomePage mHomePage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daily_overview_fragment, container, false);
        ButterKnife.inject(this, view);
        String icon = "cloud-to-butt";
        Double temp = 9001.0;
        int index = 0;

        Bundle args = getArguments();
        if(args != null){
            if(args.containsKey(DailyOverviewAdapter.ARG_ICON)){
                icon = args.getString(DailyOverviewAdapter.ARG_ICON);
            }
            if(args.containsKey(DailyOverviewAdapter.ARG_TEMP)){
                temp = args.getDouble(DailyOverviewAdapter.ARG_TEMP);
            }
            if (args.containsKey(DailyOverviewAdapter.ARG_HOME_PAGE_INDEX)) {
                index = args.getInt(DailyOverviewAdapter.ARG_HOME_PAGE_INDEX);
            }

            mIconTextView.setText(icon);
            mTempTextView.setText(temp.toString());
            setBackgroundColor(view, index);
        }
        return view;
    }

    // TODO: Remove me, just here for testing
    private void setBackgroundColor(View view, int index) {
        switch (index) {
            case HomePage.TODAY:
                view.setBackgroundColor(Color.RED);
                break;
            case HomePage.TOMORROW:
                view.setBackgroundColor(Color.YELLOW);
                break;
            case HomePage.WEEKLY:
                view.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
