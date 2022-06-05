package com.example.exp10navi;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class directrplyreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput= RemoteInput.getResultsFromIntent(intent);
        if(remoteInput!=null){
            CharSequence replytext=remoteInput.getCharSequence("key_text_reply");
            Message answer=new Message(replytext,"Me");
            exp7.messages.add(answer);
            exp7.autorplynotification(context);
        }
    }
}
