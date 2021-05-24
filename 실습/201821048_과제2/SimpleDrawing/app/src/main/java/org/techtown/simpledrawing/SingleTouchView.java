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
//    private Paint paint = new Paint();
//    private Path path = new Path();

    private Paint paint_r = new Paint();
    private Path path_r = new Path();
    public int color_r = 0;

    private Paint paint_g = new Paint();
    private Path path_g = new Path();
    public int color_g = 0;

    private Paint paint_b = new Paint();
    private Path path_b = new Path();
    public int color_b = 1;

    public SingleTouchView(Context context, AttributeSet attrs){
        super(context, attrs);

//        paint.setStrokeWidth(10.0f);
//        paint.setColor(Color.BLACK);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        paint.setAntiAlias(true);

        paint_r.setStrokeWidth(10.0f);
        paint_r.setColor(Color.RED);
        paint_r.setStyle(Paint.Style.STROKE);
        paint_r.setStrokeJoin(Paint.Join.ROUND);
        paint_r.setAntiAlias(true);

        paint_g.setStrokeWidth(10.0f);
        paint_g.setColor(Color.GREEN);
        paint_g.setStyle(Paint.Style.STROKE);
        paint_g.setStrokeJoin(Paint.Join.ROUND);
        paint_g.setAntiAlias(true);

        paint_b.setStrokeWidth(10.0f);
        paint_b.setColor(Color.BLACK);
        paint_b.setStyle(Paint.Style.STROKE);
        paint_b.setStrokeJoin(Paint.Join.ROUND);
        paint_b.setAntiAlias(true);
    }
    public void setColor(int c){
//        paint.setColor(c);
        if(c == Color.RED){
            color_r = 1;
            color_g = 0;
            color_b = 0;
        }
        if(c == Color.BLACK){
            color_r = 0;
            color_g = 0;
            color_b = 1;
        }
        if(c == Color.GREEN){
            color_r = 0;
            color_g = 1;
            color_b = 0;
        }
        invalidate();
    }

    public void clearPath(){
//        path.reset();
        path_r.reset();
        path_g.reset();
        path_b.reset();
        invalidate();
    }



    protected void onDraw(Canvas canvas){

//        canvas.drawPath(path,paint);
        canvas.drawPath(path_r,paint_r);
        canvas.drawPath(path_g,paint_g);
        canvas.drawPath(path_b,paint_b);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
//        float eventX = event.getX();
//        float eventY = event.getY();

        float eventX_r = event.getX();
        float eventY_r = event.getY();

        float eventX_g = event.getX();
        float eventY_g = event.getY();

        float eventX_b = event.getX();
        float eventY_b = event.getY();

//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                path.moveTo(eventX, eventY);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                path.lineTo(eventX, eventY);
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//            default:
//                return false;
//
//        }
        if(color_r == 1){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path_r.moveTo(eventX_r, eventY_r);
                break;
            case MotionEvent.ACTION_MOVE:
                path_r.lineTo(eventX_r, eventY_r);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }}
        if(color_g == 1){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path_g.moveTo(eventX_g, eventY_g);
                break;
            case MotionEvent.ACTION_MOVE:
                path_g.lineTo(eventX_g, eventY_g);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }}
        if(color_b == 1){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path_b.moveTo(eventX_b, eventY_b);
                break;
            case MotionEvent.ACTION_MOVE:
                path_b.lineTo(eventX_b, eventY_b);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }}
        invalidate();
        return true;
    }
}