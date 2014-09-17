package com.aman.calculatorapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SortingActivity extends Activity {

	EditText etEnteredNumber;
	TextView tvResultDisplay;
	TextView tvInserstionSort;
	TextView tvSelectionSort;
	TextView tvBubbleSort;
	int[] source;
	long start = 0, stop = 0;

	public void Compute(View v) {
		
		String str = etEnteredNumber.getText().toString();
		try {
			int limit = Integer.parseInt(str);
			switch (v.getId()) {
			case R.id.btnGenRndArray:
				start = System.currentTimeMillis();
				source = SortingCalculator.duplicateArray(limit);
				stop = System.currentTimeMillis();
				tvResultDisplay.setText("Array Of Size " + limit + " Generated");
				break;
			case R.id.btnInsertionSort:
				start = System.currentTimeMillis();
				SortingCalculator.doInsertionSort(source);
				stop = System.currentTimeMillis();
				tvInserstionSort.setText("" + (start - stop) + "ms");
				break;
			case R.id.btnSelectionSort:
				start = System.currentTimeMillis();
				SortingCalculator.SelectionSearch(source);
				stop = System.currentTimeMillis();
				tvSelectionSort.setText("" + (start - stop) + "ms");
				break;
			case R.id.btnBubbleSort:
				start = System.currentTimeMillis();
				SortingCalculator.SelectionSearch(source);
				stop = System.currentTimeMillis();
				tvBubbleSort.setText("" + (start - stop) + "ms");
				break;
			case R.id.btnClear:
				tvInserstionSort.setText("");
				tvResultDisplay.setText("");
				tvSelectionSort.setText("");
				tvBubbleSort.setText("");
				etEnteredNumber.setText("");
				break;
			}

		} catch (Exception e) {
			tvResultDisplay.setTextColor(Color.RED);
			tvResultDisplay.setText("Please Enter the Array Size ??");
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sorting);
		etEnteredNumber = (EditText) findViewById(R.id.etEnteredNumber);
		tvResultDisplay = (TextView) findViewById(R.id.tvResultDisplay);
		tvInserstionSort = (TextView) findViewById(R.id.tvInserstionSort);
		tvSelectionSort = (TextView) findViewById(R.id.tvSelectionSort);
		tvBubbleSort = (TextView) findViewById(R.id.tvBubbleSort);
	}

}
