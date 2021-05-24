package org.techtown.simpledrawing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onColorButtonClick(View v){
        org.techtown.simpledrawing.SingleTouchView singleTouch = findViewById(R.id.singleTouchView);
//        org.techtown.simpledrawing.SingleTouchView singleTouch_r = findViewById(R.id.singleTouchView);
//        org.techtown.simpledrawing.SingleTouchView singleTouch_b = findViewById(R.id.singleTouchView);
//        org.techtown.simpledrawing.SingleTouchView singleTouch_g = findViewById(R.id.singleTouchView);

        switch (v.getId()){
            case R.id.btn_black:
                singleTouch.setColor(Color.BLACK);
                break;
            case R.id.btn_red:
                singleTouch.setColor(Color.RED);
                break;
            case R.id.btn_green:
                singleTouch.setColor(Color.GREEN);
                break;
            case R.id.btn_clear:
                singleTouch.clearPath();
                break;
        }
//                switch (v.getId()){
//            case R.id.btn_black:
//                singleTouch_b.setColor(Color.BLACK);
//                break;
//            case R.id.btn_red:
//                singleTouch_r.setColor(Color.RED);
//            case R.id.btn_green:
//                singleTouch_g.setColor(Color.GREEN);
//                break;
//            case R.id.btn_clear:
//                singleTouch_b.clearPath();
//                singleTouch_g.clearPath();
//                singleTouch_r.clearPath();
//                break;
//        }

    }
}