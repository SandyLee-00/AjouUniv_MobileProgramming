package org.techtown.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView cal = (CalendarView)findViewById(R.id.calendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                EditText date = (EditText)findViewById(R.id.textDate);
                date.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                year_sel = year;
                month_sel = month + 1;
                day_sel = dayOfMonth;
            }
        });

        TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                EditText time = (EditText)findViewById(R.id.textTime);
                time.setText(hourOfDay + ":" + minute);
                hour_sel = hourOfDay;
                min_sel = minute;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reservemenu,menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.clear){
            final Calendar c = Calendar.getInstance();
            CalendarView cal = (CalendarView)findViewById(R.id.calendarView);
            TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
            cal.setDate(c.getTimeInMillis());

            int hour_sys = c.get(Calendar.HOUR_OF_DAY);
            int min_sys = c.get(Calendar.MINUTE);
            timePicker.setHour(hour_sys);
            timePicker.setMinute(min_sys);

            int year_sys = c.get(Calendar.YEAR);
            int month_sys = c.get(Calendar.MONTH);
            int day_sys = c.get(Calendar.DAY_OF_MONTH);
            EditText date = (EditText)findViewById(R.id.textDate);
            date.setText(year_sys + "/" + (month_sys+1) + "/" + day_sys);

            Toast test = Toast.makeText(getApplicationContext(), year_sel + "년" + month_sel + "월" + day_sel + "일" + hour_sel + ":" + min_sel + "분에서 시스템 값으로 바뀌었습니다.", Toast.LENGTH_SHORT);
            test.show();

        }
        return true;
    }

    int year_sel;
    int month_sel;
    int day_sel;
    int hour_sel;
    int min_sel;

    //CharSequence reserve = (year + "년" + month + "월" + day + "일" + hour + ":" + min + "분에 예약하시겠습니까?");
    //CharSequence reserve_yes= (year + "년" + month + "월" + day + "일" + hour + ":" + min + "분에 예약되었습니다");

    public void OnClickeHandler(View view){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("" +
                year_sel + "년" + month_sel + "월" + day_sel + "일" + hour_sel + ":" + min_sel + "분에 예약하시겠습니까?"
        );
        alertDialogBuilder.setPositiveButton("예약",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast yes = Toast.makeText(getApplicationContext(),
                                year_sel + "년" + month_sel + "월" + day_sel + "일" + hour_sel + ":" + min_sel + "분에 예약되었습니다",
                                Toast.LENGTH_SHORT);
//                        yes.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                        yes.show();
                    }
                });
        alertDialogBuilder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast no = Toast.makeText(getApplicationContext(), "예약이 취소되었습니다", Toast.LENGTH_SHORT);
//                        no.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                        no.show();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



}