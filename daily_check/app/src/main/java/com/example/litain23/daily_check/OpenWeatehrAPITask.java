package com.example.litain23.daily_check;

import android.os.AsyncTask;

import java.net.MalformedURLException;

/**
 * Created by litain23 on 17. 7. 9.
 */

public class OpenWeatehrAPITask extends AsyncTask<Integer, Void, weather> {
    @Override
    public weather doInBackground(Integer... params) {
            getweatherapi api = new getweatherapi();

            int lat = params[0];
            int lon = params[1];

        weather w = null;
        try {
            w = api.getWeather(lat, lon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return w;
    }
}
