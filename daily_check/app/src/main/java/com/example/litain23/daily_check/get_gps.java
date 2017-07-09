package com.example.litain23.daily_check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class get_gps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_gps);
    }

    public void sendGPS(View view) {
        EditText lati= (EditText)findViewById(R.id.latitude);
        EditText longti= (EditText)findViewById(R.id.latitude);
        String get_lati= lati.getText().toString();
        String get_longti= longti.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("com.example.litain23.daily_check.LATITUDE", get_lati);
        intent.putExtra("com.example.litain23.daily_check.LONGTITUDE", get_longti);
        startActivity(intent);
    }

}
