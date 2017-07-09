package com.example.litain23.daily_check;

import org.json.JSONArray;
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

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by litain23 on 17. 7. 9.
 */

public class getweatherapi {
    final static String weatherURL = "http://api.openweathermap.org/data/2.5/weather";
    final static String apiKey = "961ba22e445ac4376dbd39d39199248c";

    public weather getWeather(int lati, int longti) throws MalformedURLException {
        weather w = new weather();

        String totalURL= weatherURL + "?lat=" + lati + "&lon=" + longti + "&appid=" + apiKey;
        try{
            URL url = new URL(totalURL);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("getWeatherApi");
            JSONObject json = new JSONObject(getStringFromInput(in));

            w = parseJSON(json);
            w.setLati(lati);
            w.setLongti(longti);

            //System.out.println("temp : " + w.getTemperature());
            //System.out.println("humid : " + w.getHumidity());
            //System.out.println("city : " + w.getTemperature());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return w;
    }

    private weather parseJSON(JSONObject json) throws JSONException{
        weather w = new weather();
        w.setTemperature(json.getJSONObject("main").getInt("temp"));
        w.setCity(json.getString("name"));
        w.setHumidity(json.getJSONObject("main").getInt("humidity"));
        //JSONArray temp = json.getJSONArray("weather");
        //System.out.println(temp.getJSONObject(0).getString("main"));
        w.setWeat(json.getJSONArray("weather").getJSONObject(0).getString("main"));
        return w;
    }




    private String getStringFromInput(InputStream is){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String str;
        try{
            br = new BufferedReader(new InputStreamReader(is));
            while((str = br.readLine()) != null){
                sb.append(str);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(br != null){
                try{
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return sb.toString();
    }
}
