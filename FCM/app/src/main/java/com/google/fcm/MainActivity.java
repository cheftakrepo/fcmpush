package com.google.fcm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.app.cheftakfcmpush.utils.DeviceUtils;
import com.cheftak.jsonlibrary.utils.Utils;

public class MainActivity extends AppCompatActivity {
    private TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content=findViewById(R.id.content);
        findViewById(R.id.delet).setOnClickListener(v -> content.setText(""));
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.cheftak.msgRecived");
        intentFilter.addAction("com.cheftak.Registred");
        registerReceiver(msgReceive,intentFilter);
        DeviceUtils.getDeviceState(this);
        Log.e("url","is== "+Utils.getFileNameFromUrl("https://www.dl.farsroid.com/ap/SAI-Split-APKs-Installer-3.2+Mod(www.farsroid.com).apk"));
    }

private BroadcastReceiver msgReceive =new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if (action!=null){
                if (action.equals("com.cheftak.msgRecived")){
                    String msg=  intent.getStringExtra("content");
                    content.setText(msg);
                }else  if (action.equals("com.cheftak.Registred")){
                    String token=  intent.getStringExtra("token");
                    assert token != null;
                    Log.e("togen",token);
                    content.setText(token);
                }
            }
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(msgReceive);
    }
}
