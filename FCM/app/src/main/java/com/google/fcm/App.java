package com.google.fcm;

import androidx.multidex.MultiDexApplication;

import com.app.cheftakfcmpush.core.CheftakPush;
//import com.app.cheftakfcmpush.core.CheftakPush;

//import com.pushpole.sdk.PushPole;

public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        CheftakPush.init(this);
       //PushPole.initialize(this,false);
    }
}