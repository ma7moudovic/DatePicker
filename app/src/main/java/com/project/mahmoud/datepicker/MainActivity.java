package com.project.mahmoud.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    //test change on the github

    private TextView text_date;
    private DatePicker date_picker;
    private Button button;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentDate();
        addButtonListener();

        date_picker = (DatePicker) findViewById(R.id.datePicker);
        date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    public void setCurrentDate() {

        text_date = (TextView) findViewById(R.id.tv);
        date_picker = (DatePicker) findViewById(R.id.datePicker);

        final Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        text_date.setText(new StringBuilder()

                // Month is 0 based, so you have to add 1
                        .append(month + 1).append("-")
                        .append(day).append("-")
                        .append(year).append(" "));

        // set current date into Date Picker
        date_picker.init(year, month, day, null);

    }
    public void addButtonListener() {

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);
               }

        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener, year, month,day);

        }

        return null;
    }



    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

                // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into Text View
            text_date.setText(new StringBuilder().append(month + 1)
                            .append("-").append(day).append("-").append(year).append(" "));

            // set selected date into Date Picker
            date_picker.init(year, month, day, null);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
