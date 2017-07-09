package com.example.litain23.daily_check;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String get_lati= intent.getStringExtra("com.example.litain23.daily_check.LATITUDE");
        String get_longti= intent.getStringExtra("com.example.litain23.daily_check.LONGTITUDE");


        OpenWeatehrAPITask t = new OpenWeatehrAPITask();
        try{
            weather w = t.execute(Integer.parseInt(get_lati), Integer.parseInt(get_longti)).get();

            TextView temp= (TextView)findViewById(R.id.temperature);
            TextView humid= (TextView)findViewById(R.id.humidity);
            TextView city = (TextView)findViewById(R.id.city);
            TextView weat = (TextView)findViewById(R.id.weather);

            Double celsius = Double.parseDouble(String.format("%.2f", ((double)w.getTemperature()-273.15)));

            temp.setText(String.valueOf(celsius));
            humid.setText(String.valueOf(w.getHumidity()));
            city.setText(w.getCity());
            weat.setText(w.getWeat());

            //System.out.println(w.getTemperature());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
