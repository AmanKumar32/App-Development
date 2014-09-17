package com.aman.calculatorapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleCalculatorActivity extends Activity {

	EditText etFirstNumber;
	EditText etSecondNuber;
	TextView displayResult;
	String temp1;
	String temp2;
	int num1;
	int num2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator1);
		etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
		etSecondNuber = (EditText) findViewById(R.id.etSecondNumber);
		displayResult = (TextView) findViewById(R.id.ResultDisplay);
		displayResult.setTextColor(Color.RED);

	}

	public void calculator(View view) {

		try {

			temp1 = etFirstNumber.getText().toString();
			temp2 = etSecondNuber.getText().toString();

			num1 = Integer.parseInt(temp1);
			num2 = Integer.parseInt(temp2);

			switch (view.getId()) {
			case R.id.btnadd:
				displayResult.setText("" + Calculator.add(num1, num2));
				break;
			case R.id.btnsubtract:
				displayResult.setText("" + Calculator.subtract(num1, num2));
				break;
			case R.id.btnmultiply:
				displayResult.setText("" + Calculator.multiply(num1, num2));
				break;
			case R.id.btnremainder:
				displayResult.setText("" + Calculator.remainder(num1, num2));
				break;

			}
		} catch (Exception e) {

			if (temp1.equals("") && temp2.equals("")) {
				displayResult.setText("Please Enter The Numbers????");
			} else if (temp1.equals("")) {
				etFirstNumber.setText("Please Enter First Number");
			} else if (temp2.equals("")) {
				etSecondNuber.setText("Please Enter Second Number");
			}
		}

	}
}
