package com.example.agecalculateapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txtCurrentDate, txtBirthDay, txtCurrentAge, txtTotalDays,
			txtNextDoB;
	AgeCalculation ageCalculation;
	Button btnCalculateAge;

	private int born_year = 1991;
	private int born_month = 10;
	private int born_day = 11;

	static final int DATE_START_DIALOG_ID = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ageCalculation = new AgeCalculation();
		txtCurrentDate = (TextView) findViewById(R.id.txtCurrentDate);
		txtCurrentDate.setText(ageCalculation.getCurrentDate().toString());
		txtBirthDay = (TextView) findViewById(R.id.txtBirthDay);
		txtCurrentAge = (TextView) findViewById(R.id.txtAge);
		txtTotalDays = (TextView) findViewById(R.id.txtDays);
		txtNextDoB = (TextView) findViewById(R.id.txtNextDoB);
		btnCalculateAge = (Button) findViewById(R.id.btnCalculateAge);

		btnCalculateAge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(DATE_START_DIALOG_ID);
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_START_DIALOG_ID:

			return new DatePickerDialog(this, dateSetListener, born_year,
					born_month, born_day);

		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener dateSetListener = new OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			born_year = year;
			born_month = monthOfYear;
			born_day = dayOfMonth;

			txtBirthDay.setText("Birth Date : " + born_day + "/"

			+ (born_month + 1) + "/" + born_year);

			ageCalculation.setDoB(born_year, born_month, born_day);

			calculate();
		}
	};

	public void calculate() {
		ageCalculation.calulateYear();
		ageCalculation.calulateMonth();
		ageCalculation.calulateDay();
		txtCurrentAge.setText(ageCalculation.getAge());
		txtTotalDays.setText(ageCalculation.totalDay().toString());
		ageCalculation.cal_month();
		ageCalculation.cal_day();
		txtNextDoB.setText(ageCalculation.getNextBirthDay());
	}
}
