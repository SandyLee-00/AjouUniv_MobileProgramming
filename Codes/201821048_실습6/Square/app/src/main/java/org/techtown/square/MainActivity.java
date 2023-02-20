package org.techtown.square;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view){
        Log.d("태그", "메시지");
        Intent intent = new Intent(this, AnimationService.class);
        MyGLSurfaceView glview = (MyGLSurfaceView)findViewById(R.id.glView);
        Messenger angleReceiver = glview.getAngleReceiver();
        intent.putExtra("ValueMessenger", angleReceiver);
        intent.putExtra("StartValue", 0.0f);
        intent.putExtra("EndValue", 360.0f);
        intent.putExtra("IncValue", 1.0f);
        intent.putExtra("UpdateTime", 100.0f);

        startService(intent);


    }
}