package com.aman.calculatorapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Toast toast = Toast.makeText(context, "Date Changed SucessFully",
				Toast.LENGTH_LONG);
		toast.show();
	}

}
