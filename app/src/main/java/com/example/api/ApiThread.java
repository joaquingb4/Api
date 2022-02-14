package com.example.api;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiThread extends AsyncTask<Void, Void, Void> {
    double Lat;
    double Long;

    public ApiThread(double Lat, double Long){
        this.Lat = Lat;
        this.Long = Long;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.sunrise-sunset.org/json?lat=" + Lat + "&lng="+Long);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream in = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String data = reader.readLine();
            onPostExecute(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Void onPostExecute(String data){
        try {
            JSONObject jObject = new JSONObject(data);
            jObject = jObject.getJSONObject("results");

            String sunrise = jObject.getString("sunrise");
            Log.i("prueba", "Llegue aquí");
            Log.i("logtest", "------>" + sunrise);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
