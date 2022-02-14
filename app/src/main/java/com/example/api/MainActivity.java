package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se le pone la latitud y la longitud
        ApiThread request = new ApiThread(36.7201600,-4.4203400);
        request.execute();

    }
}