package com.aman.calculatorapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class PhotoShopActivity extends Activity {
	ImageView ivResult;
	Uri uri;

	public void imageEffects(View view) {

		ivResult.buildDrawingCache();

		Bitmap imageOriginal = ivResult.getDrawingCache();

		switch (view.getId()) {
		case R.id.btnGrayScale:
			int width,
			height;
			height = imageOriginal.getHeight();
			width = imageOriginal.getWidth();

			Bitmap bmpGrayscale = Bitmap.createBitmap(width, height,
					Bitmap.Config.RGB_565);
			Canvas c = new Canvas(bmpGrayscale);
			Paint paint = new Paint();
			ColorMatrix cm = new ColorMatrix();
			cm.setSaturation(0);
			ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
			paint.setColorFilter(f);
			c.drawBitmap(imageOriginal, 0, 0, paint);

			ivResult.setImageBitmap(bmpGrayscale);
			break;
		case R.id.btnbright:
			Bitmap bmpbright = Bitmap.createBitmap(imageOriginal.getWidth(),
					imageOriginal.getHeight(), imageOriginal.getConfig());

			for (int i = 0; i < imageOriginal.getWidth(); i++) {
				for (int j = 0; j < imageOriginal.getHeight(); j++) {
					int p = imageOriginal.getPixel(i, j);
					int r = Color.red(p);
					int g = Color.green(p);
					int b = Color.blue(p);
					int alpha = Color.alpha(p);

					r = 100 + r;
					g = 100 + g;
					b = 100 + b;
					alpha = 100 + alpha;

					bmpbright.setPixel(i, j, Color.argb(alpha, r, g, b));
				}
			}
			ivResult.setImageBitmap(bmpbright);
			break;
		case R.id.btndark:
			Bitmap bmpdark = Bitmap.createBitmap(imageOriginal.getWidth(),
					imageOriginal.getHeight(), imageOriginal.getConfig());

			for (int i = 0; i < imageOriginal.getWidth(); i++) {
				for (int j = 0; j < imageOriginal.getHeight(); j++) {
					int p = imageOriginal.getPixel(i, j);
					int r = Color.red(p);
					int g = Color.green(p);
					int b = Color.blue(p);
					int alpha = Color.alpha(p);

					r = r - 50;
					g = g - 50;
					b = b - 50;
					alpha = alpha - 50;
					bmpdark.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));

				}
			}

			ivResult.setImageBitmap(bmpdark);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photoshop_layout);
		Intent intent = getIntent();

		Object pathOfImage = intent.getExtras().get(Intent.EXTRA_STREAM);
		// Object pathOfImage =
		// intent.getExtras().get("android.intent.extra.STREAM");
		uri = (Uri) pathOfImage;
		ivResult = (ImageView) findViewById(R.id.ivResult);

		Log.i("Vinay", uri.toString());

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ivResult.setImageURI(uri);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_shop, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onStop() {
		super.onStop();
		finish();
	}
}
