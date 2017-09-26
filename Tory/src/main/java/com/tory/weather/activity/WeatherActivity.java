package com.tory.weather.activity;

import android.app.Activity;
import android.os.Bundle;

import com.tory.weather.R;

public class WeatherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }
}
