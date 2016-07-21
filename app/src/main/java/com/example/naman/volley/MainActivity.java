package com.example.naman.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
TextView tv;
    RequestQueue queue;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= (TextView) findViewById(R.id.textView);
        queue= Volley.newRequestQueue(this);

        url="https://open-event.herokuapp.com/api/v2/events/4";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                tv.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error.getCause()!=null)
                {
                    error.getCause().printStackTrace();
                }
                if(error.networkResponse!=null)
                {
                    Toast.makeText(MainActivity.this,"error"+error.networkResponse,Toast.LENGTH_SHORT).show();
                }
            }
        });

        queue.add(stringRequest);
        tv= (TextView) findViewById(R.id.textView);
    }
}
