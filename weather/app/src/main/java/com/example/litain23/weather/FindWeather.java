package com.example.litain23.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class FindWeather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_weather);

        Intent intent = getIntent();
        String getLati = intent.getStringExtra("LATITUDE");
        String getLongti = intent.getStringExtra("LONGTITUDE");

        TextView textTemperature = (TextView) findViewById(R.id.find_weather_temperature);
        TextView textWeather = (TextView)findViewById(R.id.find_weather_weather);

        textTemperature.setText("열대야");
        textWeather.setText("아마도 맑음");


    }
}
