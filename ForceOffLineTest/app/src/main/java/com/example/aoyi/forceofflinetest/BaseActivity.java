package com.example.aoyi.forceofflinetest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by aoyi on 2016/12/13.
 */

public class BaseActivity extends AppCompatActivity {
    private LocalForceOfflineBroadcastReceiver localForceOfflineBroadcastReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.aoyi.forceofflinetest.FORCEOFFLINE");
        localForceOfflineBroadcastReceiver=new LocalForceOfflineBroadcastReceiver();
       registerReceiver(localForceOfflineBroadcastReceiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (localForceOfflineBroadcastReceiver!=null){
           unregisterReceiver(localForceOfflineBroadcastReceiver);
            localForceOfflineBroadcastReceiver=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class LocalForceOfflineBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, Intent intent) {
            Log.d("receiver", "接到广播");
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
            Log.d("alert", "onReceive: ");
            alertDialog.setTitle("警告");
            alertDialog.setMessage("您的账号在别的地方登录，您已被强制下线");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCollector.finishAll();
                    Intent intent1=new Intent(context,LoginActivity.class);
                    context.startActivity(intent1);
                }
            });
            alertDialog.show();
        }
    }
}
