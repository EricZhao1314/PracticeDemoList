package com.example.aoyi.forceofflinetest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    private Button forceOffLineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        forceOffLineBtn= (Button) findViewById(R.id.force_offline_btn);

        forceOffLineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent("com.example.aoyi.forceofflinetest.FORCEOFFLINE");
                Log.d("sender", "广播发送了");
              sendBroadcast(intent);

            }
        });
    }
}
