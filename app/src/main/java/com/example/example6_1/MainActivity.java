package com.example.example6_1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart,btnEnd;
    RadioButton rdoCal,rdoTime;
    DatePicker DatePicker1;
    TimePicker TimePicker1;
    TextView tvYear,tvMonth,tvDay,tvHour,tvMinute;
    int selectYear,selectMonth,selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");


        chrono = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        TimePicker1 = (TimePicker) findViewById(R.id.TimePicker1);
        DatePicker1 = (DatePicker) findViewById(R.id.DatePicker1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        TimePicker1.setVisibility(View.INVISIBLE);
        DatePicker1.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker1.setVisibility(View.INVISIBLE);
                DatePicker1.setVisibility(View.VISIBLE);

            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker1.setVisibility(View.VISIBLE);
                DatePicker1.setVisibility(View.INVISIBLE);
            }
        });
        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(DatePicker1.getYear()));
                tvMonth.setText(Integer.toString(1+DatePicker1.getMonth()));
                tvDay.setText(Integer.toString(DatePicker1.getDayOfMonth()));

                tvHour.setText(Integer.toString(TimePicker1.getHour()));
                tvMinute.setText(Integer.toString(TimePicker1.getMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                TimePicker1.setVisibility(View.INVISIBLE);
                DatePicker1.setVisibility(View.INVISIBLE);

                return false;
            }
        });



    }
}