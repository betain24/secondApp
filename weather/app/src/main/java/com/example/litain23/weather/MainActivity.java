package com.example.litain23.weather;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBtn = (Button) findViewById(R.id.send_btn);
        sendBtn.setOnClickListener(onClickListener);


    }

    Button.OnClickListener onClickListener = new Button.OnClickListener(){
        public void onClick(View view){

            Intent intent = new Intent(MainActivity.this, FindWeather.class);
            EditText editLati = (EditText)findViewById(R.id.edittext_lati);
            EditText editLongti = (EditText)findViewById(R.id.edittext_longti);

            String getLati = editLati.getText().toString();
            String getLongti = editLongti.getText().toString();

            intent.putExtra("LATITUDE", getLati);
            intent.putExtra("LONGTITUDE", getLongti);

            startActivity(intent);
        }
    };
}
