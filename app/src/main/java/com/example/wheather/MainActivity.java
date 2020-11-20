package com.example.wheather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private String getWeatherInfo(String urlStr){
        try {
            URL url = new URL(urlStr);
            URLConnection conn =url.openConnection();
            InputStream is =conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line = null;

            //code = conn.getResponseCode();

            while ((line = br.readLine())!=null){
                sb.append(line+"\n");

            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "例外1";
        } catch (IOException e) {
            e.printStackTrace();
            return "例外2";
        }
    }
}