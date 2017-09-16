package com.faishalbadri.qasirid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.qasirid.Adapter.AdapterData;
import com.faishalbadri.qasirid.Helper.Server;
import com.faishalbadri.qasirid.Model.Pojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvData)
    RecyclerView rvData;
    private String url = Server.URL;
    private RequestQueue requestQueue;
    private Gson gson;
    private AdapterData adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setView();
        getData();
        setLayout();
    }

    private void setLayout() {
        rvData.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rvData.setLayoutManager(llm);
    }

    private void getData() {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {                                                                   // created by ahmad faishal albadri
                try {
                    if (String.valueOf(new JSONObject(response).getString("message")).equals("success")) {
                        try {
                            Log.i("Response Data", response);
                            final Pojo pojo = gson.fromJson(response, Pojo.class);
                            adapter = new AdapterData(pojo.getData(),MainActivity.this);
                            rvData.setAdapter(adapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(MainActivity.this.getApplicationContext(), "Database Is Null", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this.getApplicationContext(), "Check Your Internet Connection", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);
    }

    private void setView() {
        requestQueue = Volley.newRequestQueue(this);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }
}

