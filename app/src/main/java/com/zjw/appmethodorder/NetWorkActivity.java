package com.zjw.appmethodorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleCursorTreeAdapter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetWorkActivity extends AppCompatActivity {
    private final  static String TAG = NetWorkActivity.class.getSimpleName();
    private final String PUBLIC_URL="https://api.github.com/user/repos?page=2&per_page=100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
    }

    /**
     * Request network
     */
    public void request(View view){
        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(PUBLIC_URL)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG,response.body().string());
            }
        });


    }
}
