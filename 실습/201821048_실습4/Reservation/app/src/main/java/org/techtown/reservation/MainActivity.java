package org.techtown.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

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
            }
        });

        TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                EditText time = (EditText)findViewById(R.id.textTime);
                time.setText(hourOfDay + ":" + minute);
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

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            timePicker.setHour(hour);
            timePicker.setMinute(min);

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            EditText date = (EditText)findViewById(R.id.textDate);
            date.setText(year + "/" + (month+1) + "/" + day);

        }
        return true;
    }
}