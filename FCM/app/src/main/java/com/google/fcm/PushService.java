package com.google.fcm;

import android.util.Log;
import com.app.cheftakfcmpush.component.CheftakPushListener;
import com.cheftak.jsonlibrary.jsonhandler.ProcessJson;
import org.json.JSONObject;

public class PushService extends CheftakPushListener {
    @Override
    public void onMessageReceived(JSONObject messageContent) {
        Log.e("PushService","message is "+messageContent.toString());
        try {
            new ProcessJson(this,messageContent).process(false);
        }catch (Exception e){
           Log.e("onMessageReceived","err",e);
        }
    }
}
