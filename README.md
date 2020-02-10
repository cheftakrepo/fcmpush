# CheftakFCMPush

this libraray use FCM to send push Messages to Android users


### Installing

add this line to gradle

```
implementation 'com.app.cheftakfcmpush:cheftakfcmpush:1'
```

## Getting Started

in Application class you must init the library 

```
CheftakPush.init(this);
```

if you whant to recive custom json create class extended from CheftakPushListener and override onMessageReceived method

```

public class PushService extends CheftakPushListener {
    @Override
    public void onMessageReceived(JSONObject messageContent) {
        Log.e("PushService","message is "+messageContent.toString());        
    }
}

```
