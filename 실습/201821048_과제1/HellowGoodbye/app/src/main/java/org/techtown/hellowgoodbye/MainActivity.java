package org.techtown.hellowgoodbye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double opnd = 0;
    private double value0 = 0;
    private double value1 = 0;
    private int oper = 0;
    private int result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtResult = (TextView)findViewById(R.id.text_result);

        ((Button)findViewById(R.id.button_1)).setOnClickListener(
                (v) -> {appendDigit(0);}
        );
        ((Button)findViewById(R.id.button_1)).setOnClickListener(
                (v) -> {appendDigit(1);}
        );
        ((Button)findViewById(R.id.button_2)).setOnClickListener(
                (v) -> {appendDigit(2);}
        );
        ((Button)findViewById(R.id.button_3)).setOnClickListener(
                (v) -> {appendDigit(3);}
        );
        ((Button)findViewById(R.id.button_4)).setOnClickListener(
                (v) -> {appendDigit(4);}
        );
        ((Button)findViewById(R.id.button_5)).setOnClickListener(
                (v) -> {appendDigit(5);}
        );
        ((Button)findViewById(R.id.button_6)).setOnClickListener(
                (v) -> {appendDigit(6);}
        );
        ((Button)findViewById(R.id.button_7)).setOnClickListener(
                (v) -> {appendDigit(7);}
        );
        ((Button)findViewById(R.id.button_8)).setOnClickListener(
                (v) -> {appendDigit(8);}
        );
        ((Button)findViewById(R.id.button_9)).setOnClickListener(
                (v) -> {appendDigit(9);}
        );
        ((Button)findViewById(R.id.button_0)).setOnClickListener(
                (v) -> {appendDigit(0);}
        );
        ((Button)findViewById(R.id.button_c)).setOnClickListener(
                (v) -> {
                    opnd = 0;
                    value0 = 0;
                    value1 = 0;
                    final TextView txtResult_c = (TextView)findViewById(R.id.text_result);
                    txtResult_c.setText("0");
                }
        );
        ((Button)findViewById(R.id.button_add)).setOnClickListener(
                (v) -> {add();}
        );
        ((Button)findViewById(R.id.button_sub)).setOnClickListener(
                (v) -> {sub();}
        );
        ((Button)findViewById(R.id.button_mul)).setOnClickListener(
                (v) -> {mul();}
        );
        ((Button)findViewById(R.id.button_div)).setOnClickListener(
                (v) -> {div();}
        );
        ((Button)findViewById(R.id.button_cal)).setOnClickListener(
                (v) -> {cal();}
        );
    }

    private void appendDigit(int a) {
        opnd = opnd*10 + a;
        final TextView txtResult = (TextView)findViewById(R.id.text_result);
        if(value0%1==0)
        {
            int k = Integer.parseInt(String.valueOf(Math.round(opnd)));
            txtResult.setText(""+k);
        }
        else
        {
            txtResult.setText(""+opnd);
        }

    }
    private void add() {
        value0 = opnd;
        opnd = 0;
        oper = 1;
        final TextView txtResult = (TextView)findViewById(R.id.text_result);
        if(value0%1==0)
        {
            int k = Integer.parseInt(String.valueOf(Math.round(value0)));
            txtResult.setText(""+k);
        }
        else
        {
            txtResult.setText(""+value0);
        }

    }
    private void sub() {
        value0 = opnd;
        opnd = 0;
        oper = 2;
        final TextView txtResult = (TextView)findViewById(R.id.text_result);
        if(value0%1==0)
        {
            int k = Integer.parseInt(String.valueOf(Math.round(value0)));
            txtResult.setText(""+k);
        }
        else
        {
            txtResult.setText(""+value0);
        }

    }
    private void mul() {
        value0 = opnd;
        opnd = 0;
        oper = 3;
        final TextView txtResult = (TextView)findViewById(R.id.text_result);
        txtResult.setText(""+'*');
    }
    private void div() {
        value0 = opnd;
        opnd = 0;
        oper = 4;
        final TextView txtResult = (TextView)findViewById(R.id.text_result);
        txtResult.setText(""+'/');
    }

    private void cal() {
        value1 = opnd;

        if(oper == 1){
            value0 = value0 + value1;
            final TextView txtResult = (TextView)findViewById(R.id.text_result);
            if(value0%1==0)
            {
                int k = Integer.parseInt(String.valueOf(Math.round(value0)));
                txtResult.setText(""+k);
            }
            else
            {
                txtResult.setText(""+value0);
            }

        }
        else if(oper == 2){
            value0 = value0 - value1;
            final TextView txtResult = (TextView)findViewById(R.id.text_result);
            if(value0%1==0)
            {
                int k = Integer.parseInt(String.valueOf(Math.round(value0)));
                txtResult.setText(""+k);
            }
            else
            {
                txtResult.setText(""+value0);
            }

        }
        else if(oper == 3){
            value0 = value0 * value1;
            final TextView txtResult = (TextView)findViewById(R.id.text_result);
            if(value0%1==0)
            {
                int k = Integer.parseInt(String.valueOf(Math.round(value0)));
                txtResult.setText(""+k);
            }
            else
            {
                txtResult.setText(""+value0);
            }

        }
        else if(oper == 4){
            value0 = value0 / value1;
            final TextView txtResult = (TextView)findViewById(R.id.text_result);
            if(value0%1==0)
            {
                int k = Integer.parseInt(String.valueOf(Math.round(value0)));
                txtResult.setText(""+k);
            }
            else
            {
                txtResult.setText(""+value0);
            }

        }

    }



}