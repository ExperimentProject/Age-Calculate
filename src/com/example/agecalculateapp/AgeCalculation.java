package com.example.agecalculateapp;

import java.util.Calendar;

public class AgeCalculation {
	private int current_year;
	private int current_month;
	private int current_day;

	private int pre_year;
	private int pre_month;
	private int pre_day;

	private int born_year;
	private int born_month;
	private int born_day;

	private long diff, dDay;

	private int next_month, next_day;
	private Calendar c, p;

	public String getCurrentDate() {
		c = Calendar.getInstance();
		current_day = c.get(Calendar.DAY_OF_MONTH);
		current_month = c.get(Calendar.MONTH);
		current_month++;
		current_year = c.get(Calendar.YEAR);
		return "Current Date :" + current_day + "/" + current_month + "/"
				+ current_year;
	}

	public void setDoB(int sYear, int sMonth, int sDay) {
		p = Calendar.getInstance();
		born_year = sYear;
		p.set(Calendar.YEAR, born_year);
		born_month = sMonth;
		p.set(Calendar.MONTH, born_month);
		born_month++;
		born_day = sDay;
		p.set(Calendar.MONTH, born_day);
	}

	public void calulateYear() {
		if (current_year > born_year) {
			pre_year = current_year - born_year;
		} else if (current_year == born_year) {
			pre_year = 0;
		}
	}

	public void calulateMonth() {
		if (current_month > born_month) {
			pre_month = current_month - born_month;
		} else if (current_month == born_month) {
			pre_month = 0;
		} else {
			pre_month = current_month - born_month;
			pre_month = 12 + pre_month;
			pre_year--;
		}
	}

	public void calulateDay() {
		if (current_day > born_day) {
			pre_day = current_day - born_day;
		} else if (current_day == born_day) {
			pre_day = 0;
		} else {
			pre_day = current_day - born_day;
			pre_day = 12 + pre_day;
			pre_month--;
		}
	}

	public String getAge() {
		return "Your Age is : " + pre_year + " years " + pre_month + " months "
				+ pre_day + " days ";
	}

	public String totalDay() {
		diff = c.getTimeInMillis() - p.getTimeInMillis();
		dDay = diff / (24 * 60 * 60 * 1000);
		dDay++;
		return "Total Days : " + dDay + " days";
	}

	public void cal_month() {
		if (current_month >= born_month) {
			pre_month = current_month - born_month;
			next_month = 12 - pre_month;
		} else {
			pre_month = current_month - born_month;
			pre_month = 12 + pre_month;
			next_month = 12 - pre_month;
		}
	}

	public void cal_day() {
		if (current_day >= born_day) {
			pre_day = current_month - born_day;
			next_day = 30 - pre_month;
			next_month--;
		} else {
			pre_day = current_day - born_day;
			pre_day = 30 + pre_day;
			next_day = 30 - pre_day;
		}
	}

	public String getNextBirthDay() {
		return "Next Birthday in : " + next_month + " months " + next_day
				+ " days";
	}
}
