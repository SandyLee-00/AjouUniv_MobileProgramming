package org.techtown.square;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;


public class AnimationService extends IntentService {


    public AnimationService() {
        super("AnimationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("태그", "메시지_onhandle");
        Messenger valMessenger = (Messenger)intent.getExtras().get("ValueMessenger");
        float startAngle = intent.getFloatExtra("StartValue", 0);
        float endAngle = intent.getFloatExtra("EndValue", 0);
        float incAngle = intent.getFloatExtra("IncValue", 1);
        float stepTime = intent.getFloatExtra("UpdateTime", 10);

        while (startAngle < endAngle){
            Message msg = Message.obtain();
            msg.obj = new Float(startAngle);
            try {
                valMessenger.send(msg);
                Log.d("태그", "메시지_onhandle_aftersend");
                Thread.sleep((long)stepTime);
            }catch (android.os.RemoteException ex){
            }catch (InterruptedException ex){

            }
            startAngle += incAngle;
        }
    }


}