package org.techtown.simpledrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



public class SingleTouchView extends View{
    private Paint paint = new Paint();
    private Path path = new Path();
    public SingleTouchView(Context context, AttributeSet attrs){
        super(context, attrs);

        paint.setStrokeWidth(10.0f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setAntiAlias(true);
    }
    public void setColor(int c){
        paint.setColor(c);
        invalidate();
    }

    public void clearPath(){
        path.reset();
        invalidate();
    }



    protected void onDraw(Canvas canvas){
        canvas.drawPath(path,paint);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        float eventX = event.getX();
        float eventY = event.getY();


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;



        }
        invalidate();
        return true;
    }
}