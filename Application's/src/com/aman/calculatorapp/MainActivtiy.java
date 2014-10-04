package com.aman.calculatorapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivtiy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		createNotification();
		setContentView(R.layout.mainactivity_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(1, 1, 0, "About App");
		menu.add(1, 2, 0, "Help");

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast toast;
		switch (item.getItemId()) {
		case 1:
			toast = Toast
					.makeText(
							getBaseContext(),
							"This App Performs Sorting || Basic Calculation || PhotoShop ",
							Toast.LENGTH_LONG);
			toast.show();
			break;
		case 2:
			toast = Toast.makeText(getBaseContext(), "Help Will Be Provided",
					Toast.LENGTH_SHORT);
			toast.show();
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void navigator(View view) {
		switch (view.getId()) {
		case R.id.btncalculator:
			Intent calcintent = new Intent(getBaseContext(),
					SimpleCalculatorActivity.class);

			startActivity(calcintent);
			break;
		case R.id.btnsorting:
			Intent sortintent = new Intent(getBaseContext(),
					SortingActivity.class);
			startActivity(sortintent);
			break;

		}

	}

	public void createNotification() {

		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification.Builder builder = new Notification.Builder(
				getBaseContext());
		Bitmap icon = BitmapFactory.decodeResource(getBaseContext()
				.getResources(), R.drawable.ic_launcher);

		builder.setAutoCancel(true)
				.setContentInfo("Application Launched.. Have Fun!!")
				.setContentText("More info here").setLargeIcon(icon)
				.setSmallIcon(R.drawable.ic_launcher);

		Notification notification = builder.getNotification();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		// led

		notification.ledARGB = 0xFFff0000;
		notification.flags = Notification.FLAG_SHOW_LIGHTS;
		notification.ledOnMS = 100;
		notification.ledOffMS = 100;

		manager.notify(1, notification);

		MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
				R.raw.store);
		mediaPlayer.setLooping(false);
		mediaPlayer.seekTo(43);
		mediaPlayer.start();

		/*
		 * Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		 * vibrator.vibrate(3000);
		 */
	}
}
