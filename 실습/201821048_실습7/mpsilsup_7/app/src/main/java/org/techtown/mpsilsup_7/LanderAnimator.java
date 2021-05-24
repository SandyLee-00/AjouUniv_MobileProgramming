package org.techtown.mpsilsup_7;

import android.os.AsyncTask;

public class LanderAnimator extends AsyncTask<Integer, Integer, Integer> {

    private LunarView mLanerView;
    private int mX, mY;

    public LanderAnimator(LunarView lander){
        mLanerView = lander;
    }
    protected Integer doInBackground(Integer...integers){

        mX = integers[0];
        mY = integers[1];
        while (true){
            if(!mPaused){
                mX += 5;
                mY += 5;
                if(mX >= mLanerView.getWidth())
                    mX = 0;
                publishProgress(mX,mY);
            }
            try {
                Thread.sleep(100);
            }catch (Exception ex){}
        }

    }
    @Override
    protected void onProgressUpdate(Integer...values){
        super.onProgressUpdate(values);
        mLanerView.setLanderPos(values[0], values[1]);
        mLanerView.invalidate();
    }

    private boolean mPaused = false;
    protected void pauseAnimator(){
        mPaused = (!mPaused);
    }
}
