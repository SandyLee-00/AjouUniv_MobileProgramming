package org.techtown.square;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;

public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }


    // 1. define and create a handler instance.
    // 2. create a messenger instance with the handler (mAngleReceiver).

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message message) {
            Log.d("태그", "메시지_hadleMessage");
            mRenderer.setAngle((float)(message.obj));
            requestRender();
        }

    };
    public Messenger getAngleReceiver(){
        Log.d("태그", "메시지_getAngle");
        return new Messenger(handler);
    }

}